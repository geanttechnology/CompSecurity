// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import com.socialin.camera.opengl.a;
import com.socialin.picsin.camera.view.CameraViewCupcake;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity

final class c
    implements Runnable
{

    private int a;
    private boolean b;
    private boolean c;
    private CameraMainActivity d;

    public final void run()
    {
        CameraMainActivity.F(d);
        ((CameraViewCupcake)CameraMainActivity.c(d)).k = true;
        android.widget.arams arams = new android.widget.arams(1, 1);
        ((CameraViewCupcake)CameraMainActivity.c(d)).setLayoutParams(arams);
        CameraMainActivity.o(d).a(a, true, true, b, c);
    }

    (CameraMainActivity cameramainactivity, int i, boolean flag, boolean flag1)
    {
        d = cameramainactivity;
        a = i;
        b = flag;
        c = flag1;
        super();
    }
}
