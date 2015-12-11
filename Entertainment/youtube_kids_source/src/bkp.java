// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class bkp extends mh
{

    final bjp d;
    volatile boolean e;
    boolean f;
    private final List g = new ArrayList();
    private lr h;

    public bkp(bml bml1, Executor executor, bjp bjp1)
    {
        super(null, null);
        d = (bjp)b.a(bjp1);
        bml1.a(new bkq(this, executor));
    }

    public final me a(me me1)
    {
        if (e)
        {
            return ((mh)d.b_()).a(me1);
        }
        this;
        JVM INSTR monitorenter ;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        me1 = ((mh)d.b_()).a(me1);
        this;
        JVM INSTR monitorexit ;
        return me1;
        me1;
        this;
        JVM INSTR monitorexit ;
        throw me1;
        g.add(me1);
        this;
        JVM INSTR monitorexit ;
        return me1;
    }

    public final void a()
    {
        if (e)
        {
            ((mh)d.b_()).a();
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        ((mh)d.b_()).a();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        f = true;
          goto _L1
    }

    public final void b()
    {
        if (e)
        {
            ((mh)d.b_()).b();
            return;
        }
        this;
        JVM INSTR monitorenter ;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        ((mh)d.b_()).b();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        f = false;
          goto _L1
    }

    public final int c()
    {
        if (e)
        {
            return ((mh)d.b_()).c();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final lr d()
    {
        if (e)
        {
            return ((mh)d.b_()).d();
        }
        if (h == null)
        {
            h = new mz();
        }
        return h;
    }

    void e()
    {
        this;
        JVM INSTR monitorenter ;
        me me1;
        for (Iterator iterator = g.iterator(); iterator.hasNext(); ((mh)d.b_()).a(me1))
        {
            me1 = (me)iterator.next();
        }

        break MISSING_BLOCK_LABEL_56;
        Exception exception;
        exception;
        throw exception;
        g.clear();
        this;
        JVM INSTR monitorexit ;
    }
}
