<%@ page import="java.net.InetAddress,
                 java.net.UnknownHostException" %>
<%@ page import="java.net.InetAddress" %>
<%
InetAddress ip=null;
String hostname="";
StringBuffer sb = new StringBuffer();


try{
    ip= InetAddress.getLocalHost();
    hostname=ip.getHostName();

    sb.append(hostname);
}catch(UnknownHostException e){

}
%>
<%= hostname %>
