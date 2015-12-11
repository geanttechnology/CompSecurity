var documentBody = null;
var statusDiv = null;
var statusContainerDiv = null;
function addMessage(message, type, messageID, time, sender, senderAvatar) {
	readyWait(function() {

		if(!documentBody) {
			documentBody = document.getElementsByTagName('body')[0];
		}
		if(document.getElementById(messageID) == null) {

			var containerDiv = document.createElement('div');
			containerDiv.className = "bc-container bc-container-" + type;

			var footDiv = document.createElement('div');
			footDiv.className = "bc-foot-" + type;

			var messageDiv = document.createElement('div');
			messageDiv.id = messageID;
			messageDiv.className = "bc-message bc-message-" + type;

			if(typeof time != 'undefined' && time != null) {
				var div = document.createElement('div');
				div.className = "bc-message-created";
				div.innerHTML = time;
				messageDiv.appendChild(div);
			}

			if(typeof sender != 'undefined' && sender != null) {
				var div = document.createElement('div');
				div.className = "bc-message-sender";
				div.innerHTML = sender;
				messageDiv.appendChild(div);
			}

			if(typeof senderAvatar != 'undefined' && senderAvatar != null && senderAvatar.length > 0) {
				var div = document.createElement('div');
				div.className = "bc-avatar bc-avatar-" + type;
				var img = document.createElement('img');
				img.src = senderAvatar;
				div.appendChild(img);
				messageDiv.appendChild(div);
			}

			var div = document.createElement('div');
			div.className = "bc-message-body";
			div.innerHTML = message;
			messageDiv.appendChild(div);

			if(type == "operator" || type == "system") {
				containerDiv.appendChild(footDiv);
				containerDiv.appendChild(messageDiv);
			} else {
				containerDiv.appendChild(messageDiv);
				containerDiv.appendChild(footDiv);
			}

			if(statusContainerDiv == null) {
				documentBody.appendChild(containerDiv);
			} else {
				documentBody.insertBefore(containerDiv, statusContainerDiv);
			}

			scrollToBottom();
		}
	});
}

function setStatus(setVisible, message) {
	readyWait(function() {
		if(!documentBody) {
			documentBody = document.getElementsByTagName('body')[0];
		}
		if(!!setVisible) {
			if(statusDiv == null) {
				statusDiv = document.createElement('div');
				statusDiv.className = "bc-message bc-message-system";
				statusContainerDiv = document.createElement('div');
				statusContainerDiv.className = "bc-container-system";
				var footDiv = document.createElement('div');
				footDiv.className = "bc-foot-system";
				statusContainerDiv.appendChild(footDiv);
				statusContainerDiv.appendChild(statusDiv);
				documentBody.appendChild(statusContainerDiv);
				scrollToBottom();
			}
			statusDiv.innerHTML = message;
		} else if (documentBody != null && !setVisible && statusDiv != null) {
			documentBody.removeChild(statusContainerDiv);
			statusDiv = null;
			statusContainerDiv = null;
		}
	});
}

function clearHistory() {
	var history = document.getElementsByClassName("bc-container");
	while(history.length > 0) {
		history[0].parentElement.removeChild(history[0]);
	}
}

function readyWait(func) {
	setTimeout(function () {
		if (document.readyState !== 'complete' || typeof window.injectedObject == 'undefined') {
			readyWait(func);
		} else {
			func();
		}
	}, 100);
}

var lastHeight = 0;
function checkDocumentHeight(callback){
	var newHeight, timer;
	lastHeight = document.body.scrollHeight;
	(function run(){
		newHeight = document.body.scrollHeight;
		if( lastHeight != newHeight ) {
			callback();
		}
		lastHeight = newHeight;
		timer = setTimeout(run, 1000);
	})();
}

function scrollToBottom() {
	lastHeight = document.body.scrollHeight;
	if(typeof injectedObject != 'undefined') {
		setTimeout(function() {
			injectedObject.scrollToBottom();
		}, 200);
	}
}

window.onload = function () {
	checkDocumentHeight(scrollToBottom);
	readyWait(function() {
		window.onresize = function() {
			scrollToBottom();
		}
		injectedObject.pageLoaded();
	});
}