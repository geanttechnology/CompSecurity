// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public static final class lang.Object
{

    private eq a;

    public final void a()
    {
        if (eq.e().c())
        {
            eq.e().c("BluetoothHeadsetOEM reflected onServiceConnected()");
        }
        Object obj = eq.a(a);
        obj;
        JVM INSTR monitorenter ;
        if (eq.b(a))
        {
            break MISSING_BLOCK_LABEL_58;
        }
        eq.c(a);
        eq.a(a).notify();
_L2:
        return;
        eq.d(a);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        if (eq.e().c())
        {
            eq.e().c("BluetoothHeadsetOEM reflected onServiceDisconnected()");
        }
        synchronized (eq.a(a))
        {
            eq.d(a);
            if (!eq.b(a))
            {
                eq.c(a);
                eq.a(a).notify();
            }
        }
    }

    >(eq eq1)
    {
        a = eq1;
        super();
    }
}
