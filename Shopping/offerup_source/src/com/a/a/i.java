// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.a.a:
//            h, j, k

final class i
    implements Runnable
{

    final h a;
    private String b;

    i(h h1, String s)
    {
        a = h1;
        b = s;
        super();
    }

    public final void run()
    {
        h h1 = a;
        h.a(h1, new WebView(a.a.getApplicationContext()));
        WebSettings websettings = h.a(h1).getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setDomStorageEnabled(true);
        websettings.setPluginState(android.webkit.WebSettings.PluginState.ON);
        h.a(h1).setWebViewClient(new j(this));
        h.a(h1).setWebChromeClient(new k(this));
        h.a(h1).loadUrl(b);
    }
}
