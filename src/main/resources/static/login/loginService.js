'use strict';
angular
    .module('WebApp')
    .service('LoginService', ['RestService', 'AuthService', '$location', function(RestService, AuthService, $location) {

        var vm = this;
        vm.login = login;
        vm.logout = logout;
        vm.getAuthentication = getAuthentication;

        // Check if user is authenticated when this service loads, i.e. page refresh
        getAuthentication();

        // Get an auth object for authenticated users
        function getAuthentication(){


            return AuthService.getAuth();
        }

        // Submit login information
        function login(credentials){
            // post login
            var auth = {
                'name': credentials.name,
                'authenticated': true,
                'loginError' : false
            };
            AuthService.setAuth(auth);
            // and return the auth for good measure
            return AuthService.getAuth();
        }

        // Logs out the user from the server
        function logout(){
            //RestService.postLogout();
            // creates an empty object, and hopefully scope isn't all wacked.
            var auth = {
                'name': "",
                'authenticated': false,
                'loginError' : false
            };
            // store the "empty" auth to AuthService
            AuthService.setAuth(auth);
        }

        // Creates an auth from the response of GET /user
        function setAuthFromData(data) {
            // If data contains the name object, then it wasn't the /login redirect that
            // happens when a unauthorized user attempts to access /user
            if(data.data.name) {
                var auth = {
                    'name': data.data.name,
                    'authenticated': data.data.authenticated,
                    'loginError' : false
                };
                // Store this auth to the service
                AuthService.setAuth(auth);
            }
        }

    }]);
