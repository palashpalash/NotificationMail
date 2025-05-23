<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Notification Response</title>
</head>
<body>
  <h1>Notification Response</h1>
  <p id="response"></p>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- Include jQuery -->

  <script>
    // Get the full path from the current URL
    const path = window.location.pathname;

    // Extract the last part after "/notificationacceptance/"
    const dataPrefix = "/notificationacceptance/";
    let data = "";

    if (path.startsWith(dataPrefix)) {
      data = path.substring(dataPrefix.length);
    }

    $.ajax({

    				url : '/verifynotification/'+data,
    				method : 'get',
    				error : function() {
    					alert("error");
    					//document.getElementById("messagearea").value = "";
    				},
    				success : function(msg) {
    					alert(msg);

    				}

    			});


  </script>
</body>
</html>
