// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements w
{

    final CameraCtrl a;

    public void a(boolean flag)
    {
        if (flag)
        {
            z.a("HAS_SHOWN_LIVE_MAKEUP_PERFORMANCE_HINT", Boolean.valueOf(true), Globals.d());
        }
        Globals.d().i().i(CameraCtrl.u(a));
    }

    public void b(boolean flag)
    {
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
