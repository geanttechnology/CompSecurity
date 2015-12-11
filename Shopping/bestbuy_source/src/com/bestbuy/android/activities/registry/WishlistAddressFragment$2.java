// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishlistAddressFragment

class a
    implements android.widget.Listener
{

    final WishlistAddressFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (!WishlistAddressFragment.b(a).getSelectedItem().toString().equals("Select a state"))
        {
            WishlistAddressFragment.a(a, true);
            if (WishlistAddressFragment.c(a) && WishlistAddressFragment.d(a) && WishlistAddressFragment.e(a) && WishlistAddressFragment.f(a))
            {
                WishlistAddressFragment.b(a, true);
                return;
            } else
            {
                WishlistAddressFragment.b(a, false);
                return;
            }
        } else
        {
            WishlistAddressFragment.a(a, false);
            WishlistAddressFragment.b(a, false);
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        WishlistAddressFragment.a(a, false);
    }

    (WishlistAddressFragment wishlistaddressfragment)
    {
        a = wishlistaddressfragment;
        super();
    }
}
