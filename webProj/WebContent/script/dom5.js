/*
dom5.js
 */



    //<div id ="show"></div>
//    // <div>
//         <p></p>
//         <p></p>
//         <p></p>
//         <p></p>
//         <p></p>
//     </div>
//     <button >클릭</button>
//     <button >클릭</button>
//     <button >클릭</button>
    <script>

        var buttons = document.getElementsByTagName('button');
        console.log(buttons);
        for (var i=0; i<buttons.length; i++) {
            button[0].setAttribute('onclick','showTable()');
        }
        

        var p1 = {
            name : '성진아',
            score : 80,
            gender: '여'
        }
        var p2 = {
            name : '김수민',
            score : 83,
            gender: '여'
        }
        var p3 = {
            name : '장대우',
            score : 85,
            gender: '남'
        }


        for (var field in p3) {   
            console.log(field, p3[field]);
        }


        var persons = [p1, p2, p3];

            var tableTag = document.createElement('table');
            tableTag.setAttribute('border','1');
            for (var person of persons) {  //배열에서반복
                var tr1 = document.createElement('tr'); 
                for (var field of persons) {  //오브젝트에서반복
                    var td1 = document.createElement('td');
                    td1.innerHTML = person[field];
                    tr1.appendChild(td1);
                }
                tableTag.appendChild(tr1);


     


        //     for (var persons of persons) {

            
        //     var tr1 = document.createElement('tr');
        //     var td1 = document.createElement('td');
        //     td1.innerHTML = persons.name;
        //     var td2 = document.createElement('td');
        //     td2.innerHTML = persons.score;
            
        //     tableTag.appendChild(tr1);
        //     tr1.appendChild(td1);
        //     tr1.appendChild(td2);

        //     var show = document.getElementById('show');
        //     show.appendChild(tableTag);

        // }