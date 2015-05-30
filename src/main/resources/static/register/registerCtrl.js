'use strict';
angular
    .module('WebApp')
    .controller('RegisterCtrl', ['$scope', '$http', 'AuthService', 'LoginService', '$location', function($scope, $http, AuthService, LoginService, $location){

        var vm = this;
        vm.isAuth = isAuth;
        vm.credentials = {
            username: "",
            password: ""
        };

        // Checks to see if the user is authenticated
        function isAuth(){
            console.log("home is auth"+AuthService.isAuth() );
            return AuthService.isAuth();
        }

        $scope.register = function(){
            var auth = LoginService.login(vm.credentials);
            if (auth.authenticated){
                $location.path('/donate');
            }
        }

    }]);
