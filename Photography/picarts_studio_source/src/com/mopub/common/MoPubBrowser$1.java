// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.mopub.common:
//            MoPubBrowser

class init> extends WebChromeClient
{

    final MoPubBrowser this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        setTitle("Loading...");
        setProgress(i * 100);
        if (i == 100)
        {
            setTitle(webview.getUrl());
        }
    }

    ()
    {
        this$0 = MoPubBrowser.this;
        super();
    }
}
