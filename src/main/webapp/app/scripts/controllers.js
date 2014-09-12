(function () {
    'use strict';

    angular.module('geo.controllers', ['geo.services', 'leaflet-directive']);

    function GeoListCtrl(Geo) {
        this.puntos = Geo.query();
    }

    function GeoCercanosCtrl ($routeParams, $scope, Geo){
        $scope.markers = [];

        $scope.center =  {
            lng: -74.09774065017699,
            lat: 4.689351250132947,
            zoom:10,
        };

        function dibujarCercanos(data){
            $scope.center =  {
                lng: data.centro.lng,
                lat: data.centro.lat,
                zoom: 15
            };

            data.cercanos.forEach(function(punto){
                $scope.markers.push({
                    lat: punto.lat,
                    lng: punto.lng,
                    message: punto.nombre,
                    icon: {
                        iconUrl: '/img/blueMapIcon.png',
                        iconSize: [32, 32] // size of the icon
                    }
                });
            });

            $scope.markers.push({
                lat: data.centro.lat,
                lng: data.centro.lng,
                message: data.centro.nombre,
                icon: {
                    iconUrl: '/img/redMapIcon.png',
                    iconSize: [32, 32] // size of the icon
                }
            });
        }

        function errorEnTransaccion(data, status){
            console.log(status + ': ' + data);
        }

        Geo.cercanos($routeParams.geoId, dibujarCercanos, errorEnTransaccion);
    }

    function GeoCreateCtrl($scope, Geo) {
        var self = this;
        self.punto = {};

        $scope.center =  {
            lng: -74.09774065017699,
            lat: 4.689351250132947,
            zoom:10
        };

        this.create = function () {
            Geo.save(self.punto);

            delMarkers();
            self.punto = {};
        };

        // evento onclic sobre el mapa
        $scope.$on('leafletDirectiveMap.click', function (e, args) {
            self.punto.lat = args.leafletEvent.latlng.lat;
            self.punto.lng = args.leafletEvent.latlng.lng;

            addMarkers();
        });

        // Método para borrar el marcador del mapa
        var delMarkers = function () {
            angular.extend($scope, {
                markers: {}
            });
        };

        // Adicoinar el marcador al mapa
        var addMarkers = function () {
            angular.extend($scope, {
                markers: {
                    puntoPupero: self.punto
                }
            });
        };
    }

    angular
        .module('geo.controllers')
        .controller('GeoCreateCtrl', GeoCreateCtrl)
        .controller('GeoCercanosCtrl', GeoCercanosCtrl)
        .controller('GeoListCtrl', GeoListCtrl)
    ;
})();