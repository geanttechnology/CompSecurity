// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            h, e, dw, cn, 
//            ae, ag, j, ds, 
//            cl, dd

private final class <init>
    implements 
{

    final h a;

    public final void a(WebView webview, String s)
    {
        if (webview.equals(a.a().a.d))
        {
            webview = a;
            if (webview.n())
            {
                ((h) (webview)).d.b("Ad Rendered", null);
                dd dd1;
                if (((h) (webview)).x.equals(ae.d))
                {
                    if (!webview.p())
                    {
                        ((h) (webview)).C.set(false);
                        ((h) (webview)).m.a();
                        j j1 = ((h) (webview)).o;
                        long l = System.currentTimeMillis();
                        l = j1.i - l;
                        if (l > 0L)
                        {
                            ((h) (webview)).m.b();
                            ((h) (webview)).m.a(new <init>(webview), l);
                        }
                        webview.a(ae.e);
                        ds.b(new <init>(webview));
                        l = System.nanoTime();
                        if (((h) (webview)).f != null)
                        {
                            ((h) (webview)).f.c(.y, l);
                            ((h) (webview)).f.c(.a, l);
                            ((h) (webview)).f.c(.b, l);
                            webview.q();
                            webview.c(true);
                        }
                        ds.b(new <init>(webview));
                    }
                } else
                {
                    ((h) (webview)).d.b((new StringBuilder("Ad State was not Rendering. It was ")).append(((h) (webview)).x).toString(), null);
                }
                dd1 = new dd(.a);
                dd1.b.put("url", s);
                webview.a(dd1);
            }
        }
    }

    private (h h1)
    {
        a = h1;
        super();
    }

    a(h h1, byte byte0)
    {
        this(h1);
    }
}
