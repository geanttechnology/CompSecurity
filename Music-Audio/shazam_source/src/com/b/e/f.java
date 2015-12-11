// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.b.a.b;
import com.b.b.e;
import java.util.HashSet;
import java.util.Timer;

// Referenced classes of package com.b.e:
//            p, t, c, e, 
//            o

public final class f extends BroadcastReceiver
{

    protected boolean a;
    protected boolean b;
    protected long c;
    protected HashSet d;
    private Timer e;
    private final b f;

    public f(b b1)
    {
        e = null;
        a = false;
        b = false;
        c = -1L;
        d = null;
        f = b1;
        d = new HashSet();
    }

    private void a(String s)
    {
        if (p.f(s) && d != null && !d.contains(s))
        {
            f.c.a(3000L);
            d.add(s);
        }
    }

    private void a(boolean flag)
    {
        if (b)
        {
            d();
            if (c < SystemClock.uptimeMillis() || c < 0L || !flag)
            {
                c = SystemClock.uptimeMillis() + 30000L;
            }
            long l = c;
            long l1 = SystemClock.uptimeMillis();
            e = new Timer();
            e.schedule(new t(this), l - l1);
            (new StringBuilder("startFlushCacheTimer(): Flushing in ")).append(c - SystemClock.uptimeMillis());
            com.b.e.c.a(this);
        } else
        if (c < 0L)
        {
            c = SystemClock.uptimeMillis() + 30000L;
            return;
        }
    }

    private void d()
    {
        if (e != null)
        {
            com.b.e.c.a(this);
            e.cancel();
            e = null;
        }
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        b = true;
        if (a && c > 0L)
        {
            a(true);
        }
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
        b = false;
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void c()
    {
        this;
        JVM INSTR monitorenter ;
        com.b.e.c.a(this);
        f.A();
        c = -1L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (intent.getExtras() == null) goto _L2; else goto _L1
_L1:
        if (!com.b.e.e.b(context)) goto _L4; else goto _L3
_L3:
        com.b.e.c.a(this);
        a(com.b.e.e.a(f.ab));
        if (f.ak != com.b.e.o.b && f.ak != com.b.e.o.e && !a)
        {
            a = true;
            a(false);
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!com.b.e.e.c(context))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        com.b.e.c.a(this);
        a("|||cs_3g|||");
        if ((f.ak == o.a || f.ak == o.d && com.b.e.e.f(context)) && !a)
        {
            a = true;
            a(false);
        }
          goto _L2
        context;
        throw context;
        com.b.e.c.a(this);
        d();
        a = false;
        c = -1L;
          goto _L2
    }
}
