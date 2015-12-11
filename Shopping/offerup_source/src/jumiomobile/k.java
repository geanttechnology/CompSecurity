// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.SurfaceTexture;

// Referenced classes of package jumiomobile:
//            g

public class k
    implements Runnable
{

    SurfaceTexture a;
    int b;
    int c;
    boolean d;
    int e;
    final g f;

    public k(g g1, SurfaceTexture surfacetexture, int i, int j, boolean flag, int l)
    {
        f = g1;
        super();
        a = surfacetexture;
        b = i;
        c = j;
        d = flag;
        e = l;
    }

    public void run()
    {
        synchronized (g.a(f))
        {
            g.b(f);
            g.a(f, a, b, c, d, e);
            if (!g.c(f))
            {
                f.k();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
