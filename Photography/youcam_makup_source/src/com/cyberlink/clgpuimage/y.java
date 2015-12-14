// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            ad

public class y extends ad
{

    private int a;
    private float b;

    public void a()
    {
        super.a();
        a = GLES20.glGetUniformLocation(l(), "mixturePercent");
    }

    public void a(float f)
    {
        b = f;
        a(a, b);
    }

    public void b()
    {
        super.b();
        a(b);
    }
}
