app.controller('IbocCtrl', [
		'$scope',
		'$http',
		'$rootScope',
		'$state',
		'$stateParams',
		'$window',
		'$location',
		function($scope, $http, $rootScope, $state, $stateParams, $window,
				$location) {

			
			$scope.spinnerShow = true;
			$scope.enviorment = [ {
				env : 'SIT',
				value : 'SIT'
			}, {
				env : 'UAT',
				value : 'UAT'
			}, {
				env : 'NFT',
				value : 'NFT'
			}, {
				env : 'PROD',
				value : 'PROD'
			}, {
				env : 'DR',
				value : 'DR'
			} ];
			// $scope.envvalue = $scope.enviorment[0].env;

			resetForm = $scope.resetForm = function() {
				$scope.appName = '';
				$scope.ipaFile = null;
				$scope.version = '';
				$scope.iboc.envvalue = '';
				$scope.suppOs = false;
				angular.element("input[type='file']").val(null);
				$scope.fileInfo = '';
				$scope.confMessage = '';

			}

			$scope.uploadFile = function() {

				var b = true;

				if ($scope.envvalue == "" || $scope.envvalue == undefined) {
					debugger;
					b = false;
					$scope.msgEnv = 'Please Select Enviorment';
				}
				if ($scope.appName == "" || $scope.appName == undefined) {
					debugger;
					b = false;
					$scope.msgApp = 'Please Select App Name';
				}
				if (b) {
					
					$scope.msgEnv = '';
					$scope.msgApp = '';

					$scope.spinnerShow = false;
					var url = "ibocdetail/uploadDetail";
					var data = new FormData();
					if ($scope.suppOs) {
						data.append("supOs", "iOS");
					} else {
						data.append("supOs", "NA");
					}

					data.append("appName", $scope.appName);
					data.append("pListFile", $scope.pListFile);
					data.append("ipaFile", $scope.ipaFile);
					data.append("version", $scope.version);
					data.append("environment", $scope.envvalue);
					data.append("relNotes", $scope.relNotes);
					data.append("fileInfo", $scope.fileInfo);
					var config = {
						transformRequest : angular.identity,
						transformResponse : angular.identity,
						headers : {
							'Content-Type' : undefined
						}
					}

					$http.post(url, data, config).then(function(response) {
						$scope.spinnerShow = true;
						var jsonData = JSON.parse(response.data);
						$scope.confMessage = jsonData.response_message;

						$scope.appName = '';
						$scope.ipaFile = null;
						$scope.version = '';
						$scope.iboc.envvalue = '';
						$scope.suppOs = false;
						angular.element("input[type='file']").val(null);
						$scope.fileInfo = '';

					}, function(response) {
						$scope.spinnerShow = true;
						$scope.confMessage = jsonData.response_message;
						$scope.appName = '';
						$scope.ipaFile = null;
						$scope.version = '';
						$scope.iboc.envvalue = '';
						$scope.suppOs = false;
						angular.element("input[type='file']").val(null);
						$scope.fileInfo = '';
					});
				}
				;
			};

		} ]);
