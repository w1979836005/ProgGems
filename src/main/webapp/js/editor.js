document.addEventListener("DOMContentLoaded", function() {
    // 获取按钮和编辑器容器的引用
    const showEditorButton = document.querySelector("#showEditorButton");
    const editorContainer = document.querySelector("#editorContainer");

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

    // 在按钮上添加点击事件监听器
    showEditorButton.addEventListener("click", function() {
        // 检查编辑器容器的当前显示状态
        if (editorContainer.style.display === "none") {
            // 如果编辑器容器当前是隐藏状态，则显示编辑器
            editorContainer.style.display = "block";
        } else {
            // 如果编辑器容器当前是显示状态，则隐藏编辑器
            editorContainer.style.display = "none";
        }
    });
});
