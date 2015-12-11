// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmHtmlActivity

class val.progressView extends WebChromeClient
{

    final RtmHtmlActivity this$0;
    final View val$progressView;

    public void onProgressChanged(WebView webview, int i)
    {
        webview = val$progressView;
        if (i <= 99)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        webview.setVisibility(i);
    }

    ()
    {
        this$0 = final_rtmhtmlactivity;
        val$progressView = View.this;
        super();
    }
}
