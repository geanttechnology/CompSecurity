// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.widgetpool.common.am;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            LiveCategoryCtrl, t

class a
    implements am
{

    final LiveCategoryCtrl a;

    public void a(int i, boolean flag)
    {
        veCategory vecategory = com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.b()[i];
        a.a(vecategory);
        YMKLiveCamEvent.c(vecategory.toString());
        if (flag)
        {
            b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.ration.d, true, false));
        } else
        {
            b.a(new YMKLiveCamEvent(true, 0L, 0L, com.cyberlink.youcammakeup.clflurry.ration.e, true, false));
        }
        YMKLiveCamEvent.c("None");
        YMKLiveCamEvent.a(true);
        if (LiveCategoryCtrl.a(a) != null)
        {
            LiveCategoryCtrl.a(a).a(vecategory);
        }
    }

    peration(LiveCategoryCtrl livecategoryctrl)
    {
        a = livecategoryctrl;
        super();
    }
}
