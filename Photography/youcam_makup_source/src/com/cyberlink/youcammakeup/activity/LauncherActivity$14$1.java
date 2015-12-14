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
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements e
{

    final bn a;

    public void a(bn bn1)
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
            void1.add(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.mType.c);
            Globals.d().w().K().a(void1);
            z.a("HAS_SET_SEEN", Boolean.valueOf(true), Globals.d());
        }
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
    }

    rkManager(rkManager rkmanager)
    {
        a = rkmanager;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$14

/* anonymous class */
    class LauncherActivity._cls14
        implements ao
    {

        final NetworkManager a;
        final LauncherActivity b;

        public void a(ap ap1)
        {
            a.K().a(ap1);
            LauncherActivity.a(b, ap1);
            com.cyberlink.youcammakeup.utility.bn.a(ap1.i(), -1L, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a, new LauncherActivity._cls14._cls1(this));
        }

        public void a(bn bn1)
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
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

            
            {
                b = launcheractivity;
                a = networkmanager;
                super();
            }
    }

}
