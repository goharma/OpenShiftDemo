angular.
    module('core.jboss').
        factory('Jboss', ['$resource',
            function($resource) {
                this.url = 'http://localhost:9990/management';
                this.paramDefaults = null;
                this.actions = null;
                this.options = null;

                this.actions = {'getSessionCount':
                    {method: 'GET', }
                };

                return $resource(
                    url, // url
                    paramDefaults, // paramDefaults
                    actions, // actions
                    options //
                );
            }
]);