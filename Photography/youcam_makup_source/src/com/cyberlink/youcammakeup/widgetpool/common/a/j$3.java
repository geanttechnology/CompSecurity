// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            j

class a
    implements Runnable
{

    final j a;

    public void run()
    {
        a.d.a(PanelDataCenter.a().i(MotionControlHelper.e().M().c()), true);
    }

    y(j j1)
    {
        a = j1;
        super();
    }
}
