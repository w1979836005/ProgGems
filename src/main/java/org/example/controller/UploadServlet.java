package org.example.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                content.append(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to read request content");
            return;
        }

        System.out.println(content);
        // 指定保存文件的路径和文件名
        String savePath = "D:/develop/files"; // 修改为实际的保存路径
        String fileName = "savedFile.md"; // 修改为实际的文件名

        File saveDirectory = new File(savePath);
        if (!saveDirectory.exists()) {
            saveDirectory.mkdirs(); // 创建目录及其父目录
        }

        // 将文件内容写入到服务器端的文件中
        try (PrintWriter writer = new PrintWriter(new File(savePath, fileName))) {
            writer.println(content.toString());
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save file");
            return;
        }

        // 发送响应给前端
        response.getWriter().write("File saved successfully!");
    }
}
