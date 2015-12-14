// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.model.ProductType;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageProductsFragment

class a extends m
{

    final PageProductsFragment a;

    public void a(int i)
    {
        e.e(new Object[] {
            "listAllTypes:", Integer.valueOf(i)
        });
        if (PageProductsFragment.c(a).isEmpty())
        {
            PageProductsFragment.c(a).add(ProductType.b());
            PageProductsFragment.c(a).notifyDataSetChanged();
        }
    }

    public void a(d d1)
    {
        PageProductsFragment.c(a).clear();
        PageProductsFragment.c(a).add(ProductType.b());
        PageProductsFragment.c(a).addAll(d1.b);
        PageProductsFragment.a(a, 1);
        PageProductsFragment.c(a).notifyDataSetChanged();
    }

    public void b(Object obj)
    {
        a((d)obj);
    }

    (PageProductsFragment pageproductsfragment)
    {
        a = pageproductsfragment;
        super();
    }
}
