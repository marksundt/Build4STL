'use strict';
angular
    .module('WebApp')
    .controller('DonateCtrl', ['$scope', '$http', 'AuthService','$location','RestService', function($scope, $http, AuthService,$location,RestService){

        var vm = this;
        vm.isAuth = isAuth;

        var auth = AuthService.getAuth();
        if(!auth.authenticated){
            $location.path('/login');
        }

        $scope.name= auth.name;
        $scope.newCard=false;
        $scope.dropDownLabel = 'Select donation payment method';
        $scope.donationSuccessful = false;
        $scope.errorMessage = "";

        $scope.setCard = function(card){
            if (card=="new"){
                $scope.dropDownLabel = 'Donate using another card';
                $scope.newCard=true;
            }else{
                $scope.dropDownLabel = 'Donate using card ending in ' + card;
                $scope.newCard=false;
            }

        };

        $scope.makeDonation=function(tran) {
            if (tran.card){
                tran.card = stripAlpha(tran.card);
            }
            if (tran.expDate){
                tran.expDate = stripAlpha(tran.expDate);
            }
            if (tran.phone){
                tran.phone = stripAlpha(tran.phone);
            }
            console.dir(tran);
            RestService.donate(tran)
                .success(function(data){
                    $scope.donationSuccessful = true;
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

    }]);
