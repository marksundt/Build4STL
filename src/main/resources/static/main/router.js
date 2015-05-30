'use strict';
angular
    .module('WebApp')
    .config(function($routeProvider){

    $routeProvider.when('/', {
        templateUrl : 'home/home.html',
        controller : 'HomeCtrl as homeCtrl'
    }).when('/donate', {
        templateUrl : 'donate/donate.html',
        controller : 'DonateCtrl as donateCtrl'
    }).when('/meal', {
        templateUrl : 'meal/meal.html',
        controller : 'MealCtrl as mealCtrl'
    }).when('/register', {
        templateUrl : 'register/register.html',
        controller : 'RegisterCtrl as registerCtrl'
    }).when('/login', {
        templateUrl : 'login/login.html',
        controller : 'LoginCtrl as loginCtrl'
    }).otherwise({
        redirectTo:"/"
    });
});
