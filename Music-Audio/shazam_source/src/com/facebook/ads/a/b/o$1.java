// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.facebook.ads.a.b:
//            o, e

final class lient extends WebChromeClient
{

    final o a;

    public final void onProgressChanged(WebView webview, int i)
    {
        if (i == 100 && o.a(a) != null)
        {
            o.a(a).a(a);
        }
    }

    lient(o o1)
    {
        a = o1;
        super();
    }
}
