app.controller('CalculadoraController', function ($scope) {

    $scope.resultado = 0;

    $scope.somar = function () {
        $scope.resultado = parseInt($scope.n1) + parseInt($scope.n2);
    }

})