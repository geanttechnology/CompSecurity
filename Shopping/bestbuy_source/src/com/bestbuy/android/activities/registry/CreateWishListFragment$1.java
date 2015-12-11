// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.ListTypes;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            CreateWishListFragment, EditListDetailsFragment, WishListFragmentContainer, RegistryFragmentContainer

class a
    implements android.widget.stener
{

    final ArrayList a;
    final CreateWishListFragment b;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (((ListTypes)a.get(i)).getType().equals("weddingregistrylists"))
        {
            CreateWishListFragment.a(b).setListType("weddingregistry");
        } else
        {
            CreateWishListFragment.a(b).setListType(((ListTypes)a.get(i)).getType());
        }
        if (CreateWishListFragment.b(b) != null && !CreateWishListFragment.b(b).isEmpty())
        {
            adapterview = new EditListDetailsFragment(CreateWishListFragment.a(b), ((ListTypes)a.get(i)).getDescription(), CreateWishListFragment.b(b));
        } else
        {
            adapterview = new EditListDetailsFragment(CreateWishListFragment.a(b), ((ListTypes)a.get(i)).getDescription());
        }
        view = b.getParentFragment();
        if (view instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)view).a(adapterview, true, "EditListDetailsFragment");
        }
        if (view instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)view).a(adapterview, true, "EditListDetailsFragment");
        }
        if (view instanceof HomeTabContainer)
        {
            ((HomeTabContainer)view).a(adapterview, true);
        }
    }

    (CreateWishListFragment createwishlistfragment, ArrayList arraylist)
    {
        b = createwishlistfragment;
        a = arraylist;
        super();
    }
}
