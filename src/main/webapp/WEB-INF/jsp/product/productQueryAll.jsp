<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/ordersystem.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
        var indexPage = 1;
        $(function() {
            load(indexPage);
        });
        
        function load(indexPage) {
            $.ajax({
                type: 'get',
                url: '/product/queryByPage/' + indexPage + '?product=' + $('#searchProductName').val(),
                dataType: 'JSON',
                contentType: 'application/json',
                success: function(data) {
                    $('#showproduct').empty();
                    if (data == null) {
                        $('table').prepend('<tr><td colspan="2">No Information</td></tr>');
                    } else {
                        var table = $('#showproduct');
                        table.append('<tr id="ptitle"><th>ID</th><th>ProductName</th><th>ProductPrice</th><th>ProductDate</th><th>Note</th></tr>');
                        $.each(data, function(i, n) {
                            var tr = "<tr align='center'>" + 
                                     "<td>" + n.pid + "</td>" + 
                                     "<td>" + n.pname + "</td>" + 
                                     "<td>" + n.price + "</td>" + 
                                     "<td>" + n.pdate + "</td>" + 
                                     "<td>" + n.note + "</td>" + 
                                     "</tr>";
                            table.append(tr);
                        });
                    }
                }
            });
        }

        function change(page) {
            indexPage = page;
            load(indexPage);
        }

        // 用戶在前端界面上填寫產品信息，然後通過 AJAX 請求將這些信息發送到後端，進行產品的保存或更新操作
        function saveProduct() {
            let id = $('#pId').val();
            let pName = $('#pName').val();
            let pPrice = $('#pPrice').val();
            let pDate = $('#pDate').val();
            let note = $('#note').val();
            
            $.ajax({
                type: 'get',
                url: '/product/save?pid=' + id + '&pName=' + pName + '&pPrice=' + pPrice + '&pDate=' + pDate + '&note=' + note,
                dataType: 'JSON',
                contentType: 'application/json',
                success: function(data) {
                    alert('success');
                }
            });
        }

        // 用id去刪除
        function deleteProduct() {
            let id = $('#pId').val();
            $.ajax({
                type: 'post',
                url: '/product/deleteById?id=' + id,
                dataType: 'JSON',
                contentType: 'application/json',
                success: function(data) {
                    alert('delete success');
                }
            });
        }

        // 從後端加載產品數據並將其顯示在前端表單中
        function loadProduct() {
            $.ajax({
                type: 'get',
                url: '/product/loadProduct?pid=' + $('#pId').val(),
                dataType: 'JSON',
                contentType: 'application/json',
                success: function(data) {
                    $('#pName').val(data.pname);
                    $('#pPrice').val(data.price);
                    $('#pDate').val(data.pdate);
                    $('#note').val(data.note);
                    console.log(data);
                }
            });
        }
    </script>
    <title>Product Lists</title>
</head>

<style>
    body {
        background-color: #FFEBCD;
    }
    #centerContainer {
        text-align: center;
        margin-top: 20px; /* 可以根據需要調整 */
    }
    #centerContainer input,
    #centerContainer button {
        display: inline-block;
    }
</style>

<body>
    <div id="productListTitle">ProductQuery</div>
    <div id="centerContainer">
        <input type="text" id="searchProductName"/> 
        <button onclick="load(1)">Search By Product Name</button>
    </div>
    <table id="showproduct" border="1"></table>
    <table id="showpage">
        <tr>
            <td>Total Pages: ${totalPages} Total Records: ${totalElements}</td>
            <td colspan="3" align="right"> 
                Previous
                <c:forEach var="i" begin="1" end="${totalPages}" step="1">
                    <button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
                </c:forEach>
                Next
            </td>
        </tr>
    </table>

    <div>
        <label>ID</label>
        <input type="text" id="pId"/>
        <label>Product Name</label>
        <input type="text" id="pName"/>
        <label>Product Price</label>
        <input type="text" id="pPrice"/>
        <label>Product Date</label>
        <input type="text" id="pDate"/>
        <label>Note</label>
        <input type="text" id="note"/>
    </div>
    <div>
        <button onclick="saveProduct()">Create or Update</button>
        <button onclick="loadProduct()">Read by ID</button>
        <button onclick="deleteProduct()">Delete by ID</button>
    </div>
</body>
</html>
