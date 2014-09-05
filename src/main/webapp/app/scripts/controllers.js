(function () {
    'use strict';

    angular.module('geo.controllers', ['geo.services', 'leaflet-directive']);

    function GeoListCtrl(Geo) {
        this.puntos = Geo.query();
    }

    function GeoCercanosCtrl ($routeParams, $scope, Geo){
        var self = this;
        Geo.query({id:$routeParams.geoId})
            .$promise.then(
                function(data){
                    self.puntos = data;

                    $scope.$on('leafletDirectiveMap.load', function(){
                        $scope.markers.push(self.puntos);
                    });
                }
        );
    }

    function GeoCreateCtrl($scope, Geo) {
        var self = this;
        self.punto = {};

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