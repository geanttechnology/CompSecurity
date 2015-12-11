// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.activity:
//            MiniGamePlayActivity

public class this._cls0 extends WebViewClient
{

    final MiniGamePlayActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        MiniGamePlayActivity.access$0(MiniGamePlayActivity.this).setVisibility(8);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        MiniGamePlayActivity.access$0(MiniGamePlayActivity.this).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        MiniGamePlayActivity.access$1(MiniGamePlayActivity.this).setVisibility(0);
        MiniGamePlayActivity.access$2(MiniGamePlayActivity.this).loadData("", "text/html", "UTF-8");
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        return super.shouldInterceptRequest(webview, s);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return super.shouldOverrideUrlLoading(webview, s);
    }

    public ()
    {
        this$0 = MiniGamePlayActivity.this;
        super();
    }
}
