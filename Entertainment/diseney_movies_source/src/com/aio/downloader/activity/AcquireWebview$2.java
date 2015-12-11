// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.activity:
//            AcquireWebview

class this._cls0 extends WebViewClient
{

    final AcquireWebview this$0;

    public void onPageFinished(WebView webview, String s)
    {
        AcquireWebview.access$0(AcquireWebview.this).setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        AcquireWebview.access$0(AcquireWebview.this).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
    }

    ()
    {
        this$0 = AcquireWebview.this;
        super();
    }
}
