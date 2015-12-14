// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.g;
import com.cyberlink.youcammakeup.utility.f;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements g
{

    final LauncherActivity a;

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public void a(e e1)
    {
        f.a("GetADUnitContentTask", e1.b());
        LauncherActivity.a(a, LauncherActivity.d(a), 0);
    }

    public volatile void a(Object obj)
    {
        a((e)obj);
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    k.e(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
