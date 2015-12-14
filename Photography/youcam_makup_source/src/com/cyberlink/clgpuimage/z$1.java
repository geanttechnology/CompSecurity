// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            z, q

class a
    implements Runnable
{

    final z a;

    public void run()
    {
        if (z.i(a) != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                z.i(a)
            }, 0);
            z.c(a, -1);
        }
        if (z.j(a) != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                z.j(a)
            }, 0);
            z.d(a, -1);
        }
        z.k(a).b(z.f(a), z.e(a));
        z.a(a);
    }

    (z z1)
    {
        a = z1;
        super();
    }
}
