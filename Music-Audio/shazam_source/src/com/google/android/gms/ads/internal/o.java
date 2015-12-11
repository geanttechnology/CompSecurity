// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.gm;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.ads.internal:
//            a

public final class o
{
    public static final class a
    {

        final Handler a;

        public final void a(Runnable runnable)
        {
            a.removeCallbacks(runnable);
        }

        public a(Handler handler)
        {
            a = handler;
        }
    }


    final a a;
    final Runnable b;
    AdRequestParcel c;
    boolean d;
    boolean e;
    long f;

    public o(com.google.android.gms.ads.internal.a a1)
    {
        this(a1, new a(gm.a));
    }

    private o(com.google.android.gms.ads.internal.a a1, a a2)
    {
        d = false;
        e = false;
        f = 0L;
        a = a2;
        b = new Runnable(new WeakReference(a1)) {

            final WeakReference a;
            final o b;

            public final void run()
            {
                b.d = false;
                com.google.android.gms.ads.internal.a a3 = (com.google.android.gms.ads.internal.a)a.get();
                if (a3 != null)
                {
                    a3.c(b.c);
                }
            }

            
            {
                b = o.this;
                a = weakreference;
                super();
            }
        };
    }

    public final void a()
    {
        d = false;
        a.a(b);
    }

    public final void a(AdRequestParcel adrequestparcel)
    {
        a(adrequestparcel, 60000L);
    }

    public final void a(AdRequestParcel adrequestparcel, long l)
    {
        if (d)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        } else
        {
            c = adrequestparcel;
            d = true;
            f = l;
            if (!e)
            {
                (new StringBuilder("Scheduling ad refresh ")).append(l).append(" milliseconds from now.");
                com.google.android.gms.ads.internal.util.client.b.a(4);
                adrequestparcel = a;
                Runnable runnable = b;
                ((a) (adrequestparcel)).a.postDelayed(runnable, l);
                return;
            }
        }
    }
}
