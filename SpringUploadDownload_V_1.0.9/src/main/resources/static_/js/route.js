app.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
			$stateProvider.state('home', {
				url : '/home',
				templateUrl : 'views/home.html'
			}).state('fileupload', {
				url : '/fileupload',
				templateUrl : 'views/uploadform.html'
			}).state('download-form-parent', {
				url : '/download-form',
				templateUrl : 'views/download-form.html'
			}).state('download-form-parent.search-iboc-list', {
				url : '/search-iboc-list/:',
				templateUrl : 'views/search-iboc-list.html',
			    params: { ibocList: null,selectApp:null,selectType:null},
			})
			
			$urlRouterProvider.otherwise('/home');
		} ]);