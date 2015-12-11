// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.kt;
import android.support.v7.ku;
import android.support.v7.wf;
import com.google.android.gms.common.internal.x;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, s, x, r, 
//            t, ai, c

public class n extends p
{

    private final com.google.android.gms.analytics.internal.x a;

    public n(r r, s s1)
    {
        super(r);
        x.a(s1);
        a = s1.j(r);
    }

    static com.google.android.gms.analytics.internal.x a(n n1)
    {
        return n1.a;
    }

    public long a(t t)
    {
        D();
        x.a(t);
        m();
        long l = a.a(t, true);
        if (l == 0L)
        {
            a.a(t);
        }
        return l;
    }

    protected void a()
    {
        a.E();
    }

    public void a(ai ai)
    {
        D();
        r().a(new Runnable(ai) {

            final ai a;
            final n b;

            public void run()
            {
                n.a(b).a(a);
            }

            
            {
                b = n.this;
                a = ai;
                super();
            }
        });
    }

    public void a(c c1)
    {
        x.a(c1);
        D();
        b("Hit delivery requested", c1);
        r().a(new Runnable(c1) {

            final c a;
            final n b;

            public void run()
            {
                n.a(b).a(a);
            }

            
            {
                b = n.this;
                a = c1;
                super();
            }
        });
    }

    public void a(String s1, Runnable runnable)
    {
        x.a(s1, "campaign param can't be empty");
        r().a(new Runnable(s1, runnable) {

            final String a;
            final Runnable b;
            final n c;

            public void run()
            {
                n.a(c).a(a);
                if (b != null)
                {
                    b.run();
                }
            }

            
            {
                c = n.this;
                a = s1;
                b = runnable;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        a("Network connectivity status changed", Boolean.valueOf(flag));
        r().a(new Runnable(flag) {

            final boolean a;
            final n b;

            public void run()
            {
                n.a(b).a(a);
            }

            
            {
                b = n.this;
                a = flag;
                super();
            }
        });
    }

    public void b()
    {
        a.b();
    }

    public void c()
    {
        D();
        Context context = o();
        if (kt.a(context) && ku.a(context))
        {
            Intent intent = new Intent(context, android/support/v7/ku);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        } else
        {
            a(((ai) (null)));
            return;
        }
    }

    public void d()
    {
        D();
        wf.d();
        a.f();
    }

    public void e()
    {
        b("Radio powered up");
        c();
    }

    void f()
    {
        m();
        a.e();
    }

    void g()
    {
        m();
        a.d();
    }
}
