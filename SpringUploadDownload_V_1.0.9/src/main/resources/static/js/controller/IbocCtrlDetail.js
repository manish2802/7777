app.controller('IbocCtrlDetail', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location) {
			
			
			var url = "ibocdetail/downloaded-file";
			$http.get(url).then(function(response) {
				// alert("Successfully Upload Images");
				$scope.data = response.data;
			}, function(response) {
				console.log("Some Error");
			});

		} ]);
