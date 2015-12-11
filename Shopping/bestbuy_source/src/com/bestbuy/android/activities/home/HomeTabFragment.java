// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabWidget;
import cl;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.BrowseSuperSubCategoryFragment;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.cart.MyCartFragment;
import com.bestbuy.android.activities.stores.StoreTabContainer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.HashMap;
import java.util.Stack;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeTabContainer, HomeActivity

public class HomeTabFragment extends BBYBaseFragment
    implements android.view.View.OnTouchListener
{

    private String a;
    private FragmentTabHost b;
    private int c;
    private RelativeLayout g;
    private nb h;
    private RelativeLayout i;

    public HomeTabFragment()
    {
        a = getClass().getName();
        c = -1;
    }

    static nb a(HomeTabFragment hometabfragment)
    {
        return hometabfragment.h;
    }

    private void a(Context context, String s, int j, Class class1, FragmentTabHost fragmenttabhost)
    {
        context = LayoutInflater.from(context).inflate(0x7f030059, null);
        ImageView imageview = (ImageView)context.findViewById(0x7f0c0141);
        ((BBYTextView)context.findViewById(0x7f0c0142)).setText(s);
        imageview.setImageResource(j);
        context.setTag(s);
        if (s.equals("CART"))
        {
            g = (RelativeLayout)context.findViewById(0x7f0c0143);
        }
        context.setOnTouchListener(this);
        s = fragmenttabhost.newTabSpec(s);
        s.setIndicator(context);
        fragmenttabhost.addTab(s, class1, null);
    }

    public void a(int j)
    {
        b.setCurrentTab(j);
    }

    public FragmentTabHost b()
    {
        return b;
    }

    public void c()
    {
        int j = nb.a().b().getInt(d.getResources().getString(0x7f080031), 0);
        if (j > 0 && g != null)
        {
            g.setVisibility(0);
            ((BBYTextView)g.findViewById(0x7f0c0144)).setText((new StringBuilder()).append("").append(j).toString());
        } else
        {
            g.setVisibility(8);
            if (b.getCurrentTab() == 3)
            {
                Fragment fragment = getChildFragmentManager().findFragmentByTag("CART");
                if (fragment instanceof CartTabContainer)
                {
                    ((BaseTabContainer)fragment).a(new MyCartFragment(), false);
                    return;
                }
            }
        }
    }

    public void d()
    {
        int j = nb.a().b().getInt(d.getResources().getString(0x7f080031), 0);
        if (j > 0 && g != null)
        {
            g.setVisibility(0);
            ((BBYTextView)g.findViewById(0x7f0c0144)).setText((new StringBuilder()).append("").append(j).toString());
            return;
        } else
        {
            g.setVisibility(8);
            return;
        }
    }

    public Fragment e()
    {
        Fragment fragment = null;
        String s = b.getCurrentTabTag();
        if (s.equals("HOME"))
        {
            fragment = getChildFragmentManager().findFragmentByTag("HOME");
        } else
        {
            if (s.equals("PRODUCTS"))
            {
                return getChildFragmentManager().findFragmentByTag("PRODUCTS");
            }
            if (s.equals("STORES"))
            {
                return getChildFragmentManager().findFragmentByTag("STORES");
            }
            if (s.equals("CART"))
            {
                return getChildFragmentManager().findFragmentByTag("CART");
            }
        }
        return fragment;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030058, viewgroup, false);
        i = (RelativeLayout)layoutinflater.findViewById(0x7f0c013d);
        b = (FragmentTabHost)layoutinflater.findViewById(0x1020012);
        b.setup(d, getChildFragmentManager(), 0x7f0c013c);
        b.getTabWidget().setDividerDrawable(null);
        a(d, "HOME", 0x7f0200e6, com/bestbuy/android/activities/home/HomeTabContainer, b);
        a(d, "PRODUCTS", 0x7f02015e, com/bestbuy/android/activities/browseproduct/ProductTabContainer, b);
        a(d, "STORES", 0x7f0201aa, com/bestbuy/android/activities/stores/StoreTabContainer, b);
        a(d, "CART", 0x7f02006b, com/bestbuy/android/activities/cart/CartTabContainer, b);
        if (c != -1)
        {
            b.setCurrentTab(c);
        }
        ((ImageView)b.getTabWidget().getChildAt(b.getCurrentTab()).findViewById(0x7f0c0141)).setImageResource(0x7f0200e6);
        ((HomeActivity)d).updateActionBarTitle("Home");
        h.h("Home");
        b.setOnTabChangedListener(new android.widget.TabHost.OnTabChangeListener() {

            final HomeTabFragment a;

            public void onTabChanged(String s)
            {
                boolean flag;
                HomeTabContainer.a = false;
                if (s.equals("PRODUCTS"))
                {
                    Object obj = new HashMap();
                    ((HashMap) (obj)).put(lu.bo, "browse,products");
                    ((HashMap) (obj)).put(lu.bp, "PRD");
                    lu.b(lu.D, ((HashMap) (obj)));
                    obj = a.getChildFragmentManager().findFragmentByTag("PRODUCTS");
                    if (!(obj instanceof ProductTabContainer))
                    {
                        break MISSING_BLOCK_LABEL_356;
                    }
                    ((BaseTabContainer)obj).c();
                    obj = ((ProductTabContainer)obj).b();
                    if (!(obj instanceof PLPFragmentContainer) && !(obj instanceof BrowseSuperSubCategoryFragment))
                    {
                        break MISSING_BLOCK_LABEL_356;
                    }
                    flag = false;
                } else
                {
label0:
                    {
                        if (!s.equals("HOME"))
                        {
                            break label0;
                        }
                        ((BaseTabContainer)a.getChildFragmentManager().findFragmentByTag("HOME")).c();
                        HashMap hashmap = new HashMap();
                        hashmap.put(lu.bo, "browse,home");
                        hashmap.put(lu.bp, "GHP");
                        lu.b(lu.a, hashmap);
                        HomeTabContainer.a = true;
                        flag = true;
                    }
                }
_L1:
                s = s.toLowerCase();
                s = (new StringBuilder()).append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).toString();
                HomeTabFragment.a(a).h(s);
                if (flag)
                {
                    ((HomeActivity)a.d).updateActionBarTitle(s);
                }
                s = ((BBYBaseFragmentActivity)a.d).getCurrentActionBarTitle();
                HomeTabFragment.a(a).U().clear();
                HomeTabFragment.a(a).i(s);
                Fragment fragment;
                if (s.equals("Products") || s.equals("Home") || s.equals("Stores") || s.equals("Cart"))
                {
                    ((BBYBaseFragmentActivity)a.d).showActionBarHome();
                    return;
                } else
                {
                    ((BBYBaseFragmentActivity)a.d).hideActionBarHome();
                    return;
                }
                if (s.equals("STORES"))
                {
                    fragment = a.getChildFragmentManager().findFragmentByTag("STORES");
                    if (fragment != null)
                    {
                        ((BaseTabContainer)fragment).c();
                    }
                }
                flag = true;
                  goto _L1
            }

            
            {
                a = HomeTabFragment.this;
                super();
            }
        });
        return b;
    }

    public void onResume()
    {
        super.onResume();
        h.U().clear();
        h.i(h.S());
        ((HomeActivity)d).updateActionBarTitle(h.S());
        ((cl)d).sendActivateLayout(i);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        String s = b.getCurrentTabTag();
        if (s.equals(view.getTag()))
        {
            if (motionevent.getAction() == 0)
            {
                view = getChildFragmentManager().findFragmentByTag(s);
                if (view instanceof BaseTabContainer)
                {
                    ((BaseTabContainer)view).c();
                }
            }
            return true;
        } else
        {
            return false;
        }
    }
}
