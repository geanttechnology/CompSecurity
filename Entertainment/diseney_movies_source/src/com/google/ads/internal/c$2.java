// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.c;
import com.google.ads.l;
import com.google.ads.n;

// Referenced classes of package com.google.ads.internal:
//            c, d, h

class a
    implements Runnable
{

    final c a;
    final com.google.ads.internal.c b;

    public void run()
    {
        if (c.d(b) != null)
        {
            c.d(b).stopLoading();
            c.d(b).destroy();
        }
        ((d)((n)c.b(b).a.a()).b.a()).a(c.e(b));
        if (c.f(b) != null)
        {
            ((h)((n)c.b(b).a.a()).g.a()).b(c.f(b));
        }
        ((d)((n)c.b(b).a.a()).b.a()).a(a);
    }

    (com.google.ads.internal.c c1, c c2)
    {
        b = c1;
        a = c2;
        super();
    }
}
