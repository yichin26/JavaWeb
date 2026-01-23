window.onload = function() {
    let myDrawer = document.getElementById("myDrawer");
    let webSocket = new WebSocket("ws://10.0.101.123:8080/JavaWeb/mycenter");
    let isConnect = false;

    webSocket.onopen = function() {
        isConnect = true;
    }

    webSocket.onmessage = function(event) {
        if (isConnect) {
            let mesgobj = JSON.parse(event.data);
            if (mesgobj.isClear) {
                clear();

            } else {
                if (mesgobj.isNewLine) {
                    newLine(mesgobj.x, mesgobj.y);
                } else {
                    drawLine(mesgobj.x, mesgobj.y);
                }
            }
        }
    }
    webSocket.onclose = function() {
        isConnect = false;
    }
    webSocket.onerror = function(event) {
        console.log("onError:" + event);
    }

    //-------------------
    let ctx = myDrawer.getContext("2d");


    function clear() {
        ctx.clearRect(0, 0, myDrawer.width, myDrawer.height);
    }
    function newLine(x, y) {
        ctx.beginPath();
        ctx.lineWidth = 4;
        ctx.moveTo(x, y);

    }
    function drawLine(x, y) {

        ctx.lineTo(x, y);
        ctx.stroke();
    }
}
