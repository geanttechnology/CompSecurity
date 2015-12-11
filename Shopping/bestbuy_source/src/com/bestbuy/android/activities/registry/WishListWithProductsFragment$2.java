// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.os.AsyncTask;
import android.widget.AbsListView;
import java.util.ArrayList;
import jn;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment

class a
    implements android.widget.stWithProductsFragment._cls2
{

    final WishListWithProductsFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (WishListWithProductsFragment.b(a) || k <= 0 || i + j != k)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        i = (WishListWithProductsFragment.c(a) + 1) * 25;
        k = i + 25;
        if (WishListWithProductsFragment.d(a) == null || WishListWithProductsFragment.d(a).size() <= i)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        abslistview = new ArrayList();
        do
        {
label0:
            {
                if (WishListWithProductsFragment.d(a).size() > k)
                {
                    j = k;
                } else
                {
                    j = WishListWithProductsFragment.d(a).size();
                }
                if (i >= j)
                {
                    break label0;
                }
                abslistview.add(WishListWithProductsFragment.d(a).get(i));
                i++;
            }
        } while (true);
        WishListWithProductsFragment.e(a);
        WishListWithProductsFragment.a(a, true);
        if (abslistview.size() > 0)
        {
            (new jn(a.d, a, null, abslistview, WishListWithProductsFragment.f(a))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (WishListWithProductsFragment wishlistwithproductsfragment)
    {
        a = wishlistwithproductsfragment;
        super();
    }
}
