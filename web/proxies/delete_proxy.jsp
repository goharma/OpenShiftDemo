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
%><%
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

    String namespace = request.getParameter("namespace");
    String pod = request.getParameter("pods");
    String token = request.getParameter("token");

    try {
        URL obj = new URL("https://ocpnp-dev.fhlmc.com:8443/api/v1/namespaces/" + namespace + "/pods/" + pod);
        // URL url = new URL("http://localhost:8080/");
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        //add reuqest header
        con.setRequestMethod("DELETE");
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
        %><%= "{ response: {status: FAIL}}" %><%
    } catch (IOException ioe) {
        %><%= "{ response: {status: FAIL}}" %><%
    } catch (Exception e){
        %><%= "{ response: {status: FAIL}}" %><%
    }
%><%= sbf.toString() %>