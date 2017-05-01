app.controller('movieadmincontroller',function movieadmincontroller($http,$scope, $rootScope, $cookieStore)
{
    $scope.mainVm={};
    $scope.user = $cookieStore.get('user');
    $scope.header = 'list';
    $scope.temp = {
        "id":"",
        "title":"",
        "year":"",
        "rated":"",
        "releasedOn":"",
        "runtime":"",
        "genre":"",
        "director":"",
        "writer":"",
        "actors":"",
        "plot":"",
        "language":"",
        "country":"",
        "awards":"",
        "poster":"",
        "metascore":"",
        "imdbRating":"",
        "imdbVotes":"",
        "imdbId":"",
        "type":""
    };
    $scope.hasPermission = function hasPermission(){
        if($scope.user && $scope.user.id && $scope.user.type!==null && $scope.user.type==="U"){
            return true;
        } else {
            return false;
        }
    };
    $scope.mainVm.sorter={
        sortby:'year',
        sortorder:false
    };
    $http({
        method:'GET',
        url:'http://localhost:8080/movieflix/api/movies'
    })
        .success(function(data)
        {
            $scope.mainVm.movies=data;
        })
        .error(function (err)
        {
            console.log(err);
        });



    $scope.addmovie =function addmovie(){
        $scope.header = 'Add';
        $scope.catelog = {};
        angular.copy($scope.temp,$scope.catelog);
    };

    $scope.removemovie=function removemovie(catelog){
        if($scope.hasPermission() && catelog.id){
            var canDelte = confirm("Do you really want to delete catelog :"+catelog.title +" ?");
            if(canDelte){
                var index = $scope.mainVm.movies.indexOf(catelog);
                $scope.mainVm.movies.splice(index, 1);
                //call delete catelog api
                /*$http.delete('http://localhost:8080/movieflix/api/movies/'+catelog.id)
                 .success(function ( headers, config) {
                 $scope.success="Successfully deleted";
                 }
                 )
                 .error(function (header, config) {
                 $scope.error = "Data not present";
                 });*/
            }
        }
    };
    $scope.cancel = function cancel(){
        $scope.header = 'list';
    };
    $scope.addOrUpdate = function addOrUpdate(){
        if($scope.header === 'Add' && $scope.hasPermission()){
            //call create catelog api with $scope.catelog as data (POST)
            /*$http.post('http://localhost:8080/movieflix/api/movies/', config)
             .success(function (data, status, headers, config) {
             $scope.Ruser = data;

             }
             )
             .error(function (data, status, header, config) {
             $scope.error = "Data is not submitted";
             });*/
            $scope.mainVm.movies.push($scope.catelog);
            $scope.header = 'list';
        }
        if($scope.header === 'Update' && $scope.hasPermission()){
            //call update catelog api with $scope.catelog as data (PUT)
            /*$http.put('http://localhost:8080/movieflix/api/movies/'+catelogid, config)
             .success(function (data, status, headers, config) {
             $scope.Ruser = data;

             }
             )
             .error(function (data, status, header, config) {
             $scope.error = "Data not present";
             });	*/
            $scope.header = 'list';
        }
    };
    $scope.editmovie=function editmovie(cat){
        $scope.header = 'Update';
        $scope.catelog = {};
        angular.copy(cat,$scope.catelog);
    }
});