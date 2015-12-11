// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.widget.AbsListView;
import java.util.ArrayList;
import jn;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            BuyerRegistryAndWishListFragment

class a
    implements android.widget.tryAndWishListFragment._cls2
{

    final BuyerRegistryAndWishListFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (BuyerRegistryAndWishListFragment.k(a) || k <= 0 || i + j != k)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        i = (BuyerRegistryAndWishListFragment.l(a) + 1) * 25;
        k = i + 25;
        if (BuyerRegistryAndWishListFragment.e(a) == null || BuyerRegistryAndWishListFragment.e(a).size() <= i)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        abslistview = new ArrayList();
        do
        {
label0:
            {
                if (BuyerRegistryAndWishListFragment.e(a).size() > k)
                {
                    j = k;
                } else
                {
                    j = BuyerRegistryAndWishListFragment.e(a).size();
                }
                if (i >= j)
                {
                    break label0;
                }
                abslistview.add(BuyerRegistryAndWishListFragment.e(a).get(i));
                i++;
            }
        } while (true);
        BuyerRegistryAndWishListFragment.m(a);
        BuyerRegistryAndWishListFragment.a(a, true);
        if (abslistview.size() > 0)
        {
            (new jn(BuyerRegistryAndWishListFragment.c(a), a, null, abslistview, false)).executeOnExecutor(nb.h, new Void[0]);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        a = buyerregistryandwishlistfragment;
        super();
    }
}
