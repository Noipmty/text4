<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人所得税计算器</title>
    <script>
        function calculateTax() {
            var incomeInput = document.getElementById("income").value;
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "http://localhost:8080/demo2_war_exploded/tax-calculator", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("income="+ incomeInput);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("result").innerHTML = xhr.responseText;
                } else {
                    document.getElementById("result").innerHTML = "计算出错";
                }
            }
        }
    </script>
</head>
<body>
<h1>请输入工资计算个人所得税</h1>
<form onsubmit="calculateTax(); return false;">
    工资: <input type="text" id="income" name="income" />
    <input type="submit" value="计算" />
    <div id="result"></div>
</form>
</body>
</html>