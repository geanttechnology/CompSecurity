// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import com.socialin.camera.opengl.CameraOpenGlSurfaceView;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

public final class a
    implements Runnable
{

    private android.widget.ams a;
    private CameraMainActivity b;

    public final void run()
    {
        if (!b.isFinishing() && CameraMainActivity.t(b) != null)
        {
            CameraMainActivity.t(b).setLayoutParams(a);
        }
    }

    public w(CameraMainActivity cameramainactivity, android.widget.ams ams)
    {
        b = cameramainactivity;
        a = ams;
        super();
    }
}
