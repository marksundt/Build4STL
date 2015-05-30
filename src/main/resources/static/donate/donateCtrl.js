'use strict';
angular
    .module('WebApp')
    .controller('DonateCtrl', ['$scope', '$http', 'AuthService','$location', function($scope, $http, AuthService,$location){

        var vm = this;
        vm.isAuth = isAuth;

        var auth = AuthService.getAuth();
        if(!auth.authenticated){
            $location.path('/login');
        }

        $scope.name= auth.name;
        $scope.newCard=false;

        // Checks to see if the user is authenticated
        function isAuth(){
            console.log("home is auth"+AuthService.isAuth() );
            return AuthService.isAuth();
        }

    }]);
