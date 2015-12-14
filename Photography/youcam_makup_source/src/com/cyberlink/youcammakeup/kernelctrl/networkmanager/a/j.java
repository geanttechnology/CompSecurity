// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;

import com.cyberlink.youcammakeup.database.more.l.c;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.a:
//            a, i, e

public class j extends a
{

    public j(NetworkManager networkmanager, e e, com.cyberlink.youcammakeup.kernelctrl.networkmanager.j j1)
    {
        super(networkmanager, e, new i(), j1);
    }

    public static void a(c c, File file)
    {
        file = a(((e) (c)), file);
        if (file != null)
        {
            (new i()).a(file, c);
        }
    }
}
