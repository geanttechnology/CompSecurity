// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.mopub.common:
//            MoPubBrowser

final class init> extends WebChromeClient
{

    final MoPubBrowser a;

    public final void onProgressChanged(WebView webview, int i)
    {
        a.setTitle("Loading...");
        a.setProgress(i * 100);
        if (i == 100)
        {
            a.setTitle(webview.getUrl());
        }
    }

    (MoPubBrowser mopubbrowser)
    {
        a = mopubbrowser;
        super();
    }
}
