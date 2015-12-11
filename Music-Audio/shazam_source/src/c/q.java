// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;


// Referenced classes of package c:
//            p

final class q
{

    static p a;
    static long b;

    private q()
    {
    }

    static p a()
    {
        c/q;
        JVM INSTR monitorenter ;
        p p1;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        p1 = a;
        a = p1.f;
        p1.f = null;
        b -= 2048L;
        c/q;
        JVM INSTR monitorexit ;
        return p1;
        c/q;
        JVM INSTR monitorexit ;
        return new p();
        Exception exception;
        exception;
        c/q;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(p p1)
    {
        if (p1.f != null || p1.g != null)
        {
            throw new IllegalArgumentException();
        }
        if (p1.d)
        {
            return;
        }
        c/q;
        JVM INSTR monitorenter ;
        if (b + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        c/q;
        JVM INSTR monitorexit ;
        return;
        p1;
        c/q;
        JVM INSTR monitorexit ;
        throw p1;
        b += 2048L;
        p1.f = a;
        p1.c = 0;
        p1.b = 0;
        a = p1;
        c/q;
        JVM INSTR monitorexit ;
    }
}
