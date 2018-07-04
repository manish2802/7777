app.controller('CarouselCtrl',
				['$scope','$timeout',
						function($scope, $timeout) {

							var INTERVAL = 2000, slides = [ {
								id : "image00",
								src : "images/1.jpg"
							}, {
								id : "image02",
								src : "images/2.jpg"
							}, {
								id : "image03",
								src : "images/3.jpg"
							}, {
								id : "image04",
								src : "images/4.jpg"
							} ];
							function setCurrentSlideIndex(index) {
								$scope.currentIndex = index;
							}
							function isCurrentSlideIndex(index) {
								return $scope.currentIndex === index;
							}
							function nextSlide() {
								$scope.currentIndex = ($scope.currentIndex < $scope.slides.length - 1) ? ++$scope.currentIndex
										: 0;
								$timeout(nextSlide, INTERVAL);
							}
							function loadSlides() {
								$timeout(nextSlide, INTERVAL);
							}
							$scope.slides = slides;
							$scope.currentIndex = 0;
							$scope.setCurrentSlideIndex = setCurrentSlideIndex;
							$scope.isCurrentSlideIndex = isCurrentSlideIndex;
							loadSlides();

						} // Controller Ends here
				])
