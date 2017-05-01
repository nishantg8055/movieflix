/**
 * Created by nisha on 4/23/2017.
 */
app.controller('moviedetailcontroller',function moviedetailcontroller($http,$scope,$routeParams,$rootScope,$cookieStore)
{
    $rootScope.user = $cookieStore.get('user');
    $scope.mainVm={};
    init();

    function init()
    {
        $http({
            method:'GET',
            url:'http://localhost:8080/movieflix/api/movies/'+$routeParams.id
        })
            .success(function(data)
            {
                $scope.mainVm.movie=data;
                comments();
                rating();
            })
            .error(function (err)
            {
                console.log(err);
            });
    }

    function comments()
    {
        $http({
            method:'GET',
            url:'http://localhost:8080/movieflix/api/movies/'+$routeParams.id+"/user-comments"
        })
            .success(function(data)
            {
                $scope.mainVm.comments=data;
            })
            .error(function (err)
            {
                console.log(err);
            });

    }
    $scope.Csubmit = function Csubmit()
    {
        var data = {
            comments: $scope.comments,
        };

        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        }
        $http.post('http://localhost:8080/movieflix/api/movies/'+$scope.mainVm.movie.id+'/users/'+$rootScope.user.id+'/user-comments?comments='+$scope.comments, config)
            .success(function (data, status, headers, config) {
                    $scope.Cuser = data;
                    $scope.mainVm.comments.push($scope.comments);

                }
            )
            .error(function (data, status, header, config) {
                $scope.error = "Data not present";
            });
    }

    function rating()
    {
        $http({
            method:'GET',
            url:'http://localhost:8080/movieflix/api/movies/'+$routeParams.id+"/avg-rating"

        })
            .success(function(data)
            {
                $scope.mainVm.rating=data;
            })
            .error(function (err)
            {
                console.log(err);
            });
    }

    $scope.Rsubmit = function Rsubmit()
    {

        var data = {
            rating: $scope.rating,
        };

        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        }
        // $http.post('http://localhost:8080/spring-rest/api/catelogs/catelogid/users/userid/rating', data, config)
        $http.post('http://localhost:8080/movieflix/api/movies/'+$scope.mainVm.movie.id+'/users/'+$rootScope.user.id+'/rating?rating='+$scope.rating, config)
            .success(function (data, status, headers, config) {
                    $scope.Ruser = data;
                    rating();
                }
            )
            .error(function (data, status, header, config) {
                $scope.error = "Data not present";
            });
    }
});