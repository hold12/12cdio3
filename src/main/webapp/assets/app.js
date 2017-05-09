$(function() {
    var showData = $('#testing');

    $.getJSON('rest/users', function (data) {
        console.log(data);

        var items = data.items.map(function (item) {
            return item.key + ': ' + item.value;
        });

        showData.empty();

        if (items.length) {
            var content = '<li>' + items.join('</li><li>') + '</li>';
            var list = $('<ul />').html(content);
            showData.append(list);
        }
    });

    showData.text('Loading the JSON file.');
});

function CallURL() {
    $.ajax({
        url: 'rest/users',
        type: "GET",
        dataType: "jsonp",
        async: false,
        success: function(data) {
            ShowData(data);
        },
        error: function() {
            $("#testing").text("Error...");
        }
    });
}

function ShowData(json) {
    $("#testing").text(json.result);
}
