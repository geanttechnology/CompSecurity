// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.graphics.RectF;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraShotAnimationVeiw

class l
{

    final CameraShotAnimationVeiw a;
    private RectF b;
    private RectF c;
    private int d;
    private boolean e;

    public l(CameraShotAnimationVeiw camerashotanimationveiw, int i, int j, float f, int k)
    {
        a = camerashotanimationveiw;
        super();
        e = false;
        b = new RectF();
        b.left = ((float)i - 540F) / 668F;
        b.top = ((float)j - 960F) / 668F;
        b.right = (((float)i + 320F * f) - 540F) / 668F;
        b.bottom = (((float)j + 470F * f) - 960F) / 668F;
        c = new RectF(b);
        d = k;
    }

    static RectF a(l l1)
    {
        return l1.c;
    }

    public int a(int i)
    {
        if (!e && i < d)
        {
            return -1;
        }
        int j = i - d;
        i = j;
        if (j < 0)
        {
            i = (j + 16) - 1;
        }
        return i % CameraShotAnimationVeiw.e(a).length;
    }

    public void a(int i, int j)
    {
        float f;
        if ((float)j / (float)i < 1.0F)
        {
            f = (float)j / 2.0F;
        } else
        {
            f = (float)i / 2.0F;
        }
        c.left = b.left * f;
        c.top = b.top * f;
        c.right = b.right * f;
        c.bottom = f * b.bottom;
    }

    public void a(boolean flag)
    {
        e = flag;
    }
}
