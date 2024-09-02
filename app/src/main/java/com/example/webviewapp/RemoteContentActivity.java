package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

public class RemoteContentActivity extends AppCompatActivity {
    public WebView webView;
    private ProgressBar progressBar;
    public EditText urlEditText;
    private ImageButton loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_content);

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        urlEditText = findViewById(R.id.editTextText);
        loadButton = findViewById(R.id.imageButton);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient(this));

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndLoadUrl();
                hideKeyboard();
            }
        });
    }

    private void validateAndLoadUrl() {
        String url = urlEditText.getText().toString().trim();
        if (url.isEmpty()) {
            showAlertDialog("Input Error", "Please enter a valid URL.");
        } else {
            // Prepend "http://" to the URL
            String fullUrl = "http://" + url;

            // Check for a valid URL format
            if (!URLUtil.isValidUrl(fullUrl) || !isValidDomain(url)) {
                showAlertDialog("Invalid URL", "The URL format is invalid. Please enter a valid URL.");
            } else {
                // Load the URL in the WebView
                webView.loadUrl(fullUrl);
            }
        }
    }

    // A method to check if the domain is valid
    private boolean isValidDomain(String url) {
        return url.matches("^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/.*)?$");
    }


    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE); // Show the progress bar
    }

    public void hideLoading() {
        progressBar.setVisibility(View.GONE); // Hide the progress bar
    }

    private void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(urlEditText.getWindowToken(), 0);
    }
}
