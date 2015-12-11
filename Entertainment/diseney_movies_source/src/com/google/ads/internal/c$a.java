// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.n;

// Referenced classes of package com.google.ads.internal:
//            c, f, d, AdWebView

private static class e
    implements Runnable
{

    private final d a;
    private final WebView b;
    private final f c;
    private final com.google.ads.quest.ErrorCode d;
    private final boolean e;

    public void run()
    {
        if (b != null)
        {
            b.stopLoading();
            b.destroy();
        }
        if (c != null)
        {
            c.a();
        }
        if (e)
        {
            a.l().stopLoading();
            if (a.i().i.a() != null)
            {
                ((ViewGroup)a.i().i.a()).setVisibility(8);
            }
        }
        a.a(d);
    }

    public de(d d1, WebView webview, f f1, com.google.ads.quest.ErrorCode errorcode, boolean flag)
    {
        a = d1;
        b = webview;
        c = f1;
        d = errorcode;
        e = flag;
    }
}
