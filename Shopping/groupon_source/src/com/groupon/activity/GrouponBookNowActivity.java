// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.groupon.util.WebViewHelper;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class GrouponBookNowActivity extends GrouponActivity
{

    WebView bookNewWebView;
    ProgressBar loadingView;
    String travelBookingUrlExtra;

    public GrouponBookNowActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030041);
        bundle = travelBookingUrlExtra;
        bookNewWebView.setWebViewClient(new WebViewClient() {

            final GrouponBookNowActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                loadingView.setVisibility(8);
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                loadingView.setVisibility(0);
                super.onPageStarted(webview, s, bitmap);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                super.onReceivedError(webview, i, s, s1);
                loadingView.setVisibility(8);
            }

            
            {
                this$0 = GrouponBookNowActivity.this;
                super();
            }
        });
        WebViewHelper.addInAppUserAgent(bookNewWebView);
        bookNewWebView.getSettings().setJavaScriptEnabled(true);
        bookNewWebView.loadUrl(bundle);
    }
}
