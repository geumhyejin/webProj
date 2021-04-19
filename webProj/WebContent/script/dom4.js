



<script>

        var ps = document.querySelectorAll('div > p');
            ps.textContent = 'Hello';
            ps.style.backgroundColor = 'yellow';

    
        //numbers => 1~10
        //filter , map, foreach => 짝수만 걸러내도록 => evenVal;
        //evenVal => n* 3; =>mapVal;
        //maVal => console.log (각각출력);

        var numbers= [1,2,3,4,5,6,7,8,9,10];
        // var evenVal = numbers.filter(function(val) {
            numbers.filter((val)=> val % 2 == 0)
                 
                .map((val) => val *3)
                .forEach((val) => console.log(val));

        
            var sum = (a, b) => a+b;  // arrow function
        
            sum (10, 20);

           //document.write(mapval);
    </script>