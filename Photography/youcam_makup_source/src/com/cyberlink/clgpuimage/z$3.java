// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            z

class a
    implements Runnable
{

    final z a;

    public void run()
    {
        GLES20.glDeleteTextures(1, new int[] {
            z.n(a)
        }, 0);
        z.e(a, -1);
    }

    (z z1)
    {
        a = z1;
        super();
    }
}
