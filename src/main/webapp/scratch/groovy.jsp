<%@ page import="javax.script.*" %>
<%@ page import="import groovy.util.Eval" %>

<html>
    <head>

    </head>
    <body>
    <%
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        StringBuffer sb = new StringBuffer();
        Integer sum = 0;

        try{
            sum = (Integer) engine.eval("(1..10).sum()");
        }catch (Exception e){
            sb.append(e.getMessage());
        }

    %>

    <%= sb.toString() %>
    </body>
</html>

