app.controller('signupcontroller',function signupcontroller($http,$scope,$location,$rootScope)
{
    var addUserVm=this;
    $scope.addUser=function addUser(){
        var dt={
            firstName:$scope.firstName,
            lastName:$scope.lastName,
            email:$scope.email,
            password:$scope.password,
            type:'U'
        };
        var config={
            headers:{
                'Content-Type':undefined
            }
        }
        $http.post('http://localhost:8080/movieflix/api/users',dt,config)
            .success(function(data,status,headers,config){
                $scope.nuser=data;
            })
            .error(function(data,status,headers,config)
            {
                $scope.error="Data not present";
            });
    }
});