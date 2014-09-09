(function(){
    'use strict';

    angular.module('geo.services', ['ngResource']);

    function Geo($resource, $http, BaseUrl){
        var geoResource = $resource(BaseUrl + '/geo/:geoId',{geoId:'@_id'});

        geoResource.cercanos = function(pointId, dibujarCercanos, errorEnTransaccion){
            $http.get(BaseUrl + '/geo/'+pointId+'/cercanos')
                .success(dibujarCercanos).error(errorEnTransaccion);
        };

        return geoResource;
    }

    angular
        .module('geo.services')
        .constant('BaseUrl', 'http://localhost:8080/PruebaConceptoGeo-1.0-SNAPSHOT/rest')
        .factory('Geo', Geo)
        ;
})();