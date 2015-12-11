// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartTabFragment

public class ShoppingCartTabFragmentAdapter extends FragmentStatePagerAdapter
{

    public static final int PAGE_IN_CART = 0;
    public static final int PAGE_SAVED = 1;
    private final Context context;

    public ShoppingCartTabFragmentAdapter(FragmentManager fragmentmanager, Context context1)
    {
        super(fragmentmanager);
        context = context1;
    }

    public int getCount()
    {
        return 2;
    }

    public Fragment getItem(int i)
    {
        ShoppingCartTabFragment shoppingcarttabfragment = new ShoppingCartTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("com.ebay.mobile.shoppingcart.ShoppingCartTabFragment.tabIndex", i);
        shoppingcarttabfragment.setArguments(bundle);
        return shoppingcarttabfragment;
    }

    public CharSequence getPageTitle(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return context.getString(0x7f070aaf);

        case 1: // '\001'
            return context.getString(0x7f070ab0);
        }
    }
}
