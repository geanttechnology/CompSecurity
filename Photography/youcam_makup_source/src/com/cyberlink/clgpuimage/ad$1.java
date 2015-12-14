// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            ad, af

class a
    implements Runnable
{

    final Bitmap a;
    final ad b;

    public void run()
    {
        if (b.l != -1 || a == null || a.isRecycled())
        {
            return;
        } else
        {
            GLES20.glActiveTexture(33987);
            b.l = af.a(a, -1, false);
            return;
        }
    }

    (ad ad1, Bitmap bitmap)
    {
        b = ad1;
        a = bitmap;
        super();
    }
}
