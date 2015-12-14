// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.hardware.Camera;
import com.socialin.picsin.camera.view.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, d

final class a
    implements Runnable
{

    private CameraMainActivity a;

    public final void run()
    {
        if (a.d != null && com.socialin.picsin.camera.CameraMainActivity.c(a) != null && com.socialin.picsin.camera.CameraMainActivity.c(a).c() != null && com.socialin.picsin.camera.CameraMainActivity.c(a).c().getParameters() != null)
        {
            android.hardware.ctivity ctivity = com.socialin.picsin.camera.CameraMainActivity.c(a).c().getParameters().PictureSize();
            if (ctivity != null)
            {
                myobfuscated.cv.c.a(a, a.d.d, ctivity.d, ctivity.d, "camera", "share_to_pa");
                CameraMainActivity.l(a);
            }
        }
    }

    (CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }
}
