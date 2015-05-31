
angular
    .module('WebApp')
    .service('RestService', ['$http', '$log', function ($http, $log) {

        this.donate = function (donateRequest) {
            var url = 'http://localhost:8080/user/donate';
            var donationObject = {
                method: 'POST',
                url: url,
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                data: donateRequest
            };
            return $http(donationObject);
        };

        this.redeemCode = function (redeemRequest) {
            var url = 'http://localhost:8080/user/redeemCode';
            var redeemObject = {
                method: 'POST',
                url: url,
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                data: redeemRequest
            };
            return $http(redeemObject);
        };

        this.post = function post(req){
            return $http(req);
        };

    }]);
