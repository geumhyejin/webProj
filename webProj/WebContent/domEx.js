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

function createData() {
    for (var person of persons) {
        var tr = document.createTextNode('tr');
        trTag.setAttribute('id', person.id);
        trTag.onmouseover = mouseOverfunc;
        trTag.onmouseout = mouseOutfunc;

    }
    for (var field in person) {
        if (field == 'id') {
            var td = document.createElement('td');
            tdTag.onclick = function () {

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
            var text = document.createTextNode(person[field]);
            trTag.appendChild(tdTag);
            
        } else {
            var tdTag = document.createElement('td');
            var text = document.createTextNode(prtson[field]);
            trTag.appendChild(tdTag);
          
        }
    }

    var td1 = document.createElement('td');
    var buttons = document.createElement('button');
    btn.innerHTML = '삭제';
    btn.onclick = deleteRow;
   
}
td1.appendChild(button);
tr.appendChild(td1);
tbl.appendChild(tr);



var iName = document.getElementById('name');
var iId = document.querySelector('input[nmae ="id]');
var iScore = document.getElementsByTagName('input')[2];
var iGender = document.querySelector('input[nmae ="gender"]:checked')



var trTag = document.createElement('tr');
trTag.onmouseover = mouseOverfunction;
trTag.onmouseout = mouseOutfunction;




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

burrons.onclick = deleteRow;

tdl.appendChild(btn);
trTag.appendChild(tdl);
tdl.appendChild(tr);

tbl.appendChild(tr);


function mouseOverFnc() {
this.style.backgroundColor = 'yellow';
}

function mouseOutFnc() {
this.style.backgroundColor = ' ';
}

function deleteRow() {
console.log(this.parentNode.parentNode.remove())

}
function modifyBtcFnc() {
    console.log(this);
    var id = document.getElementById('id').value;
    var target = document.getElementById(id);
    console.log(targetTr);
    targetTr.children[0].innerHTML =  //
    document.getElementById('name').value;
    targetTr.children[2].innerHTML =  //
    document.getElementById('score').value;
    targetTr.children[3].innerHTML =  //
    document.querySelector('input[name="grnder"]:checked').value;
}



