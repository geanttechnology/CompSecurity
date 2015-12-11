// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.a.a.a.b:
//            d, a

final class g
    implements d
{

    private final DataOutputStream a;

    g(OutputStream outputstream)
    {
        a = new DataOutputStream(outputstream);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final void a(boolean flag, int i)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(boolean flag, int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
    }

    public final void a(boolean flag, int i, byte abyte0[], int j)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        a.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(int i, a a1)
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("TODO");
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final void close()
    {
        a.close();
    }
}
