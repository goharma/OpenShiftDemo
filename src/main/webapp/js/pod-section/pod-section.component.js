angular.
    module('podSection').
    component('podSection', {
        templateUrl: 'js/pod-section/pod-section.template.html',
        controller: ['$q', '$scope', '$http', '$interval', '$cookies', 'Appconfig', function PodSectionController($q, $scope, $http, $interval, $cookies, Appconfig) {
            // $scope.url = 'http://localhost:8080/Angular_Tutorial/json/pods.json';
            // $cookies.put('pod_url','http://localhost:8080/Angular_Tutorial/json/pods.json');
            // $scope.openshift_proxy_url= $cookies.get('openshift_proxy_url');
            $scope.status="Getting URL";
            $scope.lastUpdate = new Date().toLocaleTimeString();
            // $scope.new_pods = {};
            $scope.pods = { items: []};
            // $scope.pods.items = [];


            $scope.getUrl = function () {
                return $q(
                    function(resolve, reject) {
                        //console.log(Appconfig.openshift_proxy_url + "?token=" + Appconfig.openshift_token);
                        $http.get(
                            Appconfig.openshift_proxy_url + "?token=" + Appconfig.openshift_token
                        ).then(
                            /* SUCCESS */
                            function (response) {
                                $scope.new_pods = response.data;

                                // For every new pod not in current, set it's class to fade in
                                $scope.new_pods.items.forEach(
                                    function (pod) {
                                        name = pod.metadata.name;
                                        exists = $scope.pods.items.filter(function (pod) {
                                            return pod.metadata.name === name;
                                        });
                                        if (exists.length == 0) {
                                            pod.class = "pod animated bounceInUp " + pod.status.phase.toLowerCase();
                                            console.log(pod.class);
                                        }else{
                                            pod.class = "pod animated rubberBand " + pod.status.phase.toLowerCase();
                                        }
                                    }
                                );
                                // For every pod not in new pod, set it's class to fade out
                                $scope.pods.items.forEach(
                                    function (pod) {
                                        name = pod.metadata.name;
                                        exists = $scope.new_pods.items.filter(function (pod) {
                                            return pod.metadata.name === name;
                                        });
                                        if (exists.length == 0) {
                                            pod.class = "animated bounceOutDown " + pod.status.phase.toLowerCase();
                                            console.log(pod.class);
                                        }
                                    }
                                );
                                Appconfig.podcount = $scope.pods.items.length;

                                resolve();
                            },
                            /* FAIL */
                            function (response) {
                                $scope.pods = response.data;
                                reject();
                            }
                        );
                    }
                )
            };

            $interval(function () {
                var promise = $scope.getUrl();
                promise.then(function() {
                    $scope.pods=$scope.new_pods;
                }, function(reason) {
                    $scope.pods=$scope.new_pods;
                });

                lastUpdate = new Date().toLocaleTimeString();
                $scope.$parent.$broadcast("podsUpdated", lastUpdate);
            }, 5000);

            var promise = $scope.getUrl();
            promise.then(function() {
                $scope.pods=$scope.new_pods;
            }, function(reason) {
                $scope.pods=$scope.new_pods;
            });

            $scope.$on('appConfig_Update', function (event, appConfig) {
                $scope.openshift_proxy_url=Appconfig.openshift_proxy_url; // 'Data to send'
                $scope.getUrl();
            });
        }]
    });