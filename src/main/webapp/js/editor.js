
document.addEventListener("DOMContentLoaded", function() {
    // 获取按钮和编辑器容器的引用
    const showEditorButton = document.querySelector("#showEditorButton");
    const editorContainer = document.querySelector("#editorContainer");
    const saveButton = document.querySelector("#saveButton");

    // 定义自定义主题
    const customTheme = {
        content: {
            background: '#ccc' // 设置编辑器区域的背景色为灰色
        }
    };

    // 初始化编辑器
    const editor = new toastui.Editor({
        el: editorContainer,
        initialEditType: 'markdown', // 初始编辑类型为 Markdown
        previewStyle: 'vertical', // 预览样式为垂直布局
        height: '300px', // 设置编辑器高度
        theme: customTheme, // 使用自定义主题
        initialValue: '' // 设置编辑器的初始内容
    });

    // 在按钮上添加点击事件监听器，用于显示/隐藏编辑器
    showEditorButton.addEventListener("click", function() {
        // 切换编辑器的显示状态
        editorContainer.style.display = (editorContainer.style.display === "none") ? "block" : "none";
    });

    // 在保存按钮上添加点击事件监听器，用于保存编辑器内容
    saveButton.addEventListener("click", function() {
        // 获取编辑器的内容
        const content = editor.getMarkdown();
        alert(content);
        // 模拟保存操作，这里可以替换为实际的保存逻辑
        // 创建 FormData 对象并添加编辑器内容作为参数
        const formData = new FormData();
        formData.append('content', content);

        alert(formData);
        // 发送 POST 请求到指定的保存文件的 Servlet
        fetch('/myApp_war/UploadServlet', {
            method: 'POST',
            body: formData,
            headers: {
                'Content-Type': 'text/plain' // 设置请求头的Content-Type为纯文本
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                console.log(data); // 输出保存成功的消息
                alert("Content saved successfully!");
            })
            .catch(error => {
                console.error('There was a problem with your fetch operation:', error);
            });
        alert("Content saved successfully!");
    });
});

