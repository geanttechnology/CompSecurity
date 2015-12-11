// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package jumiomobile:
//            am

public abstract class an
{

    private final Object a = new Object();
    private HashMap b;
    private boolean c;

    public an()
    {
        c = false;
    }

    public am a(Context context, String s)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        s = (am)b.get(s);
        if (s.a() || context == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        s.a(context);
        obj;
        JVM INSTR monitorexit ;
        return s;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (c)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        c = true;
        synchronized (a)
        {
            if (b != null)
            {
                b.clear();
            }
            b = new HashMap();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context)
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = b.values().iterator(); iterator.hasNext(); ((am)iterator.next()).a(context)) { }
        break MISSING_BLOCK_LABEL_59;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        obj;
        JVM INSTR monitorexit ;
_L2:
    }

    public void a(String s, am am1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!c)
        {
            a();
        }
        synchronized (a)
        {
            b.put(s, am1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public boolean b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = c;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        synchronized (a)
        {
            c = false;
            if (b != null)
            {
                b.clear();
                a();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
