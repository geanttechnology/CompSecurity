// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import java.util.ArrayList;

// Referenced classes of package com.picsart.upload:
//            a

final class d
{

    private static d a;
    private a b;
    private ArrayList c;

    private d()
    {
        b = null;
        c = new ArrayList();
    }

    public static d a()
    {
        if (a == null)
        {
            a = new d();
        }
        return a;
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            b.b();
        }
        b = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final a a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = (a)c.get(i);
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        d();
        b = a1;
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public final a b()
    {
        this;
        JVM INSTR monitorenter ;
        a a1 = b;
        this;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        c.remove(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i = c.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }
}
