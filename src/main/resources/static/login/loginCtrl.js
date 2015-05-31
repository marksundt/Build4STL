'use strict';
angular
    .module('WebApp')
    .controller('LoginCtrl', ['LoginService', 'AuthService','$location', function(LoginService, AuthService,$location) {

        var vm = this;
        vm.credentials = {
            username: "",
            password: ""
        };
        vm.login = login;
        vm.logout = logout;
        vm.isAuth = isAuth;
        vm.getAuth = getAuth;

        //$scope.level = AuthService.auth.level;

        // Logs user in with credentials
        function login(){
            console.dir(vm.credentials);
            var auth = LoginService.login(vm.credentials);
            if (auth.authenticated){
                if (getAuth().level == 'admin') {
                    $location.path('/');
                } else {
                    $location.path('/donate');
                }
            }

        }

        // Logs the user out from the AuthService, and with the server
        function logout() {
            LoginService.logout();
            $location.path('/');
        }

        // Returns T/F if user is authenticated
        function isAuth(){
            return AuthService.isAuth();
        }

        function getAuth(){
            return AuthService.getAuth();
        }

    }]);
