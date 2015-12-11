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
import cg;
import cn;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.AliasesList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.ArrayList;
import java.util.List;
import jl;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListFragmentContainer, RegistryFragmentContainer

public class ListOfAliasesFragment extends BBYBaseFragment
    implements cg
{

    private cn a;
    private ListView b;
    private ArrayList c;
    private View g;

    public ListOfAliasesFragment()
    {
    }

    static ArrayList a(ListOfAliasesFragment listofaliasesfragment)
    {
        return listofaliasesfragment.c;
    }

    static cn b(ListOfAliasesFragment listofaliasesfragment)
    {
        return listofaliasesfragment.a;
    }

    static View c(ListOfAliasesFragment listofaliasesfragment)
    {
        return listofaliasesfragment.g;
    }

    public void a(ArrayList arraylist, String s)
    {
        arraylist = new PLPFragment(true, "PLP", s, arraylist, "", 20);
        s = getParentFragment();
        if (s instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)s).a(arraylist, true);
        } else
        if (s instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)s).a(arraylist, true);
            return;
        }
    }

    public void g()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        nb.a().i(((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle());
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f0801ec));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030008, viewgroup, false);
        g = layoutinflater.findViewById(0x7f0c0064);
        if (layoutinflater != null)
        {
            b = (ListView)layoutinflater.findViewById(0x7f0c004d);
            a = new cn(getActivity(), 0x7f030007, c);
            b.setAdapter(a);
            b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final ListOfAliasesFragment a;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    if (i < ListOfAliasesFragment.a(a).size())
                    {
                        adapterview = (AliasesList)ListOfAliasesFragment.b(a).a.get(i);
                        (new jl(a.d, a, ListOfAliasesFragment.c(a), adapterview.getAlias(), adapterview.getDescription())).execute(new Void[0]);
                    }
                }

            
            {
                a = ListOfAliasesFragment.this;
                super();
            }
            });
        }
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f0801ec));
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
    }
}
