// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            QaDiscussionsActivity

class this._cls0 extends WebViewClient
{

    final QaDiscussionsActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        loading.setVisibility(8);
        super.onPageFinished(webview, s);
        if (!QaDiscussionsActivity.access$000(QaDiscussionsActivity.this))
        {
            qaDiscussionsView.loadUrl((new StringBuilder()).append("javascript:window.").append(QaDiscussionsActivity.access$100()).append(".").append("isPageHealthy").append("(").append("document.getElementById('questions-list') != undefined ? true : false").append(");").toString());
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        loading.setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        loading.setVisibility(8);
        QaDiscussionsActivity.access$200(QaDiscussionsActivity.this);
    }

    ()
    {
        this$0 = QaDiscussionsActivity.this;
        super();
    }
}
