// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bim
{

    public static int a = 0;
    private static bim b = null;

    public bim()
    {
    }

    public static bim a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        bim;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new bim();
        }
        bim;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        bim;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
