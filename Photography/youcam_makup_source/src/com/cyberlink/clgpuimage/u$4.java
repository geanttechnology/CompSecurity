// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.PointF;
import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u

class b
    implements Runnable
{

    final PointF a;
    final int b;
    final u c;

    public void run()
    {
        float f = a.x;
        float f1 = a.y;
        GLES20.glUniform2fv(b, 1, new float[] {
            f, f1
        }, 0);
    }

    (u u1, PointF pointf, int i)
    {
        c = u1;
        a = pointf;
        b = i;
        super();
    }
}
