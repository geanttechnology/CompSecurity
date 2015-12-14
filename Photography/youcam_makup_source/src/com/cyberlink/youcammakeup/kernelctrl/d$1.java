// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.aa;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            d

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        o.a(Globals.d().a(com.cyberlink.youcammakeup.als.ActivityType.o));
        (new aa(Globals.d().a(com.cyberlink.youcammakeup.als.ActivityType.o))).show();
    }

    ogs.aa(d d1)
    {
        a = d1;
        super();
    }
}
