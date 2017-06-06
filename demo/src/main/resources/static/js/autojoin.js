var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
    	$("#autojoinconsole").append("Connected to websocket...<br/>");
    }
    else {
    	$("#autojoinconsole").append("Disconnected...<br/>");
    }
}

function connect() {
    var socket = new SockJS('/ws-autojoin');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/autojoin', function (wsmessage) {
        	showAutoJoinMessage(JSON.parse(wsmessage.body).content);
        });
    });
}

function showAutoJoinMessage(message) {
    $("#autojoinconsole").append(message + "<br/>");
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    //console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/autojoinmessage", {}, JSON.stringify({'message': $("#name").val()}));
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault(); //stops submission
    });
    
    
	$( "#connect" ).click(function() { connect(); });
	$( "#disconnect" ).click(function() { disconnect(); });
	$( "#send" ).click(function() { sendMessage(); });
	
});