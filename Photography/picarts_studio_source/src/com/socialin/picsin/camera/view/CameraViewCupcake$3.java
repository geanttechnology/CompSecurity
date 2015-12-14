// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import com.socialin.picsin.camera.b;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake, CameraFocusRectView

final class b
    implements Runnable
{

    private CameraFocusRectView a;
    private b b;
    private CameraViewCupcake c;

    public final void run()
    {
        a.setVisibility(8);
        c.e = false;
        if (c.f)
        {
            b.a();
            c.f = false;
        }
    }

    _cls9(CameraViewCupcake cameraviewcupcake, CameraFocusRectView camerafocusrectview, b b1)
    {
        c = cameraviewcupcake;
        a = camerafocusrectview;
        b = b1;
        super();
    }
}
