// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import com.bestbuy.android.activities.stores.DialogSpinner;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dg;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            BuyerRegistryAndWishListFragment

class a
    implements android.widget.tryAndWishListFragment._cls1
{

    final BuyerRegistryAndWishListFragment a;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)BuyerRegistryAndWishListFragment.a(a).getAdapter().getItem(i);
        if (adapterview.equals("All Gifts") || adapterview.equals("All Items"))
        {
            BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
            BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, BuyerRegistryAndWishListFragment.d(a), BuyerRegistryAndWishListFragment.e(a), 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
            BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
        } else
        {
            if (adapterview.equals("Favorite Items") || adapterview.equals("Favorite Gifts"))
            {
                adapterview = new ArrayList();
                view = new ArrayList();
                for (i = 0; i < BuyerRegistryAndWishListFragment.e(a).size(); i++)
                {
                    if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i)).isFavorite())
                    {
                        adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i));
                        view.add(BuyerRegistryAndWishListFragment.d(a).get(i));
                    }
                }

                BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                if (adapterview.size() <= 0)
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                    BuyerRegistryAndWishListFragment.b(a).bringToFront();
                    if (BuyerRegistryAndWishListFragment.h(a))
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Favorite Items");
                        return;
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Favorite Gifts");
                        return;
                    }
                } else
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                    return;
                }
            }
            if (adapterview.equals("Purchased Gifts") || adapterview.equals("Purchased Items"))
            {
                adapterview = new ArrayList();
                view = new ArrayList();
                for (i = 0; i < BuyerRegistryAndWishListFragment.e(a).size(); i++)
                {
                    if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i)).getPurchaseQuantity() > 0)
                    {
                        adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i));
                        view.add(BuyerRegistryAndWishListFragment.d(a).get(i));
                    }
                }

                BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                if (adapterview.size() <= 0)
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                    BuyerRegistryAndWishListFragment.b(a).bringToFront();
                    if (BuyerRegistryAndWishListFragment.h(a))
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Purchased Items");
                        return;
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Purchased Gifts");
                        return;
                    }
                } else
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                    return;
                }
            }
            if (adapterview.equals("Not Purchased Gifts") || adapterview.equals("Not Purchased Items"))
            {
                adapterview = new ArrayList();
                view = new ArrayList();
                for (i = 0; i < BuyerRegistryAndWishListFragment.e(a).size(); i++)
                {
                    if (((Entities)BuyerRegistryAndWishListFragment.e(a).get(i)).getPurchaseQuantity() != 0)
                    {
                        continue;
                    }
                    adapterview.add(BuyerRegistryAndWishListFragment.e(a).get(i));
                    if (BuyerRegistryAndWishListFragment.d(a) != null && BuyerRegistryAndWishListFragment.d(a).size() > 0)
                    {
                        view.add(BuyerRegistryAndWishListFragment.d(a).get(i));
                    }
                }

                BuyerRegistryAndWishListFragment.a(a, new dg(BuyerRegistryAndWishListFragment.c(a), a, 0x7f03011c, view, adapterview, 2, BuyerRegistryAndWishListFragment.f(a), BuyerRegistryAndWishListFragment.g(a), BuyerRegistryAndWishListFragment.h(a)));
                BuyerRegistryAndWishListFragment.j(a).setAdapter(BuyerRegistryAndWishListFragment.i(a));
                if (adapterview.size() <= 0 || view.size() <= 0)
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(0);
                    BuyerRegistryAndWishListFragment.b(a).bringToFront();
                    if (BuyerRegistryAndWishListFragment.h(a))
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Not Purchased Items");
                        return;
                    } else
                    {
                        BuyerRegistryAndWishListFragment.b(a).setText("No Not Purchased Gifts");
                        return;
                    }
                } else
                {
                    BuyerRegistryAndWishListFragment.b(a).setVisibility(8);
                    return;
                }
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    (BuyerRegistryAndWishListFragment buyerregistryandwishlistfragment)
    {
        a = buyerregistryandwishlistfragment;
        super();
    }
}
