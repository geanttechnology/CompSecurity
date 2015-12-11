// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.ListTypes;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cp;
import java.util.ArrayList;
import je;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            EditListDetailsFragment, WishListFragmentContainer, RegistryFragmentContainer

public class CreateWishListFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private cp a;
    private ListView b;
    private String c;
    private View g;
    private WishListReqData h;
    private TableLayout i;
    private boolean j;

    public CreateWishListFragment()
    {
        h = new WishListReqData();
    }

    public CreateWishListFragment(String s, boolean flag)
    {
        h = new WishListReqData();
        c = s;
        j = flag;
    }

    static WishListReqData a(CreateWishListFragment createwishlistfragment)
    {
        return createwishlistfragment.h;
    }

    static String b(CreateWishListFragment createwishlistfragment)
    {
        return createwishlistfragment.c;
    }

    public void a(ArrayList arraylist)
    {
        a = new cp(d, 0x7f030116, arraylist);
        b.setAdapter(a);
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(arraylist) {

            final ArrayList a;
            final CreateWishListFragment b;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                if (((ListTypes)a.get(k)).getType().equals("weddingregistrylists"))
                {
                    CreateWishListFragment.a(b).setListType("weddingregistry");
                } else
                {
                    CreateWishListFragment.a(b).setListType(((ListTypes)a.get(k)).getType());
                }
                if (CreateWishListFragment.b(b) != null && !CreateWishListFragment.b(b).isEmpty())
                {
                    adapterview = new EditListDetailsFragment(CreateWishListFragment.a(b), ((ListTypes)a.get(k)).getDescription(), CreateWishListFragment.b(b));
                } else
                {
                    adapterview = new EditListDetailsFragment(CreateWishListFragment.a(b), ((ListTypes)a.get(k)).getDescription());
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

            
            {
                b = CreateWishListFragment.this;
                a = arraylist;
                super();
            }
        });
    }

    public void g()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f080337));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        lu.a(lu.K);
    }

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030027, viewgroup, false);
        i = (TableLayout)layoutinflater.findViewById(0x7f0c0076);
        g = layoutinflater.findViewById(0x7f0c0064);
        if (layoutinflater != null)
        {
            b = (ListView)layoutinflater.findViewById(0x7f0c004d);
            (new je(d, this, g)).executeOnExecutor(nb.g, new Void[0]);
        }
        i.setOnClickListener(this);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f080337));
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }
}
