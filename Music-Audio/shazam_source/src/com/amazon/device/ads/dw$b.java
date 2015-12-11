// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.amazon.device.ads:
//            dw, cx

private final class b extends WebViewClient
{

    final dw a;
    private final cx b;

    public final void onPageFinished(WebView webview, String s)
    {
        if (b != null)
        {
            b.a(s);
        }
    }

    public t(dw dw1, cx cx1)
    {
        a = dw1;
        super();
        b = cx1;
    }
}
