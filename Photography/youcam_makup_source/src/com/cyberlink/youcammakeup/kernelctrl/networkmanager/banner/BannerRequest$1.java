// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.a.a;
import com.cyberlink.youcammakeup.database.a.c;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.g;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.f;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner:
//            BannerRequest, a

final class b
    implements g
{

    final a a;
    final com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a b;

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public void a(e e1)
    {
        f.a("PF_YMK_LAUNCHER_BANNER", e1.b());
        f.a("PF_YMK_LAUNCHER_BANNER");
        if (e1.a().size() > 0 && ((a)e1.a().get(0)).b().size() > 0)
        {
            e1 = (c)((a)e1.a().get(0)).b().get(0);
            if (a == null || ((c)a.b().get(0)).h() != e1.h())
            {
                z.a("BannerRequestWEEK_START_DOWNLOADED", Boolean.valueOf(false), Globals.d().getApplicationContext());
            }
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.BannerRequest.a(e1, b);
        }
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

    Q(a a1, com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.a a2)
    {
        a = a1;
        b = a2;
        super();
    }
}
