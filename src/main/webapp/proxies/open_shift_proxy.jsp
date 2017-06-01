<%@ page
        import="java.io.*,
            java.net.*,
            javax.net.ssl.HostnameVerifier,
            javax.net.ssl.HttpsURLConnection,
            javax.net.ssl.SSLContext,
            javax.net.ssl.SSLSession,
            javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager,
            java.security.cert.X509Certificate"

        contentType="application/json; charset=UTF-8"
%><%@ page import = "java.util.ResourceBundle" %>
<%

    // ResourceBundle resource = ResourceBundle.getBundle("open_shift_proxy");
    // String url=resource.getString("url");

    String token = request.getParameter("token");
    // String openshift_url = request.getParameter("openshift_url");
    String openshift_url = "https://ocpnp-dev.fhlmc.com:8443/api/v1/namespaces/jb-demo/pods";
    // System.out.println("OS URL: " + openshift_url);
    // http://www.nakov.com/blog/2009/07/16/disable-certificate-validation-in-java-ssl-connections/
    // Create a trust manager that does not validate certificate chains
    TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
    };

    // Install the all-trusting trust manager
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    // Create all-trusting host name verifier
    HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

    StringBuffer sbf = new StringBuffer();
    //Access the page
    try {
        // java.net.URL obj = new URL("https://ocpnp-dev.fhlmc.com:8443/api/v1/namespaces/mwe-demo/pods");
        java.net.URL obj = new URL(openshift_url);
        // URL url = new URL("http://localhost:8080/");
        /* ---------------------------------------------------------------------------------------------------- */
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		//add reuqest header
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("Cache-Control", "no-cache");
        con.setRequestProperty("Authorization", "Bearer " + token);

        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			sbf.append(inputLine);
		}
		in.close();
    } catch (MalformedURLException e) {
        %><%= "BAD URL " %><%
    } catch (IOException e) {
        sbf.append(e.getMessage());
    }
%><%= sbf.toString() %>