(function(){
    'use strict';

    angular.module('geo.services', ['ngResource']);

    function Geo($resource, BaseUrl){
        return $resource(BaseUrl + '/geo/:geoId',{geoId:'@_id'});
    }

    angular
        .module('geo.services')
        .constant('BaseUrl', 'http://localhost:8080/PruebaConceptoGeo-1.0-SNAPSHOT/rest')
        .factory('Geo', Geo)
        ;
})();