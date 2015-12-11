// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.AdSize;
import com.google.ads.l;
import com.google.ads.n;
import java.util.LinkedList;

// Referenced classes of package com.google.ads.internal:
//            c, d, h, AdWebView

private class h
    implements Runnable
{

    final c a;
    private final d b;
    private final WebView c;
    private final LinkedList d;
    private final int e;
    private final boolean f;
    private final String g;
    private final AdSize h;

    public void run()
    {
        if (c != null)
        {
            c.stopLoading();
            c.destroy();
        }
        b.a(d);
        b.a(e);
        b.a(f);
        b.a(g);
        if (h != null)
        {
            ((h)((n)com.google.ads.internal.c.b(a).a.a()).g.a()).b(h);
            b.l().setAdSize(h);
        }
        b.E();
    }

    public bView(c c1, d d1, WebView webview, LinkedList linkedlist, int i, boolean flag, String s, 
            AdSize adsize)
    {
        a = c1;
        super();
        b = d1;
        c = webview;
        d = linkedlist;
        e = i;
        f = flag;
        g = s;
        h = adsize;
    }
}
