// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.ai;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            r

class a
    implements Runnable
{

    final r a;

    public void run()
    {
        r.c(a, false);
        r.b(a, true);
        VenusHelper.a().j();
        int i = MotionControlHelper.e().T().b() + 1;
        boolean flag;
        if (i >= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        MotionControlHelper.e().a(flag, i);
        StatusManager.j().a(null, Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(flag), null);
        a.k.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.eLoader.BufferName.c);
    }

    BufferName(r r1)
    {
        a = r1;
        super();
    }
}
