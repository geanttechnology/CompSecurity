// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ja;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, s, r, x, 
//            o, t, ai, c

public final class n extends p
{

    final x a;

    public n(r r1, s s1)
    {
        super(r1);
        w.a(s1);
        a = s1.c(r1);
    }

    public final long a(t t)
    {
        o();
        w.a(t);
        r.i();
        long l = a.b(t);
        if (l == 0L)
        {
            a.a(t);
        }
        return l;
    }

    protected final void a()
    {
        a.p();
    }

    public final void a(ai ai)
    {
        o();
        super.i.b().a(new Runnable(ai) {

            final ai a;
            final n b;

            public final void run()
            {
                b.a.a(a);
            }

            
            {
                b = n.this;
                a = ai;
                super();
            }
        });
    }

    public final void a(c c1)
    {
        w.a(c1);
        o();
        b("Hit delivery requested", c1);
        super.i.b().a(new Runnable(c1) {

            final c a;
            final n b;

            public final void run()
            {
                b.a.a(a);
            }

            
            {
                b = n.this;
                a = c1;
                super();
            }
        });
    }

    public final void b()
    {
        o();
        Context context = super.i.a;
        if (com.google.android.gms.analytics.a.a(context) && com.google.android.gms.analytics.b.a(context))
        {
            Intent intent = new Intent(context, com/google/android/gms/analytics/b);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        } else
        {
            a(((ai) (null)));
            return;
        }
    }

    public final void c()
    {
        o();
        ja.b();
        a.e();
    }

    final void d()
    {
        r.i();
        a.d();
    }

    final void e()
    {
        r.i();
        x x1 = a;
        r.i();
        x1.a = ((o) (x1)).i.c.a();
    }

    // Unreferenced inner class com/google/android/gms/analytics/internal/n$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final boolean a;
        final n b;

        public final void run()
        {
            b.a.f();
        }

            
            {
                b = n.this;
                a = flag;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/analytics/internal/n$2

/* anonymous class */
    public final class _cls2
        implements Runnable
    {

        final String a;
        final Runnable b;
        final n c;

        public final void run()
        {
            c.a.a(a);
            if (b != null)
            {
                b.run();
            }
        }

            public 
            {
                c = n.this;
                a = s1;
                b = runnable;
                super();
            }
    }

}
