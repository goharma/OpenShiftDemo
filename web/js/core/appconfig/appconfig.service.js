angular.
    module('core.appconfig').
        factory('Appconfig',
            function() {
                return appConfig = {
                    "openshift_proxy_url":"mocks/open_shift_proxy.jsp",
                    "openshift_token": "AAAAA",
                    "request_count": "10",
                    "mwe_env": "demo"
                };

                return status;
            }
);