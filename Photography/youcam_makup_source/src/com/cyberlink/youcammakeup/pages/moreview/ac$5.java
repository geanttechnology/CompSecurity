// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            ac

class b
    implements Runnable
{

    final Activity a;
    final bn b;
    final ac c;

    public void run()
    {
        Globals.d().i().h(ac.c(c));
        ac.a(c, a, NetworkManager.a(b.a()));
    }

    nager.task.bn(ac ac1, Activity activity, bn bn1)
    {
        c = ac1;
        a = activity;
        b = bn1;
        super();
    }
}
