// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import a;
import ax;
import java.util.ArrayList;
import java.util.List;
import m;
import q;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            x, a

abstract class b extends a
{

    private final String b;
    private final List c = new ArrayList();
    private final x d;
    private a e;
    private Runnable f;

    b(x x1, String s, Object obj)
    {
        super(obj);
        b = s;
        d = x1;
        f = new Runnable() {

            private b a;

            public final void run()
            {
                b.a(a, a.a(b.a(a).c(), b.b(a), b.c(a)));
            }

            
            {
                a = b.this;
                super();
            }
        };
    }

    static a a(b b1, a a1)
    {
        b1.e = a1;
        return a1;
    }

    static x a(b b1)
    {
        return b1.d;
    }

    static String b(b b1)
    {
        return b1.b;
    }

    static List c(b b1)
    {
        return b1.c;
    }

    static a d(b b1)
    {
        return b1.e;
    }

    protected abstract a a(m m, String s, List list);

    protected final void a()
    {
        if (f != null)
        {
            ax.a(f);
            f = null;
        }
    }

    public void addParam(String s, com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary)
    {
        c.add(new q(s, dictionary));
    }

    public void addParam(String s, com.nuance.nmdp.speechkit.util.pdx.PdxValue.String s1)
    {
        c.add(new q(s, s1));
    }

    public void cancel()
    {
        d.e();
        ax.a(new Runnable() {

            private b a;

            public final void run()
            {
                b.d(a).c();
            }

            
            {
                a = b.this;
                super();
            }
        });
    }

    public void start()
    {
        d.e();
        ax.a(new Runnable() {

            private b a;

            public final void run()
            {
                b.d(a).b();
            }

            
            {
                a = b.this;
                super();
            }
        });
    }
}
