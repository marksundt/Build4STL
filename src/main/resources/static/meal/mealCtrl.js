'use strict';
angular
    .module('WebApp')
    .controller('MealCtrl', ['$scope', '$http', 'AuthService', 'LoginService', '$location','RestService', function($scope, $http, AuthService, LoginService, $location,RestService){

        var vm = this;
        vm.isAuth = isAuth;

        vm.credentials = {
            username: "",
            password: ""
        };

        $scope.errorMessage = "";
        $scope.codeSuccessful = false;

        $scope.redeemCode=function(tran) {
            if (tran.name){
                stripAlpha(tran.name);
            }
            if (tran.phone){
                stripAlpha(tran.phone);
            }
            console.dir(tran);
            RestService.redeemCode(tran)
                .success(function(data){
                    $scope.code = data.code;
                    $scope.codeSuccessful = true;
                    $scope.errorMessage = "";
                    console.log('here is the data');
                    console.dir(data);

                })
                .error(function(data){
                    $scope.errorMessage = "Opps";
                    console.log('here is the error');
                    console.dir(data);
                });
        };

        function stripAlpha(s,allowDecimal){
            if(allowDecimal){
                return s.replace(/[^0-9\.]+/g, '');
            } else {
                return s.replace(/[^0-9]+/g, '');
            }
        }

        // Checks to see if the user is authenticated
        function isAuth(){
            console.log("home is auth"+AuthService.isAuth() );
            return AuthService.isAuth();
        }

        $scope.getCode2 = function(){
            $scope.code = getRandom(111111111111,999999999999);
            $scope.codeSuccessful = true;
        };

        function getRandom(min,max) {
            return Math.floor(Math.random()*(max-min+1)+min);
        }

    }]);
