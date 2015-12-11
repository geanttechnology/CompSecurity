// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cis
{

    public final cit a = new cit(this);
    public final cit b = new cit(this);
    private boolean c;

    public cis()
    {
        c = false;
    }

    public final void a(long l, long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
    }

    final void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        c = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean a()
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
}
