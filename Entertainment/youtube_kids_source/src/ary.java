// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

public final class ary
    implements arp, asq
{

    final asa a;
    private final Handler b;
    private final atf c;
    private final atl d;
    private long e;
    private long f;
    private long g;
    private int h;

    public ary()
    {
        this(null, null);
    }

    public ary(Handler handler, asa asa)
    {
        this(handler, asa, new atf());
    }

    private ary(Handler handler, asa asa, atf atf1)
    {
        this(handler, asa, atf1, 2000);
    }

    private ary(Handler handler, asa asa, atf atf1, int i)
    {
        b = handler;
        a = asa;
        c = atf1;
        d = new atl(2000);
        g = -1L;
    }

    public final long a()
    {
        this;
        JVM INSTR monitorenter ;
        long l = g;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        e = e + (long)i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (h == 0)
        {
            f = c.a();
        }
        h = h + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void c()
    {
        this;
        JVM INSTR monitorenter ;
        float f1;
        int i;
        long l;
        long l1;
        long l2;
        boolean flag;
        if (h > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        l1 = c.a();
        i = (int)(l1 - f);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        f1 = (e * 8000L) / (long)i;
        d.a((int)Math.sqrt(e), f1);
        f1 = d.a(0.5F);
        if (Float.isNaN(f1))
        {
            l = -1L;
        } else
        {
            l = (long)f1;
        }
        g = l;
        l = e;
        l2 = g;
        if (b != null && a != null)
        {
            b.post(new arz(this, i, l, l2));
        }
        h = h - 1;
        if (h > 0)
        {
            f = l1;
        }
        e = 0L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
