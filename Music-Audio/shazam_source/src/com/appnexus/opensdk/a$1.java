// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            a

static final class Manager extends WebViewClient
{

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        b.b(b.b, (new StringBuilder("RecordEvent completed loading: ")).append(s).toString());
        webview = CookieSyncManager.getInstance();
        if (webview != null)
        {
            webview.sync();
        }
    }

    Manager()
    {
    }
}
