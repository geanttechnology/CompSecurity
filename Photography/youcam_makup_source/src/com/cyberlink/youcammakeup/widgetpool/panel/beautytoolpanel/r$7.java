// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            r

class a
    implements Runnable
{

    final r a;

    public void run()
    {
        r.c(a, false);
        r.b(a, false);
        VenusHelper.a().k();
        MotionControlHelper.e().a(false, 0);
        StatusManager.j().a(null, Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), null);
        a.k.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.eLoader.BufferName.c);
    }

    BufferName(r r1)
    {
        a = r1;
        super();
    }
}
