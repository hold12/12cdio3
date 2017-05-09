/**
 * Created by AndersWOlsen on 09-05-2017.
 */
$(function() {
    showUsers("rest/users");
});

function showUsers(url) {
    $.getJSON(url , function(data) {
        var tbl_body = "";
        var odd_even = false;
        $.each(data, function() {
            var tbl_row = "";
            $.each(this, function(k , v) {
                tbl_row += "<td>"+v+"</td>";
            })
            tbl_row += "<a id=\"delete-user-btn\" class=\"button\" onclick=\"deleteUser(this)\">Delete user</a>";
            tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+"</tr>";
            odd_even = !odd_even;
        })
        $("#users-table").append(tbl_body);
    });
}

function deleteUser(btn) {
    var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

$("#create-user-btn").click(function() {
    $("#create-user-btn").css("display", "none");
    $("#show_users").css("display", "none");
    $("#create_user").css("display", "block");
});

$("#delete-user-btn").click(function() {
    deleteUser(btn);
});
