// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.ArrayAdapter;
import com.cyberlink.beautycircle.model.ProductPrice;
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
            "listPriceRange:", Integer.valueOf(i)
        });
        if (com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).isEmpty())
        {
            com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).add(ProductPrice.b());
            com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).notifyDataSetChanged();
        }
    }

    public void a(d d1)
    {
        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).clear();
        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).add(ProductPrice.b());
        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).addAll(d1.b);
        PageProductsFragment.a(a, 2);
        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).notifyDataSetChanged();
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
