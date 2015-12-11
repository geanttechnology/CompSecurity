// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;

// Referenced classes of package jumiomobile:
//            g, s

public class p
    implements Runnable
{

    SurfaceTexture a;
    int b;
    int c;
    boolean d;
    int e;
    final g f;

    public p(g g1, SurfaceTexture surfacetexture, int i, int j, boolean flag, int k)
    {
        f = g1;
        super();
        a = surfacetexture;
        b = i;
        c = j;
        d = flag;
        e = k;
    }

    public void run()
    {
        synchronized (g.a(f))
        {
            if (g.d(f) != null)
            {
                if (g.e(f) != null)
                {
                    g.e(f).a();
                }
                g.d(f).stopPreview();
                g.a(f, a, b, c, d, e);
                if (!g.c(f))
                {
                    f.k();
                }
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
