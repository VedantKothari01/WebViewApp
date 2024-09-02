package com.example.webviewapp;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private RemoteContentActivity activity;

    public MyWebViewClient(RemoteContentActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        activity.urlEditText.setText(request.getUrl().toString());
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

        // Show progress bar in RemoteContentActivity
        activity.showLoading();
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        // Hide progress bar in RemoteContentActivity
        super.onPageFinished(view, url);
        activity.hideLoading();
    }
}
