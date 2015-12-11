// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ij;
import com.google.android.gms.d.ka;
import com.google.android.gms.d.ke;

// Referenced classes of package com.google.android.gms.e:
//            bf, bq, bp, ai, 
//            dc, aj, cy, d, 
//            bh, b, a

public final class cz extends j
{
    private final class a
        implements cy.a
    {

        final cz a;

        private a()
        {
            a = cz.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    static interface b
        extends f
    {

        public abstract void a(String s);
    }

    static interface c
        extends f
    {
    }


    final Looper b;
    public final int c;
    final Context d;
    final d e;
    public final String f;
    public ka g;
    volatile cy h;
    private final ii i;
    private final a j;
    private final bh k;
    private c l;
    private com.google.android.gms.d.g.i m;
    private String n;
    private b o;

    private cz(Context context, d d1, String s, c c1, b b1, ka ka1, ii ii, 
            bh bh)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            super(Looper.getMainLooper());
            d = context;
            e = d1;
            b = Looper.getMainLooper();
            f = s;
            c = -1;
            l = c1;
            o = b1;
            g = ka1;
            j = new a((byte)0);
            m = new com.google.android.gms.d.g.i();
            i = ii;
            k = bh;
            context = bf.a();
            if (((bf) (context)).a != bf.a.b)
            {
                flag = flag1;
                if (((bf) (context)).a != bf.a.c)
                {
                    break label0;
                }
            }
            flag = flag1;
            if (f.equals(((bf) (context)).b))
            {
                flag = true;
            }
        }
        if (flag)
        {
            a(bf.a().c);
        }
    }

    public cz(Context context, d d1, String s, dc dc1)
    {
        this(context, d1, s, ((c) (new bq(context, s))), ((b) (new bp(context, s, dc1))), new ka(context), ij.d(), ((bh) (new ai("refreshing", ij.d()))));
        g.c = dc1.a;
    }

    private void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        n = s;
        if (o != null)
        {
            o.a(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    protected final g a(Status status)
    {
        return c(status);
    }

    protected final com.google.android.gms.e.b c(Status status)
    {
        if (h != null)
        {
            return h;
        }
        if (status == Status.d)
        {
            aj.a("timer expired: setting result to failure");
        }
        return new cy(status);
    }

    // Unreferenced inner class com/google/android/gms/e/cz$1

/* anonymous class */
    public final class _cls1
        implements com.google.android.gms.d.ka.a
    {

        final String a;
        final cz b;

        public final void a(ke ke1)
        {
            if (ke1.a.a != Status.a)
            {
                aj.a((new StringBuilder("Load request failed for the container ")).append(b.f).toString());
                b.a(b.c(Status.c));
                return;
            }
            com.google.android.gms.d.kf.c c1 = ke1.a.f;
            if (c1 == null)
            {
                aj.a("Response doesn't have the requested container");
                b.a(b.c(new Status(8, "Response doesn't have the requested container", null)));
                return;
            } else
            {
                long l1 = ke1.a.d;
                b.h = new cy(b.e, b.b, new com.google.android.gms.e.a(b.d, b.e.c, b.f, l1, c1), new cy.a(this) {

                    final _cls1 a;

            
            {
                a = _pcls1;
                super();
            }
                });
                b.a(b.h);
                return;
            }
        }

            public 
            {
                b = cz.this;
                a = s;
                super();
            }
    }

}
