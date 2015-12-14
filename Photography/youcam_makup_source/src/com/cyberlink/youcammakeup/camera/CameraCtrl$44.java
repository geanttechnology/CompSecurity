// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.stener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        long l = System.currentTimeMillis();
        b.a(new YMKLiveCamEvent(true, CameraCtrl.m(a), l, com.cyberlink.youcammakeup.clflurry.t.Operation.f, true, true));
        YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.vent.Source.a.a());
        YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.LookEvent.Source.a.a());
        CameraCtrl.n(a);
    }

    omLookEvent(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
