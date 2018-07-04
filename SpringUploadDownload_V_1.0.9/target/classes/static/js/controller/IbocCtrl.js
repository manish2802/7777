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
            $scope.ipafile={};
            $scope.plist={};
            
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
				$scope.envvalue = '';
				$scope.suppOs = false;
				angular.element("input[type='file']").val(null);
				$scope.fileInfo = '';
				$scope.confMessage = '';

				$scope.msgEnv = '';
				$scope.msgApp = '';
				$scope.msgVer = '';
				$scope.msgFileInfo = '';
				
				$scope.plist.maxSizeError=false;
				$scope.ipafile.maxSizeError=false;
			}

			$scope.uploadFile = function() {
				var isValidate = true;
				$scope.msgEnv = '';
				$scope.msgApp = '';
				$scope.msgVer = '';
				$scope.msgFileInfo = '';

				if ($scope.envvalue == "" || $scope.envvalue == undefined) {
					debugger;
					isValidate = false;
					$scope.msgEnv = 'Please Select Enviorment';
				}
				if ($scope.appName == "" || $scope.appName == undefined) {
					debugger;
					isValidate = false;
					$scope.msgApp = 'Please Select App Name';
				}

				if ($scope.version == "" || $scope.version == undefined) {
					debugger;
					isValidate = false;
					$scope.msgVer = 'Please Enter Version';
				}
				if ($scope.fileInfo == "" || $scope.fileInfo == undefined) {
					debugger;
					isValidate = false;
					$scope.msgFileInfo = 'Please Enter Comments';
				}

				if (isValidate) {

					$scope.msgEnv = '';
					$scope.msgApp = '';
					$scope.msgVer = '';
					$scope.msgFileInfo = '';

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
						$scope.envvalue = '';
						$scope.suppOs = false;
						angular.element("input[type='file']").val(null);
						$scope.fileInfo = '';

					}, function(response) {
						$scope.spinnerShow = true;
						$scope.confMessage = jsonData.response_message;
						$scope.appName = '';
						$scope.ipaFile = null;
						$scope.version = '';
						$scope.envvalue = '';
						$scope.suppOs = false;
						angular.element("input[type='file']").val(null);
						$scope.fileInfo = '';
					});
				}
				;
			};

		} ]);
