// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ak;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity

class a
    implements aj
{

    final SponsorAdActivity a;

    public void a(ak ak1)
    {
        Object obj;
        m.b("SponsorAdActivity", "getSkuByGuid complete");
        obj = ak1.a();
        if (obj == null || ((Collection) (obj)).size() == 0)
        {
            SponsorAdActivity.c(a);
            return;
        }
        obj = ((Collection) (obj)).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        d d1 = (d)((Iterator) (obj)).next();
        if (d1 == null) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        long l2;
        l = System.currentTimeMillis();
        l1 = d1.f();
        l2 = d1.g();
        if (l1 <= l && l2 >= l) goto _L4; else goto _L5
_L5:
        boolean flag = true;
_L7:
        if (flag)
        {
            SponsorAdActivity.c(a);
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(SponsorAdActivity.a(a).type);
            h.b().a(SponsorAdActivity.k(a));
            h.b().a(arraylist, ak1);
            return;
        }
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(bn bn1)
    {
        m.e("SponsorAdActivity", (new StringBuilder()).append("getSkuByGuid error = ").append(bn1.toString()).toString());
        SponsorAdActivity.c(a);
    }

    public volatile void a(Object obj)
    {
        a((ak)obj);
    }

    public void a(Void void1)
    {
        m.b("SponsorAdActivity", "getSkuByGuid cancel");
        SponsorAdActivity.c(a);
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    k.bn(SponsorAdActivity sponsoradactivity)
    {
        a = sponsoradactivity;
        super();
    }
}
