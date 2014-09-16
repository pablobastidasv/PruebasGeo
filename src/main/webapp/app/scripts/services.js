(function(){
    'use strict';

    angular.module('geo.services', ['ngResource']);

    function Geo($resource, $http, BaseUrl){
        var geoResource = $resource(BaseUrl + '/geo/:geoId',{geoId:'@_id'});

        /**
         * funcion dispuesta para realizar consulta a servicios de los puntos mas
         * cercanos al pointId indicado
         *
         * @param pointId id del punto a consultar
         * @param dibujarCercanos Funcion que recibe un data y debe utilizar la info
         * @param errorEnTransaccion En caso de error.
         */
        geoResource.cercanos = function(pointId, dibujarCercanos, errorEnTransaccion){
            $http.get(BaseUrl + '/geo/'+pointId+'/cercanos')
                .success(dibujarCercanos).error(errorEnTransaccion);
        };

        return geoResource;
    }

    angular
        .module('geo.services')
        .constant('BaseUrl', 'http://192.168.140.80:8080/PruebaConceptoGeo-1.0-SNAPSHOT/rest')
        .factory('Geo', Geo)
        ;
})();