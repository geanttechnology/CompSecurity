// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e;

import e.d.d.p;

// Referenced classes of package e:
//            e, k, f

public abstract class j
    implements e, k
{

    private static final Long a = Long.valueOf(0x8000000000000000L);
    private final p b;
    private final j c;
    private f d;
    private long e;

    protected j()
    {
        this(null, false);
    }

    protected j(j j1)
    {
        this(j1, true);
    }

    private j(j j1, boolean flag)
    {
        e = a.longValue();
        c = j1;
        if (flag && j1 != null)
        {
            j1 = j1.b;
        } else
        {
            j1 = new p();
        }
        b = j1;
    }

    protected final void a(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("number requested cannot be negative: ")).append(l).toString());
        }
        this;
        JVM INSTR monitorenter ;
        f f1;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        f1 = d;
        this;
        JVM INSTR monitorexit ;
        f1.a(l);
        return;
        if (e != a.longValue()) goto _L2; else goto _L1
_L1:
        e = l;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        l = e + l;
        if (l >= 0L)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        e = 0x7fffffffffffffffL;
          goto _L3
        e = l;
          goto _L3
    }

    public void a(f f1)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        long l;
        l = e;
        d = f1;
        boolean flag = flag1;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        flag = flag1;
        if (l == a.longValue())
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        if (flag)
        {
            c.a(d);
            return;
        }
        break MISSING_BLOCK_LABEL_63;
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
        if (l == a.longValue())
        {
            d.a(0x7fffffffffffffffL);
            return;
        } else
        {
            d.a(l);
            return;
        }
    }

    public final void a(k k1)
    {
        b.a(k1);
    }

    public final void b()
    {
        b.b();
    }

    public final boolean c()
    {
        return b.c();
    }

    public void d()
    {
    }

}
