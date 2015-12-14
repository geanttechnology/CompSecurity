// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.adapters.n;
import com.facebook.ads.internal.adapters.o;

// Referenced classes of package com.facebook.ads.internal:
//            h, a

class a
    implements o
{

    final Runnable a;
    final h b;

    public void a(n n)
    {
        h.e(b);
        h.f(b).removeCallbacks(a);
        h.b(b, n);
        b.a.a();
    }

    public void a(n n, AdError aderror)
    {
        h.e(b);
        h.f(b).removeCallbacks(a);
        h.a(b, n);
        h.c(b);
    }

    ters.n(h h1, Runnable runnable)
    {
        b = h1;
        a = runnable;
        super();
    }
}
