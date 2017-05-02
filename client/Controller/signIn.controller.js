app.controller('signincontroller',function signincontroller($http, $scope,$location,$rootScope,$cookieStore)
{
    var mainVm=this;
    $scope.page='login';
    $scope.login = function login()
    {
        var data = {
            email: $scope.email,
            password: $scope.password
        };

        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        }

        $http.post('http://localhost:8080/movieflix/api/users/login', data, config)
            .success(function (data, status, headers, config) {
                if(data){
                    $scope.user = data;
                    $rootScope.user=data;
                    $cookieStore.put("user",data);
                    $location.path('/movie-admin');
                }
            })
            .error(function (data, status, header, config) {
                $scope.error = "Username/Password incorrect";
            });
    }
});