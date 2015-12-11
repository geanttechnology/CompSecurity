// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.openx.sdk.browser:
//            AdBrowserActivity, BrowserControls

class this._cls0 extends WebViewClient
{

    final AdBrowserActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (AdBrowserActivity.access$000(AdBrowserActivity.this) != null)
        {
            AdBrowserActivity.access$000(AdBrowserActivity.this).updateNavigationButtonsState();
        }
        super.onPageFinished(webview, s);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.startsWith("http"))
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
        if (AdBrowserActivity.access$000(AdBrowserActivity.this) != null)
        {
            AdBrowserActivity.access$000(AdBrowserActivity.this).openURLInExternalBrowser(s);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    ()
    {
        this$0 = AdBrowserActivity.this;
        super();
    }
}
