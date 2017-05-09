/**
 * Created by AndersWOlsen on 09-05-2017.
 */
$(function() {
    showUsers();
});

function showUsers() {
    var header = "<tbody><tr><th>User ID</th><th>Username</th><th>Initials</th><th>CPR</th><th>Password</th><th>Roles</th></tr>";
    var delete_btn = "";
    $.getJSON("rest/user/list" , function(data) {
        var tbl_body = "";
        var odd_even = false;
        $.each(data, function() {
            var tbl_row = "";
            $.each(this, function(k , v) {
                tbl_row += "<td>"+v+"</td>";
                if (k === "userId") {
                  delete_btn = "<th><a onclick=\"deleteUser(" + v + ");\" class=\"button alert small\">Delete</a></th>";
                }
            })
            tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+delete_btn+"</tr>";
            odd_even = !odd_even;
        })

        $("#users-table").html(header + tbl_body + "</tbody>");
    });
}

function deleteUser(userId) {
  $.get("rest/user/delete/" + userId);
  setTimeout(function() {}, 30);
  showUsers();
}

$("#create-user-btn").click(function() {
    $("#create-user-btn").css("display", "none");
    $("#show_users").css("display", "none");
    $("#create_user").css("display", "block");
});

$("#submit-new-user-btn").click(function(e) {
    console.log("clicked");
    var form = $("#create-user-form").serializeJSON();
    console.log(form);

    $.ajax({
        url : "rest/user/create/new",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: form,
        success: function(data) {
            console.log("Successfully posted...");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error on POST. Status: " + textStatus + " Error: " + errorThrown);
        }
    });
    e.preventDefault();

    $("#create-user-btn").css("display", "inline-block");
    $("#show_users").css("display", "block");
    $("#create_user").css("display", "none");

    setTimeout(function(){}, 30);
    showUsers();
});

$("#create-test-users-btn").click(function() {
  $.get("rest/user/create/test");
  setTimeout(function(){}, 30);
  showUsers();
});

$("#refresh-users-btn").click(function() {
  showUsers();
});
