// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.activity:
//            ContentUsActivity

public class this._cls0 extends WebViewClient
{

    final ContentUsActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        ContentUsActivity.access$0(ContentUsActivity.this).setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        ContentUsActivity.access$0(ContentUsActivity.this).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        super.shouldOverrideUrlLoading(webview, s);
        webview.loadUrl(s);
        return true;
    }

    public ()
    {
        this$0 = ContentUsActivity.this;
        super();
    }
}
