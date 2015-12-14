// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.f;
import com.inmobi.commons.core.utilities.uid.d;

// Referenced classes of package com.inmobi.signals:
//            p, LocationInfo, n, i, 
//            g

public class o
    implements com.inmobi.commons.core.configs.b.b
{

    private static final String a = com/inmobi/signals/o.getSimpleName();
    private static final Object b = new Object();
    private static volatile o c;
    private i d;
    private g e;
    private p f;
    private boolean g;

    private o()
    {
        g = false;
        f = new p();
        com.inmobi.commons.core.configs.b.a().a(f, this);
        com.inmobi.commons.core.utilities.info.f.a().a(e().i());
        com.inmobi.signals.LocationInfo.a().a(e().h());
        com.inmobi.commons.core.c.a.a().a(f.a(), f.e());
    }

    public static o a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        o o1 = c;
        obj = o1;
        if (o1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new o();
        c = ((o) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((o) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((o) (obj));
    }

    public void a(com.inmobi.commons.core.configs.a a1)
    {
        f = (p)a1;
        com.inmobi.signals.LocationInfo.a().a(e().h());
        com.inmobi.commons.core.utilities.info.f.a().a(e().i());
        com.inmobi.commons.core.c.a.a().a(f.a(), f.e());
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Starting signals component.");
            g = true;
            g();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (g)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Stopping signals component.");
            g = false;
            i();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    d d()
    {
        return new d(f.o().a());
    }

    public p.b e()
    {
        return f.f();
    }

    public p.a f()
    {
        return f.g();
    }

    void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (g) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Ice can not be started as Signals component has not been started.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!e().a())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        com.inmobi.signals.n.a().b();
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        d = new i();
        d.a();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        d.a();
          goto _L3
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "User data collection is disabled.");
          goto _L3
    }

    public boolean h()
    {
        return e().h() || e().o() || e().p() || e().k();
    }

    void i()
    {
        com.inmobi.signals.n.a().c();
        if (d != null)
        {
            d.c();
        }
    }

    public void j()
    {
        if (!g)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Carb can not be started as Signals component has not been started.");
            return;
        }
        if (f().a())
        {
            if (e == null)
            {
                e = new g();
                e.a(f());
                return;
            } else
            {
                e.a(f());
                return;
            }
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Carb is disabled.");
            return;
        }
    }

}
