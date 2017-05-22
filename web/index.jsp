<%--
  Created by IntelliJ IDEA.
  User: koydo
  Date: 5/19/2017
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="demoApp">
  <head>
    <title>Angular Tutorial</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-cookies.js"></script>
    <link rel="stylesheet" type="text/css" href="css/demoapp.css">

  </head>
  <body>
    <div id="left">
      <div id="pod-section-container"><pod-section></pod-section></div>
    </div>
    <div id="right">
      <div id="test-section-container"><test-section></test-section></div>
      <div id="info-section-container"><info-section></info-section></div>
      <div>
        <config-section></config-section>
      </div>
    </div>



    <script src="js/demoapp.js"></script>

    <script src="js/core/core.module.js"></script>

    <script src="js/core/status/status.module.js"></script>
    <script src="js/core/status/status.service.js"></script>

    <script src="js/pod-section/pod-section.module.js"></script>
    <script src="js/pod-section/pod-section.component.js"></script>

    <script src="js/test-section/test-section.module.js"></script>
    <script src="js/test-section/test-section.component.js"></script>

    <script src="js/info-section/info-section.module.js"></script>
    <script src="js/info-section/info-section.component.js"></script>

    <script src="js/config-section/config-section.module.js"></script>
    <script src="js/config-section/config-section.component.js"></script>
  </body>
</html>
