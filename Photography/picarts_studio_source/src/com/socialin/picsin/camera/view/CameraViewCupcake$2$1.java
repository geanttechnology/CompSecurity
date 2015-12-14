// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.hardware.Camera;
import android.os.Handler;
import com.socialin.picsin.camera.b;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraFocusRectView, CameraViewCupcake

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        a.a.setVisibility(8);
        a.a.e = false;
        if (a.a.f)
        {
            a.a.a();
            a.a.f = false;
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/picsin/camera/view/CameraViewCupcake$2

/* anonymous class */
    final class CameraViewCupcake._cls2
        implements android.hardware.Camera.AutoFocusCallback
    {

        final CameraFocusRectView a;
        final b b;
        final CameraViewCupcake c;

        public final void onAutoFocus(boolean flag, Camera camera)
        {
            a.setLineColor(0xff00ff00);
            a.invalidate();
            (new Handler()).postDelayed(new CameraViewCupcake._cls2._cls1(this), 200L);
        }

            
            {
                c = cameraviewcupcake;
                a = camerafocusrectview;
                b = b1;
                super();
            }
    }

}
