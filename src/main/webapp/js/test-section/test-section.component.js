angular.
    module('testSection').
    component('testSection', {
        templateUrl: 'js/test-section/test-section.template.html',
        controller: ['$timeout', '$interval', '$scope','$http','$cookies','Status', 'Appconfig',function TestSectionController($timeout, $interval, $scope, $http, $cookies, Status, Appconfig) {
            /* RUN TESTS */
            $scope.hideTest0 = 0;
            $scope.hideTest1 = 1;
            $scope.hideTest2 = 1;
            $scope.hideTest3 = 1;

            this.myreplicas = null;

            $scope.change = function () {
                switch ($scope.test.name) {
                    case $scope.tests[0].name:
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 0;
                        $scope.hideTest2 = 1;
                        $scope.hideTest3 = 1;
                        break;
                    case $scope.tests[1].name:
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 1;
                        $scope.hideTest2 = 0;
                        $scope.hideTest3 = 1;
                        break;
                    case $scope.tests[2].name:
                        $scope.hideTest0 = 1;
                        $scope.hideTest1 = 1;
                        $scope.hideTest2 = 1;
                        $scope.hideTest3 = 0;
                        break;
                }
            };

            $scope.tests = [
                {id: 1, name: 'Auto-Scaling (CPU)'},
                {id: 2, name: 'External Tool Scaling (Session Count)'},
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
                        $scope.url = 'tests/autoscale_cpu.jsp?duration=1';
                        Appconfig.replicas=1;
                        dc = setdeploymentconfig();
                        // Appconfig.replicas=dc.status.replicas;
                        $scope.$parent.$broadcast('testStatusUpdate', "Set number of pods to 1");

                        $scope.$watch(
                            function(){ return Appconfig.podcount; },
                            function(podcount){
                                $scope.$parent.$broadcast('testStatusUpdate', "Current pod count: " + podcount);
                                if(podcount == 1){

                                    $scope.$parent.$broadcast('testStatusUpdate', "Starting Test.");
                                    $http.get($scope.url).then(
                                        /* success */
                                        function(response) {
                                            $scope.$parent.$broadcast('testStatusUpdate', "SUCCESS");
                                        },
                                        /* failure */
                                        function(error) {
                                            $scope.$parent.$broadcast('testStatusUpdate', "FAIL");
                                        }
                                    );
                                }else{
                                    $scope.$parent.$broadcast('testStatusUpdate', "Waiting for pods count to be 1");
                                }
                            }
                        );



                        break;
                    case $scope.test_enum.AUTO_SCALING_REQ:
                        $scope.$parent.$broadcast('testStatusUpdate', "Running Auto Scaling (Requests) Test");

                        // url = 'https://ocpnp-dev.fhlmc.com:8443/oapi/v1';
                        $scope.url = 'tests/autoscale_request.jsp';

                        // poll for number of sessions

                        // when session count reaches threashold increase replicas
                        dc = setdeploymentconfig();


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
                            /* FAIL */
                            function(response){
                                $scope.testStatus = "FAILURE";
                                $scope.$parent.$broadcast('testStatusUpdate', 'FAILED');
                            }
                        );
                        break;
                }
            };

            getreplicacount = function(){
                dc_proxy_url='proxies/dc_proxy_get.jsp?token=' + Appconfig.openshift_token;
                $scope.replicas=0;

                $http.get(dc_proxy_url).then(
                    /* Success */
                    function (response) {
                        $scope.replicas = response.data.status.replicas;
                    }
                );

                return $scope.replicas;
            };

            setdeploymentconfig = function(){
                console.log("setdeploymentconfig");
                // Deployment configs url
                oc_url = 'https://ocpnp-dev.fhlmc.com:8443';
                dc_url = '/oapi/v1/namespaces/mwe-demo/deploymentconfigs/ms-mwe-demo';
                dc_proxy_url='proxies/dc_proxy_get.jsp?token=' + Appconfig.openshift_token;

                // First get the DeploymentConfig
                $http.get(dc_proxy_url).then(
                    /* Success */
                    function (response) {
                        $scope.dc = response.data;

                // Update replicas to what you want
                        $scope.dc.spec.replicas=Appconfig.replicas;
                    }
                // Then PUT the updated DeploymentConfig
                    ).then( //
                    function(response){
                        // Update replicas
                        // $scope.dc.spec.replicas = replicas;
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
                            function(response){
                                console.log(response.data)
                            }
                        )
                    }
                );

                return $scope.dc;
            }
        }]
    });