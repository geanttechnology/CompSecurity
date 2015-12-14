// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.istener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        boolean flag;
        flag = true;
        b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.nt.Operation.k, false, false));
        if (!CameraCtrl.p(a) || !CameraCtrl.a(false, true)) goto _L2; else goto _L1
_L1:
        view = CameraCtrl.q(a).getParameters();
        if (!CameraCtrl.r(a))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        view.setFlashMode("off");
_L3:
        CameraCtrl.q(a).setParameters(view);
        if (CameraCtrl.r(a))
        {
            CameraCtrl.s(a).setSelected(false);
        } else
        {
            CameraCtrl.s(a).setSelected(true);
        }
        view = a;
        if (CameraCtrl.r(a))
        {
            flag = false;
        }
        CameraCtrl.d(view, flag);
        CameraCtrl.a(false);
_L2:
        return;
        try
        {
            view.setFlashMode("torch");
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            m.b("CameraCtrl", "flashModeContainer::Onclick", view);
            return;
        }
          goto _L3
    }

    vent.Operation(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
