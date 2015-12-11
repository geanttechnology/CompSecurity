// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;

// Referenced classes of package android.support.v7:
//            cr

public class cq
    implements Closeable
{

    private final Object a;
    private cr b;
    private Runnable c;
    private boolean d;

    public void close()
    {
label0:
        {
            synchronized (a)
            {
                if (!d)
                {
                    break label0;
                }
            }
            return;
        }
        d = true;
        b.a(this);
        b = null;
        c = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
