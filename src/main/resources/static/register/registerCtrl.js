'use strict';
angular
    .module('WebApp')
    .controller('RegisterCtrl', ['$scope', '$http', 'AuthService', function($scope, $http, AuthService){

        var vm = this;
        vm.isAuth = isAuth;


        // Checks to see if the user is authenticated
        function isAuth(){
            console.log("home is auth"+AuthService.isAuth() );
            return AuthService.isAuth();
        }

    }]);
