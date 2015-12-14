// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;

import android.widget.RelativeLayout;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.picsin.camera.view.c;

// Referenced classes of package com.socialin.picsin.camera:
//            CameraMainActivity, CameraShutter, m

public class o
{

    CameraMainActivity a;

    o(CameraMainActivity cameramainactivity)
    {
        a = cameramainactivity;
        super();
    }

    public void a(int i)
    {
        if (i != 0x7f10035c) goto _L2; else goto _L1
_L1:
        a.c.a(CameraShutter.ShutterMode.NORMAL);
        CameraMainActivity.m(a);
        if (com.socialin.picsin.camera.CameraMainActivity.c(a) != null)
        {
            com.socialin.picsin.camera.CameraMainActivity.c(a).a(true);
        }
_L4:
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.CameraActionEvent(CameraMainActivity.n(a), "mode"));
        a.o.a.setVisibility(8);
        return;
_L2:
        if (i == 0x7f10035d)
        {
            a.c.a(CameraShutter.ShutterMode.TIMER);
            a.c.d();
            com.socialin.picsin.camera.CameraMainActivity.c(a).a(true);
        } else
        if (i == 0x7f10035f)
        {
            a.c.a(CameraShutter.ShutterMode.TIME_LAPSE);
            a.c.d();
            com.socialin.picsin.camera.CameraMainActivity.c(a).a(true);
        } else
        if (i == 0x7f100360)
        {
            a.c.a(CameraShutter.ShutterMode.BURST);
            a.c.d();
            com.socialin.picsin.camera.CameraMainActivity.c(a).a(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
