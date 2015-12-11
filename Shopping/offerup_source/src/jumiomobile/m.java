// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.hardware.Camera;

// Referenced classes of package jumiomobile:
//            g

public class m
    implements Runnable
{

    final g a;

    public m(g g1)
    {
        a = g1;
        super();
    }

    public void run()
    {
        synchronized (g.a(a))
        {
            if (g.d(a) != null)
            {
                g.d(a).release();
                g.a(a, null);
            }
            if (g.g(a) != null)
            {
                g.a(a, null);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
