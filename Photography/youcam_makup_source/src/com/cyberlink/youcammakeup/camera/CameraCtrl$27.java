// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl, CameraZoomView, d

class a
    implements Runnable
{

    final CameraCtrl a;

    public void run()
    {
        CameraCtrl.A(a);
        CameraCtrl.B(a);
        CameraCtrl.C(a).setCamera(CameraCtrl.q(a));
        if (LiveDemoConfigHelper.h().d())
        {
            CameraCtrl.C(a).setZoomLevel(LiveDemoConfigHelper.h().q());
        }
        CameraCtrl.e(a, true);
        CameraCtrl.a(a, true);
        if (!CameraCtrl.p(a))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        CameraCtrl.w(a).setVisibility(0);
_L1:
        CameraCtrl.d(a).a();
        return;
        try
        {
            CameraCtrl.w(a).setVisibility(4);
        }
        catch (Exception exception)
        {
            m.b("CameraCtrl", "setupCameraParameters", exception);
            return;
        }
          goto _L1
    }

    nfigHelper(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
