// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.webkit.WebView;

// Referenced classes of package com.mopub.common:
//            BrowserWebViewClient, UrlAction, MoPubBrowser

class this._cls0
    implements s
{

    final BrowserWebViewClient this$0;

    public void urlHandlingFailed(String s, UrlAction urlaction)
    {
    }

    public void urlHandlingSucceeded(String s, UrlAction urlaction)
    {
        if (urlaction.equals(UrlAction.OPEN_IN_APP_BROWSER))
        {
            BrowserWebViewClient.access$000(BrowserWebViewClient.this).getWebView().loadUrl(s);
            return;
        } else
        {
            BrowserWebViewClient.access$000(BrowserWebViewClient.this).finish();
            return;
        }
    }

    s()
    {
        this$0 = BrowserWebViewClient.this;
        super();
    }
}
