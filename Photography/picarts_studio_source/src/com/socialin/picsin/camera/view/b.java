// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.os.Handler;
import android.os.Message;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake

final class b extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    private CameraViewCupcake a;

    private b(CameraViewCupcake cameraviewcupcake)
    {
        a = cameraviewcupcake;
        super();
    }

    b(CameraViewCupcake cameraviewcupcake, byte byte0)
    {
        this(cameraviewcupcake);
    }

    public final boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        int i;
        float f1 = scalegesturedetector.getScaleFactor();
        if (CameraViewCupcake.a(a) <= 0.5F && f1 > 1.0F)
        {
            CameraViewCupcake.a(a, 1.0F);
        }
        float f = f1;
        if (f1 > 1.0F)
        {
            f = f1;
            if (CameraViewCupcake.a(a) <= 7F)
            {
                f = (float)((double)f1 * 1.2D);
            }
        }
        CameraViewCupcake.b(a, f);
        i = a.U();
        if (CameraViewCupcake.a(a) >= 0.0F) goto _L2; else goto _L1
_L1:
        CameraViewCupcake.a(a, 0.0F);
_L4:
        if (a.q != null)
        {
            scalegesturedetector = a.q.obtainMessage(0);
            scalegesturedetector.what = 0;
            a.q.removeMessages(0);
            a.q.sendMessage(scalegesturedetector);
        }
        return true;
_L2:
        if (CameraViewCupcake.a(a) > (float)i)
        {
            CameraViewCupcake.a(a, i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
