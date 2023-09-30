<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Table with a Column Having Multiple Sub-Columns</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #000;
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Header 1</th>
                <th>Header 2</th>
                <th>Header 3</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td rowspan="3">Column 1</td>
                <td>Sub-Column 1</td>
                <td>Sub-Column 2</td>
            </tr>
            <tr>
                <td>Sub-Column 3</td>
                <td>Sub-Column 4</td>
            </tr>
            <tr>
                <td>Sub-Column 5</td>
                <td>Sub-Column 6</td>
            </tr>
            <tr>
                <td>Column 2</td>
                <td>Sub-Column 1</td>
                <td>Sub-Column 2</td>
            </tr>
            <!-- Add more rows as needed -->
        </tbody>
    </table>
</body>
</html>
