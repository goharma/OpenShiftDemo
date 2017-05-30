package mwe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.openshift.DeploymentConfig;

import javax.net.ssl.*;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by c43144 on 5/30/2017.
 */



@Path("/")
public class RESTProxy {

    //
    // For ssl connection to os master, just going to fake it.
    //
    private HostnameVerifier fakeHostnameVerifier(){

        HostnameVerifier NullHostnameVerifier = new HostnameVerifier() {
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        };

        return NullHostnameVerifier;
    }

    private SSLContext fakeSSLContext(){
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };


        SSLContext sc = null;

        try{
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        }catch(Exception e){}

        return sc;
    }


    @PUT
    @Path("/rest/dc_proxy_put_rest/{token}/{project}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putDeploymentConfig(@PathParam("token") String token, @PathParam("project") String project, InputStream incomingData){
        System.out.println("DEPLOYMENT CONFIG");
        String BASE_URI= "https://ocpnp-dev.fhlmc.com:8443/oapi/v1/namespaces/" + project + "/deploymentconfigs/" + project;

        StringBuilder sb = new StringBuilder();
        DeploymentConfig dc = null; // OpenShift DeploymentConfig
        Response response = null;
        ObjectMapper mapper = new ObjectMapper(); // Maps json body data to DeploymentConfig object


        // Read the body data
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while((line = in.readLine()) != null){
                sb.append(line);
            }
        }catch(Exception e){
            System.out.println("Error parseing - ");
        }


        try{
            // Convert json string data to DeploymentConfig object
            dc = mapper.readValue(sb.toString(), DeploymentConfig.class);

            // JAX-RS Client
            Client client = ClientBuilder.newBuilder()
                    .hostnameVerifier(fakeHostnameVerifier()) // Don't verify hostnames
                    .sslContext(fakeSSLContext()) // Trust everything
                    .build();

            // Add the token to the client
            Feature feature = OAuth2ClientSupport.feature(token);
            client.register(feature);

            // JAX-RS WebTarget
            WebTarget target=client.target(BASE_URI);

            // Make the PUT request to OS master
            response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(dc));


        }catch(Exception e){}

        return response;
    }
}
