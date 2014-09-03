(function(){
    'use strict';

    angular.module('geo.controllers', ['geo.services']);

    function GeoListCtrl(Geo){
        this.puntos = Geo.query();
    }

//    function PostDetailCtrl ($routeParams, Post, Comment, User){
//        this.post = {};
//        this.comments = {};
//        this.user = {};
//
//        var self = this;
//
//        this.post = Post.query({id:$routeParams.postId})
//                        .$promise.then(
//                            // Success
//                            function(data){
//                                self.post = data[0];
//                                self.user = User.query({id:self.post.userId});
//                            }
//                        );
//
//        this.comments = Comment.query({ postId : $routeParams.postId});
//    }
//
//    function PostCreateCtrl(Post){
//        var self = this;
//
//        this.create = function(){
//            Post.save(self.post);
//        };
//    }
//
    angular
        .module('geo.controllers')
//        .controller('PostCreateCtrl', PostCreateCtrl)
//        .controller('PostDetailCtrl', PostDetailCtrl)
        .controller('GeoListCtrl', GeoListCtrl)
    ;
})();