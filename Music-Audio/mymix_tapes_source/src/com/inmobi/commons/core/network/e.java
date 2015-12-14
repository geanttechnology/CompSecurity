// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.a.a;

// Referenced classes of package com.inmobi.commons.core.network:
//            NetworkRequest

public class e
{

    private NetworkRequest a;
    private WebViewClient b;
    private WebView c;

    public e(NetworkRequest networkrequest, WebViewClient webviewclient)
    {
        b = webviewclient;
        a = networkrequest;
    }

    private void b()
    {
        c = new WebView(com.inmobi.commons.a.a.b());
        c.setWebViewClient(b);
        c.getSettings().setJavaScriptEnabled(true);
        c.getSettings().setCacheMode(2);
    }

    public void a()
    {
        b();
        String s1 = a.h();
        String s = s1;
        if (a.j() != null)
        {
            s = s1;
            if (a.j().trim().length() != 0)
            {
                s = (new StringBuilder()).append(s1).append("?").append(a.j()).toString();
            }
        }
        c.loadUrl(s);
    }
}
