// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;


// Referenced classes of package d:
//            y

final class z
{

    private static y a;
    private static long b;

    private z()
    {
    }

    static y a()
    {
        d/z;
        JVM INSTR monitorenter ;
        y y1;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        y1 = a;
        a = y1.f;
        y1.f = null;
        b -= 2048L;
        d/z;
        JVM INSTR monitorexit ;
        return y1;
        d/z;
        JVM INSTR monitorexit ;
        return new y();
        Exception exception;
        exception;
        d/z;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(y y1)
    {
        if (y1.f != null || y1.g != null)
        {
            throw new IllegalArgumentException();
        }
        if (y1.d)
        {
            return;
        }
        d/z;
        JVM INSTR monitorenter ;
        if (b + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        d/z;
        JVM INSTR monitorexit ;
        return;
        y1;
        d/z;
        JVM INSTR monitorexit ;
        throw y1;
        b += 2048L;
        y1.f = a;
        y1.c = 0;
        y1.b = 0;
        a = y1;
        d/z;
        JVM INSTR monitorexit ;
    }
}
