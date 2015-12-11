// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y;

import android.content.Context;
import com.shazam.android.ae.m;
import com.shazam.android.y.c.b;
import com.shazam.android.y.e.d;
import com.shazam.h.l;
import com.shazam.i.b.y.a.c;
import com.shazam.i.b.y.e;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.shazam.android.y:
//            b, d, c

public final class a
    implements com.shazam.android.y.b
{

    com.shazam.android.y.c a;
    d b;
    private Executor c;

    public a(Context context)
    {
        com.shazam.i.b.y.a.a = context;
        c = Executors.newFixedThreadPool(1, e.a("GuaranteedPersistence-%d"));
        context = com.shazam.i.b.y.a.c.a();
        if (com.shazam.i.b.y.c.a == null)
        {
            throw new IllegalArgumentException("Http client instance was not injected. Please call GuaranteedHttpHttpClientInjector.setHttpClientInstance() before using");
        } else
        {
            a = new com.shazam.android.y.d(context, new com.shazam.android.y.f.a(com.shazam.i.b.y.c.a, new com.shazam.android.y.g.a(), new com.shazam.android.y.a.a(com.shazam.i.b.y.a.a)), Executors.newFixedThreadPool(3, e.a("GuaranteedNetwork-%d")));
            b = com.shazam.i.b.y.a.c.a();
            return;
        }
    }

    public final void a()
    {
        c.execute(new Runnable() {

            final a a;

            public final void run()
            {
                a.b.b();
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    public final void a(com.shazam.android.y.d.a a1)
    {
        c.execute(new Runnable(a1) {

            final com.shazam.android.y.d.a a;
            final a b;

            public final void run()
            {
                try
                {
                    com.shazam.android.y.g.c.a(a);
                    b.b.a(a);
                    b.a.a();
                    return;
                }
                catch (b b1)
                {
                    m.a(this, "Could not save request", b1);
                }
            }

            
            {
                b = a.this;
                a = a2;
                super();
            }
        });
    }

    public final void a(l l)
    {
        com.shazam.android.y.d.a a1 = new com.shazam.android.y.d.a();
        a1.b = l;
        a(a1.a());
    }
}
