app.controller('IbocSearchCtrl', [ '$scope', '$http', '$rootScope', '$state',
		'$stateParams',
		function($scope, $http, $rootScope, $state, $stateParams) {
	       
	        $scope.showSearch=false;		
			$scope.searchiboc = function() {
				$http({
					method : 'POST',
					url : 'ibocdetail/downloaded-file-search',
					data : {
						selectApp : $scope.selectApp,
						selectType : $scope.selectType,
					},

				}).then(function success(response) {
					debugger;
					$scope.showSearch=true;
					$state.go('download-form-parent.search-iboc-list', {
						ibocList : response.data,
						selectApp:$scope.selectApp,
						selectType : $scope.selectType,
					});

				}, function error(response) {
					$scope.showSearch=false;
					alert("Invalid Data Please Check Data!!!! ");
				});

			};

		} ]);
