/*

*/


function createTitle() {
    console.log(arguments);

    var tr = document.createElement('tr');
    for (var i = 0; i < arguments.length; i++) {
        var th = document.createElement('th');
        th.innerHTML = arguments[i];
        tr.appendChild(th);
    }
    tbl.appendChild(tr);

}
//회원리스트에 회원정보 보여주는 func
function createData() {
    for (var person of persons) {
        var trTag = document.createElement('tr');
        trTag.setAttribute('id', person.id);
        trTag.onmouseover = mouseOverFnc;
        trTag.onmouseout = mouseOutFnc;

    }
    for (var field in person) {
        if (field == 'id') {
            var tdTag = document.createElement('td');
            tdTag.onclick = modifyFunc; 
            var text = document.createTextNode(person[field]);
            trTag.appendChild(tdTag);
            tdTag.appendChild(text);
         } else if (field == 'name') {
            var td = document.createElement('td');
                var link = document.createElement('a');
                link.setAttribute('href', 'dom.jsp?name= person.name Hong&id=user1&score=80&gender=Male');
                link.innerHTML = 'Hong';
                td.appendChild(link);
                trTag.appendChild(td);
        } else {
            var tdTag = document.createElement('td');
            var text = document.createTextNode(person[field]);
            trTag.appendChild(tdTag);
            tdTag.appendChild(text);
        }
    }

    var tdl = document.createElement('td');
    var buttons = document.createElement('button');
    buttons.innerHTML = '삭제';
    buttons.onclick = deleteRow;


tdl.appendChild(buttons);
trTag.appendChild(tdl);
tbl.appendChild(trTag);
}




function mouseOverFnc() {
    this.style.backgroundColor = 'yellow';
}

function mouseOutFnc() {
    this.style.backgroundColor = ' ';
}

function deleteRow() {
    console.log(this.parentNode.parentNode.remove());

    }
     
    function modifyFunc() {
     console.log(this);
                var idVal = this.innerHTML;
                var nameVal = this.previousSibling.innerHTML;
                var scoreVal = this.nextSibling.innerHTML;
                var genVal = this.parent.ChildNodes[3].innerHTML;
                console.log(idVal, nameVal, scoreVal, genVal);

                document.getElementById('name').value = nameVal;
                document.getElementById('id').value = idVal;
                document.getElementById('score').value = scoreVal;
                var genders = document.querySelectorAll('input[name = "gender"]');
                for (var i = 0; i < gender.length; i++) {
                    if (gender[i].value == genVal) {
                        gender[i].checked = true;
                    }
                }
                console.length(genders);
    }




    function saveBtnFnc() {
        var iName = document.getElementById('name');
        var iId = document.querySelector('input[nmae ="id]');
        var iScore = document.getElementsByTagName('input')[2];
        var iGender = document.querySelector('input[nmae ="gender"]:checked')
    
    
    
        var trTag = document.createElement('tr');
        trTag.onmouseover = mouseOverFnc;
        trTag.onmouseout = mouseOutFnc;
    
    
    
        //name
        var tdTag = document.createElement('td');
        tdTag.innerHTML = iName.value;
        trTag.appendChild(tdTag);
        //id
        var tdTag = document.createElement('td');
        tdTag.innerHTML = iId.value;
        trTag.appendChild(tdTag);
        //score
        var tdTag = document.createElement('td');
        tdTag.innerHTML = iScore.value;
        trTag.appendChild(tdTag);
        //gender
        var tdTag = document.createElement('td');
        tdTag.innerHTML = iGender.value;
        trTag.appendChild(tdTag);
    
        //button
        var tdl = document.createElement('td');
        var btn = document.createElement('button');
        btn.innerHTML = '삭제';
    
        buttons.onclick = deleteRow;

        


    
        tdl.appendChild(btn);
        trTag.appendChild(tdl);
        tdl.appendChild(tr);
    
        tbl.appendChild(tr);
    }


//수정버튼을 클릭했을때 변경
    function modifyBtnFnc() {
        console.log(this);
        var id = document.getElementById('id').value;
        // 사용자가 변경한 값을 반영
        var name = document.getElementById('name').value;
        var score = document.getElementById('score').value;
        var gender = document.querySelector('input[name="grnder"]:checked').value;

        var target = document.getElementById(id);   //id로 tr찾아오려고
        console.log(targetTr);
        // <a href ='dom.js?name=?&id=?&score=?&
            
        targetTr.children[0].innerHTML = '<a href ="dom.jsp?name='+ name + '&id='+ id + '&score='+score+ '&gender='+gender+'">'+name+'</a>'
        targetTr.children[2].innerHTML = score;
        targetTr.children[3].innerHTML = gender;
           
    }
 
