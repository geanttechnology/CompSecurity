// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.SurfaceTexture;

// Referenced classes of package netswipe:
//            c

public class g
    implements Runnable
{

    SurfaceTexture a;
    int b;
    int c;
    final c d;

    public g(c c1, SurfaceTexture surfacetexture, int i, int j)
    {
        d = c1;
        super();
        a = surfacetexture;
        b = i;
        c = j;
    }

    public void run()
    {
        netswipe.c.a(d);
        netswipe.c.a(d, a, b, c);
        if (!netswipe.c.b(d))
        {
            d.h();
        }
    }
}
