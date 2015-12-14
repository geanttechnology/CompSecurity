// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            b, a, TopToolBar

class a
    implements b
{

    final a a;

    public void a()
    {
    }

    public void b()
    {
        StatusManager.j().a(MakeupMode.g);
        a.e().a(Boolean.valueOf(false));
    }

    oolBar(a a1)
    {
        a = a1;
        super();
    }
}
