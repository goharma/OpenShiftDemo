angular.
    module('testSection').
    component('testSection', {
        templateUrl: 'js/test-section/test-section.template.html',
        controller: ['$scope','$http','$cookies','Status', 'Appconfig',function TestSectionController($scope, $http, $cookies, Status, Appconfig) {
            /* RUN TESTS */
            $scope.hideTest0 = 0;
            $scope.hideTest1 = 1;
            $scope.hideTest2 = 1;
            $scope.hideTest3 = 1;

            $scope.change = function () {
                switch ($scope.test.name) {
                    case "Auto-Scaling (CPU)":
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 0;
                        $scope.hideTest2 = 1;
                        $scope.hideTest3 = 1;
                        break;
                    case "Auto-Scaling (Requests)":
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 1;
                        $scope.hideTest2 = 0;
                        $scope.hideTest3 = 1;
                        break;
                    case "High Availability":
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 1;
                        $scope.hideTest2 = 1;
                        $scope.hideTest3 = 0;
                        break;
                }
            };

            $scope.tests = [
                {id: 1, name: 'Auto-Scaling (CPU)'},
                {id: 2, name: 'Auto-Scaling (Requests)'},
                {id: 3, name: 'High Availability'}
            ];
            $scope.test_enum = {
                AUTO_SCALING_CPU: 1,
                AUTO_SCALING_REQ: 2,
                HA: 3
            };

            $scope.updateTestResults = function (resultStr) {
                $scope.testResults = resultStr;
            };

            $scope.run_test = function () {
                switch ($scope.test.id) {
                    case $scope.test_enum.AUTO_SCALING_CPU:
                        $scope.$parent.$broadcast('testStatusUpdate', "Running Auto Scaling (CPU) Test");
                        // url = 'https://ocpnp-dev.fhlmc.com:8443/oapi/v1';
                        $scope.url = 'tests/autoscale_cpu.jsp?duration=20';
                        $scope.request_count = 100;
                        /*for (i = 0; i < 20; i++) {
                            $scope.testResults = i;
                            $http.get(url
                            ).then(function (response) {
                                $scope.testdata = response.data;
                                $scope.testResults = "COMPLETE";
                            });
                        }*/
                        $http.get($scope.url).then(
                            /* success */
                            function(response) {
                                // console.log("Your name is: " + response.data);
                                $scope.$parent.$broadcast('testStatusUpdate', "SUCCESS");
                            },
                            /* failure */
                            function(error) {
                                // console.log("The request failed: " + error);
                                $scope.$parent.$broadcast('testStatusUpdate', "FAIL");
                            }
                        );
                        break;
                    case $scope.test_enum.AUTO_SCALING_REQ:
                        $scope.$parent.$broadcast('testStatusUpdate', "Running Auto Scaling (Requests) Test");

                        // url = 'https://ocpnp-dev.fhlmc.com:8443/oapi/v1';
                        $scope.url = 'tests/autoscale_request.jsp';


                        dc = $scope.setdeploymentconfig(Appconfig.replicas);


                        $scope.request_count = $cookies.get('request_count');

                        break;

                    case $scope.test_enum.HA:
                        /* ~~~~~~~~~~~~~~~~~~~~~~ */
                        /* High Availability Test */
                        /* ~~~~~~~~~~~~~~~~~~~~~~ */
                        $scope.url = 'test/ha.jsp';
                        $scope.$parent.$broadcast('testStatusUpdate', "Running High Availability Test");
                        console.log("Starting HA Test");
                        $http.get(
                            $scope.url
                        ).then(
                            /* Success */
                            function (response) {

                                $scope.testdata = response.data;
                                $scope.testname = $scope.testdata.response[0].name;
                                // alert("DEBUG: Called test:" + $scope.testname + " at " + url);
                                $scope.getUrl();
                                $scope.$parent.$broadcast('testStatusUpdate', "SUCCESS");
                            },
                            /* FAILE */
                            function(response){
                                $scope.testStatus = "FAILURE";
                                $scope.$parent.$broadcast('testStatusUpdate', 'FAILED');
                            }
                        );
                        break;
                }
            };

            $scope.setdeploymentconfig = function(replicas){
                console.log("setdeploymentconfig");
                // Deployment configs url
                oc_url = 'https://ocpnp-dev.fhlmc.com:8443';
                dc_url = '/oapi/v1/namespaces/mwe-demo/deploymentconfigs/ms-mwe-demo';
                dc_proxy_url='proxies/dc_proxy_get.jsp?token=' + Appconfig.openshift_token;

                $http.get(dc_proxy_url).then(
                    /* Success */
                    function (response) {
                        $scope.dc = response.data;
                        $scope.dc.spec.replicas=replicas
                    }
                ).then(
                    function(response){
                        // Update replicas
                        $scope.dc.spec.replicas = replicas;
                        console.log($scope.dc);
                        $http(
                            {

                                method: 'PUT',
                                url: 'OpenShiftDemo/rest/dc_proxy_put_rest/' + Appconfig.openshift_token + "/" + Appconfig.project,
                                headers: {
                                    'Accept': '*/*',
                                    'Cache-Control': 'no-cache',
                                    'Authorization': 'Bearer' +  Appconfig.openshift_token,
                                    'Content-Type': 'application/json'
                                },
                                data: $scope.dc
                            }
                        ).then(
                            function(response){
                                console.log("OK")
                            },
                            function(){
                                console.log(response.data)
                            }
                        )
                    }
                );

                return $scope.dc;
            }
        }]
    });