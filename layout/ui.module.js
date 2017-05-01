/**
 * Created by nisha on 5/1/2017.
 */
var app =  angular
    .module('ui', [ 'ngRoute','ngCookies'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/signin', {
                templateUrl: 'index.html',
                controller: 'signincontroller'
            })
            .when('/movie-login',{
                templateUrl:'movie.tmpl.html',
                controller:'movieadmincontroller'
            })
            .when('/movie-detail/:id',{
                templateUrl:'moviedetail.tmpl.html',
                controller:'moviedetailcontroller'
            })
            .when('/signup',{
                templateUrl:'signup.tmpl.html',
                controller:'signupcontroller'
            })
            .when('/log-out',{
                templateUrl:'logout.tmpl.html',
                controller:'logoutcontroller'
            })
            .when('/movie-admin',{
                templateUrl:'movie.tmpl.html',
                controller:'movieadmincontroller'
            })
            .otherwise({
                redirectTo: '/signin'
            });
    }).run(function() {
        console.log('App Started');
    });