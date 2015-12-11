// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import de;
import fr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import jd;
import jf;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            MyEmptyWishListFragment, CreateWishListFragment, WishListFragmentContainer, RegistryFragmentContainer, 
//            WishListWithProductsFragment

public class MyWishListsFragment extends BBYBaseFragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, cg
{

    public static boolean a;
    private de b;
    private ListView c;
    private RegistryWishList g;
    private View h;
    private View i;
    private String j;

    public MyWishListsFragment()
    {
        a = false;
    }

    public MyWishListsFragment(boolean flag, String s)
    {
        a = flag;
        j = s;
    }

    static RegistryWishList a(MyWishListsFragment mywishlistsfragment)
    {
        return mywishlistsfragment.g;
    }

    static RegistryWishList a(MyWishListsFragment mywishlistsfragment, RegistryWishList registrywishlist)
    {
        mywishlistsfragment.g = registrywishlist;
        return registrywishlist;
    }

    static View b(MyWishListsFragment mywishlistsfragment)
    {
        return mywishlistsfragment.h;
    }

    private void b()
    {
        nb.a().l(false);
        nb.a().j(false);
        nb.a().k(false);
        f.b(false);
        f.a(new ArrayList());
        f.e("");
    }

    public void a(BaseFragmentContainer basefragmentcontainer)
    {
        basefragmentcontainer.a(new MyEmptyWishListFragment(g), true, "MyEmptyWishListFragment");
    }

    public void a(String s)
    {
        android.support.v4.app.Fragment fragment;
        if (s != null && !s.isEmpty())
        {
            s = new CreateWishListFragment(s, true);
        } else
        {
            s = new CreateWishListFragment();
        }
        fragment = getParentFragment();
        if (fragment instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(s, true, "CreateWishListFragment");
        }
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(s, true, "CreateWishListFragment");
        }
    }

    public void a(ArrayList arraylist)
    {
        Collections.sort(arraylist);
        b = new de(d, 0x7f03006d, arraylist);
        c.setAdapter(b);
        c.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(arraylist) {

            final ArrayList a;
            final MyWishListsFragment b;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                if (k < a.size())
                {
                    MyWishListsFragment.a(b, (RegistryWishList)a.get(k));
                    (new jd(b.d, b, fr.d(), MyWishListsFragment.a(b).getUuid(), MyWishListsFragment.a(b).getType(), false, MyWishListsFragment.b(b))).executeOnExecutor(nb.g, new Void[0]);
                }
            }

            
            {
                b = MyWishListsFragment.this;
                a = arraylist;
                super();
            }
        });
    }

    public void b(ArrayList arraylist)
    {
        String s = g.getType().trim();
        c.setVisibility(4);
        BaseFragmentContainer basefragmentcontainer = (BaseFragmentContainer)getParentFragment();
        if (arraylist != null && arraylist.size() > 0)
        {
            lu.a((new StringBuilder()).append(lu.L).append(s.substring(0, s.length() - 1)).toString());
            basefragmentcontainer.a(new WishListWithProductsFragment(this, g, arraylist), true, "WishListWithProductsFragment");
            return;
        } else
        {
            lu.a((new StringBuilder()).append(lu.y).append(s.substring(0, s.length() - 1)).toString());
            a(basefragmentcontainer);
            return;
        }
    }

    public void g()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (!a)
        {
            (new jf(d, this, h)).executeOnExecutor(nb.g, new Void[0]);
            return;
        } else
        {
            a(j);
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        activity = new HashMap();
        activity.put(lu.bo, "profile,lifeEvents,dashboard");
        activity.put(lu.bp, "LE");
        lu.b(lu.z, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f03006c, viewgroup, false);
        bundle = (InputMethodManager)d.getSystemService("input_method");
        if (d.getCurrentFocus() != null && d.getCurrentFocus().getWindowToken() != null)
        {
            bundle.hideSoftInputFromWindow(d.getCurrentFocus().getWindowToken(), 0);
        }
        i = layoutinflater.inflate(0x7f03011a, null);
        c = (ListView)viewgroup.findViewById(0x7f0c0181);
        c.setLongClickable(true);
        c.addFooterView(i);
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final MyWishListsFragment a;

            public void onClick(View view)
            {
                a.a("");
            }

            
            {
                a = MyWishListsFragment.this;
                super();
            }
        });
        h = viewgroup.findViewById(0x7f0c0064);
        return viewgroup;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (a)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, true);
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            return;
        }
    }

    public void onRefresh()
    {
        (new Handler()).postDelayed(new Runnable() {

            final MyWishListsFragment a;

            private void a()
            {
            }

            public void run()
            {
                a();
            }

            
            {
                a = MyWishListsFragment.this;
                super();
            }
        }, 5000L);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("My Wish Lists");
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        b();
    }
}
