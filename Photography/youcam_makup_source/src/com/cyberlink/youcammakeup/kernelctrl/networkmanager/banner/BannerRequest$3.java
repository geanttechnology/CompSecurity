// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner:
//            BannerRequest

final class Q
    implements b
{

    public void a(NetworkManager networkmanager, e e)
    {
    }

    public void a(File file, e e)
    {
    }

    public void b(File file, e e)
    {
        z.a("BannerRequestWEEK_START_DOWNLOADED", Boolean.valueOf(true), Globals.d().getApplicationContext());
    }

    Q()
    {
    }
}
