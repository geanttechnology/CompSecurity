// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.b.a.b;

// Referenced classes of package com.b.e:
//            n, c

public final class d
    implements Runnable
{

    protected b a;
    protected Handler b;
    protected boolean c;
    protected long d;

    public d(b b1)
    {
        d = -1L;
        a = b1;
    }

    private void a(long l)
    {
        d = l;
        a.b.a("plannedFlushTime", Long.toString(l, 10));
    }

    private void d()
    {
        if (d < 0L)
        {
            a(SystemClock.uptimeMillis() + a.z() * 1000L);
        }
        b.postAtTime(this, d);
    }

    private void e()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        if (a.z() <= 0L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        l = SystemClock.uptimeMillis() + a.z() * 1000L;
_L1:
        a(l);
        if (b != null)
        {
            b.removeCallbacks(this);
            d();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        l = -1L;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private void f()
    {
        if (b != null)
        {
            b.getLooper().quit();
            b = null;
        }
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        com.b.e.c.a(this);
        c = true;
        if (b != null || a.z() <= 0L || a.y() == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        HandlerThread handlerthread = new HandlerThread("CacheFlusher");
        handlerthread.start();
        b = new Handler(handlerthread.getLooper());
        flag = a.b.a("plannedFlushTime").booleanValue();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        Exception exception;
        try
        {
            d = Long.parseLong(a.b.b("plannedFlushTime"), 10);
        }
        catch (Exception exception1) { }
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (a.z() <= 0L || a.y() == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (b != null || !c) goto _L2; else goto _L1
_L1:
        a(-1L);
        a();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (b == null) goto _L4; else goto _L3
_L3:
        e();
          goto _L4
        Exception exception;
        exception;
        throw exception;
        a(-1L);
        f();
          goto _L4
    }

    public final void c()
    {
        this;
        JVM INSTR monitorenter ;
        com.b.e.c.a(this);
        c = false;
        f();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void run()
    {
        this;
        JVM INSTR monitorenter ;
        com.b.e.c.a(this);
        a.A();
        a(-1L);
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
