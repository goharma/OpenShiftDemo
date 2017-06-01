angular.
    module('podSection').
    component('podSection', {
        templateUrl: 'js/pod-section/pod-section.template.html',
        controller: ['$scope', '$http', '$interval', '$cookies', 'Appconfig', function PodSectionController($scope, $http, $interval, $cookies, Appconfig) {
            // $scope.url = 'http://localhost:8080/Angular_Tutorial/json/pods.json';
            // $cookies.put('pod_url','http://localhost:8080/Angular_Tutorial/json/pods.json');
            // $scope.openshift_proxy_url= $cookies.get('openshift_proxy_url');
            $scope.status="Getting URL";
            $scope.lastUpdate = new Date().toLocaleTimeString();

            $scope.getUrl = function () {
                //console.log(Appconfig.openshift_proxy_url + "?token=" + Appconfig.openshift_token);
                $http.get(
                    Appconfig.openshift_proxy_url + "?token=" + Appconfig.openshift_token
                ).then(
                    /* SUCCESS */
                    function (response) {
                        $scope.pods = response.data;
                        Appconfig.podcount = $scope.pods.items.length;
                    },
                    /* FAIL */
                    function (response) {
                        $scope.pods = response.data;
                    }
                );
            };

            $interval(function () {
                $scope.getUrl();
                lastUpdate = new Date().toLocaleTimeString();
                $scope.$parent.$broadcast("podsUpdated", lastUpdate);
            }, 2000);

            $scope.getUrl();

            $scope.$on('appConfig_Update', function (event, appConfig) {
                $scope.openshift_proxy_url=Appconfig.openshift_proxy_url; // 'Data to send'
                $scope.getUrl();
            });
        }]
    });