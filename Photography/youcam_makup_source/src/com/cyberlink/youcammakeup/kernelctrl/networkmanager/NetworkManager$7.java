// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.baidupush.b;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager

class a
    implements b
{

    final NetworkManager a;

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        m.b("NetworkManager", "mBaiduRegisterTask::complete");
    }

    public volatile void b(Object obj)
    {
        b((Void)obj);
    }

    public void b(Void void1)
    {
        m.b("NetworkManager", "mBaiduRegisterTask::error");
    }

    public volatile void c(Object obj)
    {
        c((Void)obj);
    }

    public void c(Void void1)
    {
        m.b("NetworkManager", "mBaiduRegisterTask::cancel");
    }

    (NetworkManager networkmanager)
    {
        a = networkmanager;
        super();
    }
}
