// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            f, SkuInfo

class e
    implements h
{

    final SkuInfo a;
    private SkuInfo.DownloadType b;
    private int c;
    private f d;

    public e(SkuInfo skuinfo, SkuInfo.DownloadType downloadtype, int i, f f1)
    {
        a = skuinfo;
        super();
        b = downloadtype;
        c = i;
        d = f1;
    }

    public void a()
    {
    }

    public void a(a a1)
    {
    }

    public void a(bn bn)
    {
        if (c > 0)
        {
            c = c - 1;
            d.a();
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, b);
            return;
        }
    }

    public void a(String s)
    {
        if (b != SkuInfo.DownloadType.b) goto _L2; else goto _L1
_L1:
        SkuInfo.b(a, s, com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, s, "room.xml"));
_L4:
        com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, b, s);
        return;
_L2:
        if (b == SkuInfo.DownloadType.c)
        {
            SkuInfo.c(a, s, com.cyberlink.youcammakeup.kernelctrl.sku.SkuInfo.a(a, s, "dfp.xml"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
