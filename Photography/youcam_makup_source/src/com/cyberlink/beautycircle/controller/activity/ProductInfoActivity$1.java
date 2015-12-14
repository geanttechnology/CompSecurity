// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductInfoActivity

class a extends m
{

    final long a;
    final ProductInfoActivity b;

    protected void a()
    {
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("queryProdInfo(").append(a).append(") canceld!").toString());
        }
    }

    protected void a(int i)
    {
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("queryProdInfo(").append(a).append(") fail! error: ").append(Integer.toHexString(i)).toString());
        }
    }

    protected void a(d d1)
    {
        if (d1 == null || d1.a.intValue() <= 0)
        {
            a(0x80000003);
            return;
        } else
        {
            ProductInfoActivity.a(b, (Product)d1.b.get(0));
            ProductInfoActivity.a(b);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (ProductInfoActivity productinfoactivity, long l)
    {
        b = productinfoactivity;
        a = l;
        super();
    }
}
