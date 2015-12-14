// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.b;
import java.io.File;
import java.io.IOException;
import java.net.URI;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            e, h, SkuInfo, d, 
//            g, b

class f
{

    final SkuInfo a;
    private com.cyberlink.youcammakeup.kernelctrl.sku.d b;
    private e c;
    private b d;
    private SkuInfo.DownloadType e;

    public f(SkuInfo skuinfo, SkuInfo.DownloadType downloadtype, com.cyberlink.youcammakeup.kernelctrl.sku.d d1, b b1)
    {
        a = skuinfo;
        super();
        b = d1;
        e = downloadtype;
        d = b1;
        c = new e(skuinfo, e, com.cyberlink.youcammakeup.kernelctrl.sku.h.a, this);
    }

    public void a()
    {
        NetworkManager networkmanager;
        g g1;
        networkmanager = Globals.d().w();
        g1 = b.a(com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a));
        if (g1.o() == null || g1.o().getHost() == null)
        {
            if (b instanceof com.cyberlink.youcammakeup.kernelctrl.sku.b)
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, e, "");
            }
            return;
        }
        if (com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.b(a))
        {
            File file = new File(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.a(b.a(SkuInfo.c(a))));
            if (file.exists())
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, file);
            }
        }
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority taskpriority;
        if (!com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a).d().equals(com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a()))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        taskpriority = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b;
_L1:
        networkmanager.a(com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a).a(), g1, taskpriority, d, c, e);
        return;
        try
        {
            taskpriority = com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.a;
        }
        catch (IOException ioexception)
        {
            return;
        }
          goto _L1
    }

    public void b()
    {
        g g1 = b.a(com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a));
        NetworkManager networkmanager = Globals.d().w();
        try
        {
            networkmanager.a(g1, d, c, e);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
