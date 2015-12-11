// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.video.adsdk.internal:
//            BrowserActivity

class this._cls0 extends WebViewClient
{

    final BrowserActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        BrowserActivity.access$000(BrowserActivity.this).setVisibility(4);
        BrowserActivity.access$100(BrowserActivity.this);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onLoadResource(webview, s);
        BrowserActivity.access$000(BrowserActivity.this).setVisibility(0);
    }

    ()
    {
        this$0 = BrowserActivity.this;
        super();
    }
}
