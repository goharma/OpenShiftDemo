angular.
    module('infoSection').
    component('infoSection', {
        templateUrl: 'js/info-section/info-section.template.html',
        controller: ['$scope', 'Status', function InfoSectionController($scope, Status) {
            $scope.status=Status.message;
            $scope.lastUpdate = new Date().toLocaleTimeString();
            $scope.testStatus="Ready";

            // listen for the event in the relevant $scope
            $scope.$on('podsUpdated', function (event, data) {
                $scope.lastUpdate=data; // 'Data to send'
            });

            $scope.$on('testStatusUpdate', function (event, data) {
                $scope.testStatus=data; // 'Data to send'
            });
        }]
    });