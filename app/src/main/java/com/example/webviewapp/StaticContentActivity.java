package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;
import java.nio.charset.StandardCharsets;

public class StaticContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_content);

        WebView webView = findViewById(R.id.webViewStatic);

        String unencoded = "<html>\n" +
                "<head><title>Welcome to Nmims</title></head>\n" +
                "<body>\n" +
                "<h1>Welcome to Nmims</h1>\n" +
                "<p>This is a static web HTML Content.</p>\n" +
                "<input type=\"button\" value=\"Say Hello\" onclick=\"showAndroidToast('Hello Vedant:)')\">\n" +
                "<script type=\"text/javascript\">\n" +
                "    function showAndroidToast(toast){\n" +
                "        Android.showToast(toast);\n" +
                "    }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        String encodedHTML = Base64.encodeToString(unencoded.getBytes(StandardCharsets.UTF_8), Base64.NO_PADDING);
        webView.loadData(encodedHTML, "text/html", "base64");
    }
}
