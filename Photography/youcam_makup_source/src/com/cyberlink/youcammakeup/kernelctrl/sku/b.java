// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import com.cyberlink.youcammakeup.database.more.i.d;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            d, g, SkuInfo

class b
    implements com.cyberlink.youcammakeup.kernelctrl.sku.d
{

    final SkuInfo a;

    private b(SkuInfo skuinfo)
    {
        a = skuinfo;
        super();
    }

    b(SkuInfo skuinfo, SkuInfo._cls1 _pcls1)
    {
        this(skuinfo);
    }

    public g a(d d1)
    {
        return new g(a, d1.a(), (new StringBuilder()).append(d1.d()).append("_").append(SkuInfo.DownloadType.c).toString(), "sku", d1.j(), d1);
    }
}
