// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.applovin.impl.sdk:
//            ay

class br
{

    private final int a;
    private final Queue b = new LinkedList();
    private final Object c = new Object();

    br(int i)
    {
        if (i > 10)
        {
            i = 10;
        }
        a = i;
    }

    int a()
    {
        int i;
        synchronized (c)
        {
            i = b.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(ay ay1)
    {
        synchronized (c)
        {
            if (!c())
            {
                b.offer(ay1);
            }
        }
        return;
        ay1;
        obj;
        JVM INSTR monitorexit ;
        throw ay1;
    }

    int b()
    {
        return a;
    }

    boolean c()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (a() >= a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean d()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (a() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ay e()
    {
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (d())
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj = (ay)b.poll();
_L2:
        return ((ay) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
