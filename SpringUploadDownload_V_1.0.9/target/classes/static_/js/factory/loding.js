app.directive('loading',   ['$http' ,function ($http)  
 {  
     return {  
         restrict: 'A',  
         template: '<div class="imgSpin"> <img  src="images/logo.gif" /></div>',  
         link: function (scope, elm, attrs)  
         {  
             scope.isLoading = function () {  
                 return $http.pendingRequests.length > 0;  
             };  
  
             scope.$watch(scope.isLoading, function (v)  
             {  
                 if(v){  
                     elm.show();  
                 }else{  
                     elm.hide();  
                 }  
             });  
         }  
     };  
 }])