// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import fr;
import java.util.ArrayList;
import jd;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            MyWishListsFragment

class a
    implements android.widget.kListener
{

    final ArrayList a;
    final MyWishListsFragment b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < a.size())
        {
            MyWishListsFragment.a(b, (RegistryWishList)a.get(i));
            (new jd(b.d, b, fr.d(), MyWishListsFragment.a(b).getUuid(), MyWishListsFragment.a(b).getType(), false, MyWishListsFragment.b(b))).executeOnExecutor(nb.g, new Void[0]);
        }
    }

    (MyWishListsFragment mywishlistsfragment, ArrayList arraylist)
    {
        b = mywishlistsfragment;
        a = arraylist;
        super();
    }
}
