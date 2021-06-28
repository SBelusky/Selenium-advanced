var detail = $('div.detail article');
var loader = $('.loader');

$("li.sin").click(function (event) {
    event.preventDefault();
    var key = $(this).find('a').attr("data");
    loader.fadeIn();
    detail.hide();
    setTimeout(function () {
        loadDetail(key);
    }, 800);

});

function fillInDetail(data) {
    detail.find('h4').text(data.author + " : " + data.title);
    detail.find('p').text(data.message);
    detail.find('h4').append("<span>" + data.creation_date + "</span>");
    var tags = detail.find('ul').html('');
    if (data.tags) {
        data.tags.forEach(function (element) {
            tags.append('<li>' + element + '</li>');
        });
    } else {
        tags.append('<li>no tags</li>')
    }

}
function loadDetail(key) {
    $.ajax({
        url: baseURL + 'get-detail.php',
        data: {key: key},
        dataType: "json"
    })
        .done(function (data) {
            loader.fadeOut(200);
            fillInDetail(data);
            detail.fadeIn(500);

        })
        .fail(function (msg) {
            console.log(msg);
        })
        .always(function () {
        });
}