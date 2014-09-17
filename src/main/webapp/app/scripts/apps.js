(function () {
    'use strict';

    angular.module('geo', ['ngRoute','geo.controllers']);

    function config($locationProvider, $routeProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                templateUrl: '/views/geo-home.tpl.html',
                controller: 'GeoHomeCtrl',
                controllerAs: 'geohome'
            })
            .when('/geo/:geoId',{
                templateUrl: '/views/geo-cercanos.tpl.html',
                controller: 'GeoCercanosCtrl',
                controllerAs: 'geodetail'
            })
            .when('/list', {
                templateUrl: '/views/geo-list.tpl.html',
                controller: 'GeoListCtrl',
                controllerAs: 'geolist'
            })
            .when('/new',{
                templateUrl: '/views/geo-create.tpl.html',
                controller: 'GeoCreateCtrl',
                controllerAs: 'geocreate'
            });
    }

    angular
        .module('geo')
        .config(config);
})();