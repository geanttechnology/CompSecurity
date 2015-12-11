// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import com.bestbuy.android.activities.stores.DialogSpinner;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment

class a
    implements android.widget.ner
{

    final WishListWithProductsFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)WishListWithProductsFragment.a(a).getAdapter().getItem(i);
        WishListWithProductsFragment.a(a, adapterview, false);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (WishListWithProductsFragment wishlistwithproductsfragment)
    {
        a = wishlistwithproductsfragment;
        super();
    }
}
