// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishListCompleteData;
import fr;
import java.util.ArrayList;
import jd;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ListIdSearchFragment

class a
    implements android.widget.Listener
{

    final RegistryWishListCompleteData a;
    final ListIdSearchFragment b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < a.getRegistryWishlistArray().size())
        {
            ListIdSearchFragment.a(b, (RegistryWishList)a.getRegistryWishlistArray().get(i));
            (new jd(b.d, b, fr.d(), ListIdSearchFragment.a(b).getUuid(), ListIdSearchFragment.a(b).getType(), false, ListIdSearchFragment.b(b))).executeOnExecutor(nb.g, new Void[0]);
        }
    }

    pleteData(ListIdSearchFragment listidsearchfragment, RegistryWishListCompleteData registrywishlistcompletedata)
    {
        b = listidsearchfragment;
        a = registrywishlistcompletedata;
        super();
    }
}
