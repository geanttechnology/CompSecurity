// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.cyberlink.clgpuimage.af;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.gpuimage:
//            a, b

class b
    implements Runnable
{

    final Bitmap a;
    final boolean b;
    final a c;

    public void run()
    {
        if (com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c).a != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c).a
            }, 0);
        }
        com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c).a = af.a(a, -1, b);
        com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c).b = a.getWidth();
        com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c).c = a.getHeight();
        com.cyberlink.youcammakeup.kernelctrl.gpuimage.a.a(c, true);
    }

    (a a1, Bitmap bitmap, boolean flag)
    {
        c = a1;
        a = bitmap;
        b = flag;
        super();
    }
}
