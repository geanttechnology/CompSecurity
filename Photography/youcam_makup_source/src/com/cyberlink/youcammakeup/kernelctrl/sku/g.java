// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.e;
import java.net.URI;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            SkuInfo

public class g
    implements e
{

    final SkuInfo a;
    private long b;
    private String c;
    private String d;
    private URI e;
    private d f;

    public g(SkuInfo skuinfo, long l1, String s, String s1, URI uri, d d1)
    {
        a = skuinfo;
        super();
        b = l1;
        c = s;
        d = s1;
        e = uri;
        f = d1;
    }

    public d a()
    {
        return f;
    }

    public long l()
    {
        return b;
    }

    public String m()
    {
        return c;
    }

    public String n()
    {
        return d;
    }

    public URI o()
    {
        return e;
    }
}
