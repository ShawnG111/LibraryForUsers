var page = parseInt($("#page").html());
var pageNum = 1;

$(document).ready(function(){
    getList();
    $("#submit").click(function(){
        $("#page").html(1);
        page = 1;
        getList();
    });
    $("#nextPage").click(function(){
        if(page>=pageNum){
            alert("已经是最后一页")
        }else {
            $("#page").html(page + 1);
            page = parseInt($("#page").html());
            getList();
        }
    });
    $("#lastPage").click(function(){
        if(page<=1){
            alert("已经是第一页")
        }else {
            $("#page").html(page - 1);
            page = parseInt($("#page").html());
            getList();
        }
    });
});

function getList(){
    $.ajax({
        type: "GET",
        url: "/book/getBookList",
        data: {
            checkString: $("#checkString").val(),
            page: page,
            rows: parseInt($("#rows").val())
        },
        dataType: "json",
        success: function(data){
            pageNum = data.pageNum;
            $("#tableBody").empty();
            $.each(data.resultData, function(index, item){
                var row =
                    "<tr><td>" + item.bookId +"</td>" +
                    "<td>" + item.bookName +"</td>" +
                    "<td>" + item.author +"</td>" +
                    "<td>"+ item.typeId +"</td>" +
                    "<td>" + item.storageNum +"</td>" +
                    "<td>" + item.totalNum +"</td>" +
                    "<td> <a th:href='@{/book/detailPage(bookId=" +item.bookId +")}'>详情</a> </td></tr>";
                $("#tableBody").append(row);
            });
        }
    });
}
