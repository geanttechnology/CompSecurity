// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.hardware.Camera;

// Referenced classes of package com.socialin.picsin.camera.view:
//            CameraViewCupcake

final class b
    implements android.hardware.back
{

    private android.hardware.ck a;
    private android.hardware.ck b;
    private CameraViewCupcake c;

    public final void onAutoFocus(boolean flag, Camera camera)
    {
        c.a(a, b);
    }

    _cls9(CameraViewCupcake cameraviewcupcake, android.hardware.ck ck, android.hardware.ck ck1, android.hardware.ck ck2)
    {
        c = cameraviewcupcake;
        a = null;
        b = ck2;
        super();
    }
}
