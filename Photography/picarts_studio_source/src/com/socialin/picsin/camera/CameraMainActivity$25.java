// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.graphics.Bitmap;
import com.socialin.camera.opengl.CameraOpenGlSurfaceView;
import com.socialin.camera.opengl.h;
import com.socialin.picsin.camera.view.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, d

public final class b
    implements Runnable
{

    private Bitmap a;
    private int b;
    private CameraMainActivity c;

    public final void run()
    {
        CameraMainActivity.q(c);
        c.d = new d(c, a, b, com.socialin.picsin.camera.CameraMainActivity.c(c).z());
        c.d.start();
        if (CameraMainActivity.p(c) != null)
        {
            CameraMainActivity.p(c).g = false;
        }
        if (CameraMainActivity.t(c) != null)
        {
            CameraMainActivity.t(c).setVisibility(8);
        }
    }

    public w(CameraMainActivity cameramainactivity, Bitmap bitmap, int i)
    {
        c = cameramainactivity;
        a = bitmap;
        b = i;
        super();
    }
}
