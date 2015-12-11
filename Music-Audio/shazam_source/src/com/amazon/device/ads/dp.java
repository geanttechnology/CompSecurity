// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.util.SparseArray;

// Referenced classes of package com.amazon.device.ads:
//            ba, dn

abstract class dp
    implements ba.b, dn.a
{

    private static final SparseArray a = new SparseArray();
    private int b;
    private final ba c;
    final dn e;

    public dp(dn dn, ba ba1)
    {
        b = 1;
        e = dn;
        c = ba1;
    }

    private static void a(int i, ds.g g)
    {
        a.put(i, g);
    }

    private void a(Runnable runnable)
    {
        int i = b;
        ((ds.g)a.get(i, a.get(1))).a(runnable);
    }

    protected abstract void a();

    protected abstract void b();

    public final void c()
    {
        a(new Runnable() {

            final dp a;

            public final void run()
            {
                a.a();
            }

            
            {
                a = dp.this;
                super();
            }
        });
    }

    public final void d()
    {
        a(new Runnable() {

            final dp a;

            public final void run()
            {
                a.b();
            }

            
            {
                a = dp.this;
                super();
            }
        });
    }

    public final void e()
    {
        c.a(this);
    }

    static 
    {
        a(0, new ds.e());
        a(1, new ds.j());
    }
}
