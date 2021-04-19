    /**
     * dom2.js
     */
    
    //  <!-- 예제
    // <form action = "login.jsp" method ="get">
    //     id :<input type ='text'>
    //     psaawd:<input type="password">
    //     <input type="submit" value="Send">
    //     <input type="reset" value="Cancel">
    // </from>





    //form 생성
    var from = document.createElement('form');
    from.setAttribute('action', 'login.jsp');
    from.setAttribute('method', 'get');

    //label = id : , password :
    var id = document.createTextNode('id:');
    var passwd = document.createTextNode('password:');

    //input = id : , password :
    var inputId = document.createElement('input');
    inputId.setAttribute('type','text');
    inputId.setAttribute('name','id');
    var inputPw = document.createElement('input');
    inputPw.setAttribute('type','password');
    inputPw.setAttribute('name','passwd');

    //label send,reset
    var send = document.createElement('send');
    var cancel = document.createElement('cancel');
    

    //input => send, cancel
    var inputSd = document.createElement(input);
    inputSd.setAttribute('type','submit')
    inputSd.setAttribute('value', 'Send');
    var inputRs = document.createElement(input);
    inputRs.setAttribute('type', 'reset');
    inputRs.setAttribute('value','Cancel')

    from.appendChild(id);
    from.appendChild(passwd);
    from.appendChild(inputId);
    form.appendChild(inputPw);
    form.appendChild(inputSd);
    form.appendChild(inputRs);

       var show = document.getElementById('show');
        show.appendChild(from);
