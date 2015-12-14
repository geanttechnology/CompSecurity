// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            LegalInformationWebActivity

class val.progressBar extends WebViewClient
{

    final LegalInformationWebActivity this$0;
    final ProgressBar val$progressBar;

    public void onPageFinished(WebView webview, String s)
    {
        if (val$progressBar != null && val$progressBar.isShown())
        {
            val$progressBar.setVisibility(4);
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (val$progressBar != null && !val$progressBar.isShown())
        {
            val$progressBar.setVisibility(0);
        }
    }

    ()
    {
        this$0 = final_legalinformationwebactivity;
        val$progressBar = ProgressBar.this;
        super();
    }
}
