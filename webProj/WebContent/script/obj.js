/**
 * obj.js
 */

var num1, num2, result;
		num1 = 25;
		num2 = 2;
		result = num1 / num2;
		result = num1 % num2;
		var num3 = '25';
		console.log(num1 === num3); //===변수와 타입도 다비교함
		console.log('결과값:' +result);
		
		var obj = {}; //new Object();하나만들겠다는의미
		obj.name = 'Hong';  //.연산자
		obj.age = 20;
		obj.showInfo = function() {
			console.log('이름: '+ obj.name + ' 나이: '+ obj.age);
		}
		//console.log(obj);
		obj.showInfo();
		
		var obj2 = {
			name: 'Hwang',
			age : 22,
			showInfo : function() {
				console.log('이름: '+ this.name + ' 나이: '+ this.age);
			}
		}
		obj2['name'] = 'Park';  //필드에 값 집어넣기
		obj2['age'] = 33;
		obj2.showInfo();

		var obj3 = {
			name: 'Kang',
			age: 15
		}