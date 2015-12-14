// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bn;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements ao
{

    final NetworkManager a;
    final LauncherActivity b;

    public void a(ap ap1)
    {
        a.K().a(ap1);
        LauncherActivity.a(b, ap1);
        bn.a(ap1.i(), -1L, com.cyberlink.youcammakeup.kernelctrl.r.DisplayMakeupType.a, new e() {

            final LauncherActivity._cls14 a;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
            {
            }

            public volatile void a(Object obj)
            {
                a((Void)obj);
            }

            public void a(Void void1)
            {
                if (!z.a("HAS_SET_SEEN", Globals.d()))
                {
                    void1 = new ArrayList();
                    void1.add(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeItemType.c);
                    Globals.d().w().K().a(void1);
                    z.a("HAS_SET_SEEN", Boolean.valueOf(true), Globals.d());
                }
            }

            public void b(Object obj)
            {
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
            }

            public void c(Object obj)
            {
            }

            
            {
                a = LauncherActivity._cls14.this;
                super();
            }
        });
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn bn1)
    {
        LauncherActivity.a(b, null);
    }

    public volatile void a(Object obj)
    {
        a((ap)obj);
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn)obj);
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
