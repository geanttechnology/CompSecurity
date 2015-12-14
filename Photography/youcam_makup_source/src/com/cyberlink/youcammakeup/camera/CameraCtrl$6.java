// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            f, CameraCtrl, o

class a
    implements f
{

    final CameraCtrl a;

    public void a(deDialog.FlashMode flashmode)
    {
        if (CameraCtrl.q(a) != null)
        {
            android.hardware.ters ters = CameraCtrl.q(a).getParameters();
            CameraCtrl.a(a, ters, flashmode);
            o.a(CameraCtrl.q(a), ters);
        }
    }

    deDialog.FlashMode(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
