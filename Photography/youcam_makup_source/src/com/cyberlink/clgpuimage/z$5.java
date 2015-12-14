// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            z, Rotation, u

class a
    implements Runnable
{

    final z a;

    public void run()
    {
        if (z.c(a) != mage.ScaleType.c && z.c(a) != mage.ScaleType.e) goto _L2; else goto _L1
_L1:
        if (z.d(a) != Rotation.d && z.d(a) != Rotation.b) goto _L4; else goto _L3
_L3:
        if (z.b(a) != null)
        {
            z.b(a).a(z.e(a), z.f(a));
        }
_L5:
        z.o(a);
        return;
_L4:
        if (z.b(a) != null)
        {
            z.b(a).a(z.f(a), z.e(a));
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (z.c(a) == mage.ScaleType.d)
        {
            int i = Math.min(z.f(a), z.e(a));
            if (z.b(a) != null)
            {
                z.b(a).a(i, i);
            }
            z.o(a);
            return;
        }
        if (z.b(a) != null)
        {
            z.b(a).a(z.g(a), z.h(a));
            z.b(a).c(z.l(a), z.m(a));
        }
        GLES20.glViewport(0, 0, z.g(a), z.h(a));
        return;
    }

    tion(z z1)
    {
        a = z1;
        super();
    }
}
