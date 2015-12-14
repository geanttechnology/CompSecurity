// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.database.a.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.j;
import com.cyberlink.youcammakeup.utility.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements j
{

    final NetworkManager a;
    final LauncherActivity b;

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public void a(h h1)
    {
        f.a("GetADUnitListTask");
        f.a("GetADUnitListTask", h1.b());
        Object obj = h1.a();
        h1 = new LinkedList();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); h1.add(((e)((Iterator) (obj)).next()).a())) { }
        if (h1.size() != 0)
        {
            a.a(new com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.f(a, LauncherActivity.c(b), h1));
        }
    }

    public volatile void a(Object obj)
    {
        a((h)obj);
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

    workManager(LauncherActivity launcheractivity, NetworkManager networkmanager)
    {
        b = launcheractivity;
        a = networkmanager;
        super();
    }
}
