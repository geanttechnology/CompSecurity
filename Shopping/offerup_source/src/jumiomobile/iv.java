// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Arrays;

// Referenced classes of package jumiomobile:
//            iu, ao, l, n

class iv extends Thread
{

    final iu a;
    private byte b[];

    public iv(iu iu1, byte abyte0[])
    {
        a = iu1;
        super();
        b = Arrays.copyOf(abyte0, abyte0.length);
    }

    public void run()
    {
        int i;
        int j;
        if (a.c.f())
        {
            j = a.b.c.b;
            i = a.b.c.a;
        } else
        {
            j = a.b.c.a;
            i = a.b.c.b;
        }
        a.b(b, j, i, false);
        b = null;
        System.gc();
        synchronized (a)
        {
            iu.a(a, false);
        }
        return;
        exception;
        iu1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
