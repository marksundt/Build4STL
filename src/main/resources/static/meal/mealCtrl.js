'use strict';
angular
    .module('WebApp')
    .controller('MealCtrl', ['$scope', '$http', 'AuthService', 'LoginService', '$location', function($scope, $http, AuthService, LoginService, $location){

        var vm = this;
        vm.isAuth = isAuth;

        vm.credentials = {
            username: "",
            password: ""
        };

        $scope.codeSuccessful = false;

        // Checks to see if the user is authenticated
        function isAuth(){
            console.log("home is auth"+AuthService.isAuth() );
            return AuthService.isAuth();
        }

        $scope.getCode = function(){
            $scope.code = getRandom(111111111111,999999999999);
            $scope.codeSuccessful = true;
        };

        function getRandom(min,max) {
            return Math.floor(Math.random()*(max-min+1)+min);
        }

    }]);
