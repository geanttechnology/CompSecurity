// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class pn
{

    private static pk a;
    private static volatile boolean b = false;
    private static pl c;

    private pn()
    {
    }

    static pl a()
    {
        pn;
        JVM INSTR monitorenter ;
        pl pl1;
        if (!b)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (c == null)
        {
            c = new po();
        }
        pl1 = c;
        pn;
        JVM INSTR monitorexit ;
        return pl1;
        if (a == null)
        {
            a = pk.a();
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        pl1 = a.b();
        pn;
        JVM INSTR monitorexit ;
        return pl1;
        Exception exception;
        exception;
        pn;
        JVM INSTR monitorexit ;
        throw exception;
        pn;
        JVM INSTR monitorexit ;
        return null;
    }

    public static void a(String s)
    {
        pl pl1 = a();
        if (pl1 != null)
        {
            pl1.b(s);
        }
    }

    public static void b(String s)
    {
        pl pl1 = a();
        if (pl1 != null)
        {
            pl1.a(s);
        }
    }

}
