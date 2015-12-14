// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.socialin.android.tumblr:
//            TumblrOAuthActivity, a

final class a
    implements Runnable
{

    private String a;
    private TumblrOAuthActivity b;

    public final void run()
    {
        WebView webview = (WebView)b.findViewById(0x7f100a6f);
        webview.setWebViewClient(new a(b, "android-tumblr://success"));
        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearHistory();
        webview.clearFormData();
        webview.getSettings().setCacheMode(2);
        webview.loadUrl(a);
    }

    (TumblrOAuthActivity tumblroauthactivity, String s)
    {
        b = tumblroauthactivity;
        a = s;
        super();
    }
}
