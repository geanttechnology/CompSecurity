// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u

class b
    implements Runnable
{

    final int a;
    final int b;
    final u c;

    public void run()
    {
        GLES20.glUniform1i(a, b);
    }

    (u u1, int i, int j)
    {
        c = u1;
        a = i;
        b = j;
        super();
    }
}
