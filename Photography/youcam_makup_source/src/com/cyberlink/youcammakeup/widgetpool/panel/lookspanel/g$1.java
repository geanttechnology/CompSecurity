// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            g

class a
    implements Runnable
{

    final g a;

    public void run()
    {
        StatusManager.j().x();
    }

    (g g1)
    {
        a = g1;
        super();
    }
}
