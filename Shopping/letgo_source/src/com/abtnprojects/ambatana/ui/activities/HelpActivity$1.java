// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            HelpActivity

class a extends WebViewClient
{

    final HelpActivity a;

    public void onPageFinished(WebView webview, String s)
    {
        a.progressBar.setVisibility(8);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        a.progressBar.setVisibility(0);
    }

    (HelpActivity helpactivity)
    {
        a = helpactivity;
        super();
    }
}
