angular.
    module('infoSection').
    component('infoSection', {
        templateUrl: 'js/info-section/info-section.template.html',
        controller: ['$http','$scope', 'Status', function InfoSectionController($http, $scope, Status) {
            $scope.status=Status.message;
            $scope.lastUpdate = new Date().toLocaleTimeString();
            $scope.testStatus="Ready";


            $http.get(
                'tests/hostname.jsp'
            ).then(
                function(response){
                    $scope.pod=response.data;
                }

            );

            // listen for the event in the relevant $scope
            $scope.$on('podsUpdated', function (event, data) {
                $scope.lastUpdate=data; // 'Data to send'
            });

            $scope.$on('testStatusUpdate', function (event, data) {
                $scope.testStatus=data; // 'Data to send'
            });
        }]
    });