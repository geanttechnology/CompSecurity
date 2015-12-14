// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            z, u, Rotation

class a
    implements Runnable
{

    final u a;
    final z b;

    public void run()
    {
        u u1 = z.b(b);
        z.a(b, a);
        if (u1 != null)
        {
            u1.h();
        }
        z.b(b).g();
        z.b(b).a(z.c(b));
        GLES20.glUseProgram(z.b(b).l());
        if (z.c(b) == mage.ScaleType.c || z.c(b) == mage.ScaleType.e)
        {
            if (z.d(b) == Rotation.d || z.d(b) == Rotation.b)
            {
                z.b(b).a(z.e(b), z.f(b));
                return;
            } else
            {
                z.b(b).a(z.f(b), z.e(b));
                return;
            }
        }
        if (z.c(b) == mage.ScaleType.d)
        {
            int i = Math.min(z.f(b), z.e(b));
            z.b(b).a(i, i);
            return;
        } else
        {
            z.b(b).a(z.g(b), z.h(b));
            z.b(b).c(z.l(b), z.m(b));
            return;
        }
    }

    tion(z z1, u u1)
    {
        b = z1;
        a = u1;
        super();
    }
}
