// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public final class egg
    implements egf, Serializable
{

    private static final long serialVersionUID = 0L;
    private egf a;
    private volatile transient boolean b;
    private transient Object c;

    public egg(egf egf1)
    {
        a = egf1;
    }

    public final Object get()
    {
        if (b) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (b)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = a.get();
        c = obj;
        b = true;
        this;
        JVM INSTR monitorexit ;
        return obj;
        this;
        JVM INSTR monitorexit ;
_L2:
        return c;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String toString()
    {
        return (new StringBuilder("Suppliers.memoize(")).append(a).append(")").toString();
    }
}
