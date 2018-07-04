app.controller('IbocSearchListCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		function($scope, $http, $rootScope, $state, $stateParams) {
			debugger;
			$scope.searcData=$stateParams.ibocList;			
			//$scope.selectType=$stateParams.selectType;
			//$scope.selectApp=$stateParams.selectApp;
			 
			  
		} ]);