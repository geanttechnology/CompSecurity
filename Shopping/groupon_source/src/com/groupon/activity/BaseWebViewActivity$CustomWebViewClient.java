// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.crittercism.app.Crittercism;
import com.groupon.util.WebViewHelper;
import java.net.URISyntaxException;

// Referenced classes of package com.groupon.activity:
//            BaseWebViewActivity

public class helper extends WebViewClient
{

    private WebViewHelper helper;
    final BaseWebViewActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        progressBar.setVisibility(8);
        navigationFinished(s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        progressBar.setVisibility(0);
        navigationStarted(s);
        if (helper != null)
        {
            helper.webViewNavigatingStarting(s);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        webView.loadUrl("about:blank");
        progressBar.setVisibility(8);
        showRetryDialog();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (helper.shouldOverrideUrlLoading(s))
        {
            return true;
        }
        if (s.startsWith("http:") || s.startsWith("https:"))
        {
            return false;
        }
        try
        {
            startActivity(Intent.parseUri(s, 0));
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Crittercism.logHandledException(webview);
            return false;
        }
        return true;
    }

    public (WebViewHelper webviewhelper)
    {
        this$0 = BaseWebViewActivity.this;
        super();
        helper = webviewhelper;
    }
}
