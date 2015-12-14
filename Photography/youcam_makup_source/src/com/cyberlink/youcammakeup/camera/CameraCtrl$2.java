// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.istener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        long l = System.currentTimeMillis();
        b.a(new YMKLiveCamEvent(true, CameraCtrl.m(a), l, com.cyberlink.youcammakeup.clflurry.nt.Operation.g, false, false));
        if (CameraCtrl.a(false, true))
        {
            CameraCtrl.o(a);
        }
    }

    vent.Operation(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
