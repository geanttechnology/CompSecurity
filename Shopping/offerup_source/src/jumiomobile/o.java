// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.hardware.Camera;

// Referenced classes of package jumiomobile:
//            g

public class o
    implements Runnable
{

    final g a;

    public o(g g1)
    {
        a = g1;
        super();
    }

    public void run()
    {
        a.c(false);
        synchronized (g.a(a))
        {
            if (g.f(a) && g.d(a) != null)
            {
                g.d(a).stopPreview();
            }
        }
        g.a(a, false);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
