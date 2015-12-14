// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.istener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.nt.Operation.h, false, false));
        if (CameraCtrl.a(false, true))
        {
            CameraCtrl.a(a, false);
            CameraCtrl.t(a).setSelected(true);
            o.a(CameraCtrl.u(a), CameraCtrl.v(a), "CameraSettingDialog");
        }
    }

    vent.Operation(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
