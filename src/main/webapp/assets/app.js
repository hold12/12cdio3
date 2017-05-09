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
            tbl_body += "<tr class=\""+( odd_even ? "odd" : "even")+"\">"+tbl_row+"</tr>";
            odd_even = !odd_even;
        })
        $("#users-table").append(tbl_body);
    });
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
        url : "rest/create-user",
        type: "POST",
        data: {valArray:form},
        success: function(data) {
            console.log("Successfully posted...");
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("Error on POST. Status: " + textStatus + " Error: " + errorThrown);
        }
    });
    e.preventDefault();
});
