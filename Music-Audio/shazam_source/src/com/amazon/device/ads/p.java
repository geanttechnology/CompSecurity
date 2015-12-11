// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.graphics.Rect;

// Referenced classes of package com.amazon.device.ads:
//            ds, co, cn, o, 
//            c, k, v

class p
{

    private static final String a = com/amazon/device/ads/p.getSimpleName();
    private final o b;
    private final ds.k c;
    private final cn d;

    public p(o o)
    {
        this(o, ds.a());
    }

    private p(o o, ds.k k)
    {
        b = o;
        c = k;
        d = co.a(a);
    }

    protected o a()
    {
        return b;
    }

    public final void a(c c1)
    {
        a(new Runnable(c1) {

            final c a;
            final p b;

            public final void run()
            {
                b.a().b();
            }

            
            {
                b = p.this;
                a = c1;
                super();
            }
        });
    }

    public void a(c c1, Rect rect)
    {
        d.b("Ad listener called - Ad Resized.", null);
    }

    public final void a(c c1, k k)
    {
        a(new Runnable(c1, k) {

            final c a;
            final k b;
            final p c;

            public final void run()
            {
                c.a().a(b);
            }

            
            {
                c = p.this;
                a = c1;
                b = k;
                super();
            }
        });
    }

    public final void a(c c1, v v)
    {
        a(new Runnable(c1, v) {

            final c a;
            final v b;
            final p c;

            public final void run()
            {
                c.a().a();
            }

            
            {
                c = p.this;
                a = c1;
                b = v;
                super();
            }
        });
    }

    protected final void a(Runnable runnable)
    {
        c.a(runnable, ds.b.b, ds.c.a);
    }

    public final void b(c c1)
    {
        a(new Runnable(c1) {

            final c a;
            final p b;

            public final void run()
            {
                b.a().c();
            }

            
            {
                b = p.this;
                a = c1;
                super();
            }
        });
    }

    public final void c(c c1)
    {
        a(new Runnable(c1) {

            final c a;
            final p b;

            public final void run()
            {
                b.a().d();
            }

            
            {
                b = p.this;
                a = c1;
                super();
            }
        });
    }

    public void d(c c1)
    {
        d.b("Ad listener called - Ad Expired.", null);
    }

}
