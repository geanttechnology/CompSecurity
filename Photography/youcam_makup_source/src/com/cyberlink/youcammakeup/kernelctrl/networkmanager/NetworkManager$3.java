// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ay;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ba;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager:
//            NetworkManager

class a
    implements ba
{

    final NetworkManager a;

    public void a(ay ay1)
    {
        NetworkManager.a(a, ay1);
    }

    public void a(bn bn1)
    {
    }

    public volatile void a(Object obj)
    {
        a((ay)obj);
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

    (NetworkManager networkmanager)
    {
        a = networkmanager;
        super();
    }
}
