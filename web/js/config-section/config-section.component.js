angular.module('configSection').component('configSection', {
    templateUrl: 'js/config-section/config-section.template.html',
    controller: ['$scope', '$http', '$interval', '$cookies', 'Appconfig', function ConfigSectionController($scope, $http, $interval, $cookies, Appconfig) {
        // this.demo_openshift_url = 'https://ocpnp-dev.fhlmc.com:8443/oapi/v1';
        this.dev_openshift_proxy_url = 'mocks/open_shift_proxy.jsp';
        this.demo_openshift_proxy_url = 'proxies/open_shift_proxy.jsp';


        this.appConfig = {
            "openshift_proxy_url":"",
            "openshift_token": "",
            "request_count": "",
            "mwe_env": "demo"
        };

        this.hideConfig = 1;

        this.initEnvDev = function () {
            Appconfig.openshift_proxy_url = this.dev_openshift_proxy_url;
            Appconfig.openshift_token = 'NA';
            Appconfig.request_count = '10';
            Appconfig.mwe_env = 'dev';
            this.appConfig = Appconfig;
        };

        this.initEnvDemo = function () {
            Appconfig.openshift_proxy_url = this.demo_openshift_proxy_url;
            Appconfig.openshift_token = 'NA';
            Appconfig.request_count = '100';
            Appconfig.mwe_env = 'demo';
            this.appConfig = Appconfig;
        };


        this.setEnvCustom = function () {
            Appconfig.openshift_proxy_url = $cookies.get('openshift_proxy_url');
            Appconfig.openshift_token = $cookies.get('openshift_token');
            Appconfig.request_count = $cookies.get('request_count');
            Appconfig.mwe_env = $cookies.get('mwe_env');

            this.appConfig = Appconfig;
        };

        this.change = function(){
            if(Appconfig.mwe_env == 'dev'){ this.initEnvDev(); }
            else if(Appconfig.mwe_env == 'demo'){ this.initEnvDemo(); }
            else{ this.setEnvCustom(); }
        };

        this.update = function () {

            $cookies.put('mwe_env', Appconfig.mwe_env);
            $cookies.put('openshift_proxy_url', Appconfig.openshift_proxy_url);
            $cookies.put('request_count', Appconfig.request_count);
            $cookies.put('openshift_token', Appconfig.openshift_token);


            console.log("openshift_proxy_url   :" + Appconfig.openshift_proxy_url);
            console.log("openshift_token :" + Appconfig.openshift_token);
            console.log("request_count   :" + Appconfig.request_count);
            console.log("mwe_env   :" + Appconfig.mwe_env);

            $scope.$parent.$broadcast('appConfig_Update', Appconfig.appConfig);
        };

        this.initAppConfig = function(){

            Appconfig.openshift_proxy_url = $cookies.get('openshift_proxy_url');
            Appconfig.openshift_token = $cookies.get('openshift_token');
            Appconfig.request_count = $cookies.get('request_count');
            Appconfig.mwe_env = $cookies.get('mwe_env');
            this.appConfig = Appconfig;
            $scope.$parent.$broadcast('appConfig_Update', this.appConfig);
        };
        /* Check for env cookie and set the env */
        this.cookie_env = $cookies.get('mwe_env');

        // If no cookie initialize to default
        if(this.cookie_env == null){
            this.initEnvDemo();
        }else { // If cookie, set values from cookies
            this.initAppConfig();
        }
        $scope.$parent.$broadcast('appConfig_Update', Appconfig.appConfig);
        console.log("openshift_proxy_url   :" + Appconfig.openshift_url);
        console.log("openshift_token :" + Appconfig.openshift_token);
        console.log("request_count   :" + Appconfig.request_count);
        console.log("env   :" + Appconfig.mwe_env);

    }]
});