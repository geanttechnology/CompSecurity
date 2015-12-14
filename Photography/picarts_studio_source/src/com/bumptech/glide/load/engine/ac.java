// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import myobfuscated.ak.a;
import myobfuscated.ak.b;
import myobfuscated.ak.d;
import myobfuscated.ak.f;

// Referenced classes of package com.bumptech.glide.load.engine:
//            ad

final class ac
    implements ad, d
{

    private static final android.support.v4.util.Pools.Pool a = myobfuscated.ak.a.b(new b() {

        public final Object a()
        {
            return new ac((byte)0);
        }

    });
    private final f b;
    private ad c;
    private boolean d;
    private boolean e;

    private ac()
    {
        b = f.a();
    }

    ac(byte byte0)
    {
        this();
    }

    static ac a(ad ad1)
    {
        ac ac1 = (ac)a.acquire();
        ac1.e = false;
        ac1.d = true;
        ac1.c = ad1;
        return ac1;
    }

    public final Class a()
    {
        return c.a();
    }

    public final Object b()
    {
        return c.b();
    }

    public final int c()
    {
        return c.c();
    }

    public final void d()
    {
        this;
        JVM INSTR monitorenter ;
        b.b();
        e = true;
        if (!d)
        {
            c.d();
            c = null;
            a.release(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e()
    {
        this;
        JVM INSTR monitorenter ;
        b.b();
        if (!d)
        {
            throw new IllegalStateException("Already unlocked");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        d = false;
        if (e)
        {
            d();
        }
        this;
        JVM INSTR monitorexit ;
    }

    public final f e_()
    {
        return b;
    }

}
