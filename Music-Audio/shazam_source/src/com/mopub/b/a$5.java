// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.b:
//            a

final class ebViewClient extends WebViewClient
{

    final com.mopub.b.a a;

    public final void onPageFinished(WebView webview, String s)
    {
        webview = a;
        if (!((com.mopub.b.a) (webview)).d)
        {
            webview.d = true;
            if (((com.mopub.b.a) (webview)).a != null)
            {
                ((com.mopub.b.a) (webview)).a.a();
            }
        }
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        com.mopub.common.c.a.b((new StringBuilder("Error: ")).append(s).toString());
        super.onReceivedError(webview, i, s, s1);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return a.b(s);
    }

    (com.mopub.b.a a1)
    {
        a = a1;
        super();
    }
}
