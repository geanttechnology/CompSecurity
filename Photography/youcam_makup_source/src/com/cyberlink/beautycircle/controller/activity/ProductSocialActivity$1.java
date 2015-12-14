// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class a extends m
{

    final ProductSocialActivity a;

    protected void a(int i)
    {
        e.e(new Object[] {
            "queryProdInfo: ", Integer.toHexString(i)
        });
        ProductSocialActivity.a(a);
        if (ProductSocialActivity.b(a) != null)
        {
            ProductSocialActivity.b(a).setRefreshing(false);
        }
    }

    protected void a(d d1)
    {
        if (d1 == null || d1.a.intValue() <= 0 || d1.b == null)
        {
            b(0x80000003);
        } else
        {
            ProductSocialActivity.a(a, (Product)d1.b.get(0));
            ProductSocialActivity.a(a);
            if (ProductSocialActivity.b(a) != null)
            {
                ProductSocialActivity.b(a).setRefreshing(false);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (ProductSocialActivity productsocialactivity)
    {
        a = productsocialactivity;
        super();
    }
}
