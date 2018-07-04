app.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          var maxIpaSize = 50*1024*1024;
          var maxPlistSize = 5*1024*1024;
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
                var fileSize = element[0].files[0].size;
                var fileName=element[0].files[0].name;
                var index = fileName.lastIndexOf(".");
                var strsubstring = fileName.substring(index, fileName.length).toLowerCase();
                
                console.log(element[0].files[0].name); 
                console.log(strsubstring);   
               
                
                switch(strsubstring) {
                case ".plist":
                	if (fileSize > maxPlistSize) 
                        scope.plist.maxSizeError = true;
                    break;
                case ".ipa":
                	if (fileSize > maxIpaSize) 
                        scope.ipafile.maxSizeError = true;   
                    break;
                default:
                	console.log('Given file formate is not allowed here');
                
               }
                
               
                
             });
          });
       }
    
    
    };}]);



