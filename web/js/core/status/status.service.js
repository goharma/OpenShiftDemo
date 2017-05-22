angular.
    module('core.status').
        factory('Status',
            function() {
                var status = {};

                status.message = 'Init';

                return status;
            }
        );