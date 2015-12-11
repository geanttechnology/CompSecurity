// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            GrouponBookNowActivity

class this._cls0 extends WebViewClient
{

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

    ()
    {
        this$0 = GrouponBookNowActivity.this;
        super();
    }
}
