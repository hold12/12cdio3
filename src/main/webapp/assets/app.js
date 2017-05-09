/**
 * Created by AndersWOlsen on 09-05-2017.
 */
$(function() {
    showUsers();
    $("#submit-edited-user-btn").hide();
    console.log("version 1.0-0036");
});

function showUsers() {
    var header = "<tbody><tr><th>User ID</th><th>Username</th><th>Initials</th><th>CPR</th><th>Password</th><th>Roles</th></tr>";
    var edit_btn = "";
    var delete_btn = "";
    $.getJSON("rest/user/get/all" , function(data) {
        var tbl_body = "";
        var odd_even = false;
        $.each(data, function() {
            var tbl_row = "";
            $.each(this, function(k , v) {
                tbl_row += "<td>"+v+"</td>";
                if (k === "userId") {
                  edit_btn = "<th><a onclick=\"editUser(" + v + ");\" id=\"edit-user-btn\" class=\"button info small\">Edit</a></th>"
                  delete_btn = "<th><a onclick=\"deleteUser(" + v + ");\" class=\"button alert small\">Delete</a></th>";
                }
            })
            tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+edit_btn+delete_btn+"</tr>";
            odd_even = !odd_even;
        })

        $("#users-table").html(header + tbl_body + "</tbody>");
    });
}

function editUser(userId) {
  hideButtons();
  $("#show_users").css("display", "none");
  $("#create_user").css("display", "block");
  $("#submit-new-user-btn").hide();
  $("#submit-edited-user-btn").show();

  $.getJSON("rest/user/get/" + userId, function(data) {
      $.each(data, function(k, v) {
        if (k === "userId") {
          $("#userId").val(v);
          $("#userId").prop("disabled", true);
        } else if(k === "username") {
          $("#username").val(v);
        } else if(k === "initials") {
          $("#initials").val(v);
        } else if(k === "cpr") {
          $("#cpr").val(v);
        } else if(k === "password") {
          $("#password").val(v);
        } else if(k === "roles") {
          $("#roles").val(v);
        }
      })
  });

  showUsers();
}

function deleteUser(userId) {
  $.get("rest/user/delete/" + userId);
  setTimeout(function() {}, 30);
  showUsers();
}

function goHome() {
  showButtons();
  $("#create_user").css("display", "none");
  $("#show_users").css("display", "block");

  // Submit buttons in the "create user" form
  $("#submit-new-user-btn").show();
  $("#submit-edited-user-btn").hide();

  // Clear create users form
  $("#userId").val("");
  $("#username").val("");
  $("#initials").val("");
  $("#cpr").val("");
  $("#password").val("");
  $("#roles").val("");
}

function hideButtons() {
  $("#refresh-users-btn").hide();
  $("#create-user-btn").hide();
  $("#create-user-btn").hide();
  $("#create-test-users-btn").hide();
  $("#update-user-btn").hide();
}

function showButtons() {
  $("#refresh-users-btn").show();
  $("#create-user-btn").show();
  $("#create-user-btn").show();
  $("#create-test-users-btn").show();
  $("#update-user-btn").show();
}

$("#create-user-btn").click(function() {
  $("#userId").prop("disabled", false);
    hideButtons();
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

    setTimeout(function(){}, 30);
    goHome();
    showUsers();
});

$("#submit-edited-user-btn").click(function(e) {
    console.log("clicked");
    var form = $("#create-user-form").serializeJSON();
    console.log(form);

    $.ajax({
        url : "rest/user/update/" + $("#userId").val(),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: form,
        success: function(data) {
            console.log("Successfully edited user with id = " + $("#userId").val());
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error on POST. Status: " + textStatus + " Error: " + errorThrown);
        }
    });
    e.preventDefault();

    setTimeout(function(){}, 30);
    goHome();
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
