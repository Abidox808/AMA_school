btn0= document.getElementById('bp');
btn1= document.getElementById('cp');
btn2= document.getElementById('lp');

cnt0=document.getElementById('pc');
cnt1=document.getElementById('cc');
cnt2=document.getElementById('lc');

window.addEventListener('click', function(event) {
    if (event.target == btn1 || event.target == btn2) {
        cnt0.style.display = "none";
    }
});

window.addEventListener('click', function(event) {
    if (event.target == btn0 || event.target == btn2) {
        cnt1.style.display = "none";
    }
});

window.addEventListener('click', function(event) {
    if (event.target == btn0 || event.target == btn1) {
        cnt2.style.display = "none";
    }
});

btn0.onclick=function (){
    cnt0.style.display="grid";
};

btn1.onclick=function (){
    cnt1.style.display="grid";
};

btn2.onclick=function (){
    cnt2.style.display="grid";
};
