// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            ay, av, aw, au

public static final class a
    implements ay
{

    private final aw a;

    public final Object a(Object obj)
    {
        synchronized (a)
        {
            obj = a.a(obj, false);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj;
        JVM INSTR monitorenter ;
        obj1 = ((au) (obj)).a();
        obj;
        JVM INSTR monitorexit ;
        return obj1;
        Exception exception;
        exception;
        throw exception;
        return null;
    }

    public final void a(Object obj, Object obj1)
    {
        synchronized (a)
        {
            obj = a.a(obj, true);
        }
        obj;
        JVM INSTR monitorenter ;
        ((au) (obj)).a(obj1);
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        throw obj1;
    }

    public (aw aw1)
    {
        a = aw1;
    }
}
