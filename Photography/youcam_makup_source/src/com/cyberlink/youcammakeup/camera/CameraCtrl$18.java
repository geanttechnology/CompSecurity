// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;


// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl, d

class a
    implements Runnable
{

    final CameraCtrl a;

    public void run()
    {
        CameraCtrl cameractrl = a;
        boolean flag;
        if (!CameraCtrl.e(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CameraCtrl.f(cameractrl, flag);
        CameraCtrl.d(a).b();
        CameraCtrl.a(false);
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
