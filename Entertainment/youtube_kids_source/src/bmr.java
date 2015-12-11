// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

public abstract class bmr
    implements bjp
{

    private volatile Object a;
    private volatile boolean b;

    public bmr()
    {
        b = false;
    }

    public bmr(Executor executor)
    {
        b = false;
        executor.execute(new bms(this));
    }

    public abstract Object a();

    void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!b)
        {
            a = a();
            b = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final Object b_()
    {
        if (!b)
        {
            b();
        }
        return a;
    }
}
