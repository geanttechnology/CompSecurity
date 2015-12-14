// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.hardware.Camera;
import android.os.Handler;
import com.socialin.picsin.camera.b;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake, CameraFocusRectView

final class b
    implements android.hardware.back
{

    final CameraFocusRectView a;
    final b b;
    final CameraViewCupcake c;

    public final void onAutoFocus(boolean flag, Camera camera)
    {
        a.setLineColor(0xff00ff00);
        a.invalidate();
        (new Handler()).postDelayed(new Runnable() {

            private CameraViewCupcake._cls2 a;

            public final void run()
            {
                a.a.setVisibility(8);
                a.c.e = false;
                if (a.c.f)
                {
                    a.b.a();
                    a.c.f = false;
                }
            }

            
            {
                a = CameraViewCupcake._cls2.this;
                super();
            }
        }, 200L);
    }

    _cls1.a(CameraViewCupcake cameraviewcupcake, CameraFocusRectView camerafocusrectview, b b1)
    {
        c = cameraviewcupcake;
        a = camerafocusrectview;
        b = b1;
        super();
    }
}
