/**
 * Created by nisha on 4/22/2017.
 */
app.controller('movielistcontroller',function movielistcontroller($http,$scope)
{
    $scope.mainVm={};
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

});
