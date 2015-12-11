// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cv;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishlistAdditionalOptions, WishListFragmentContainer, RegistryFragmentContainer, WishListSettingsFragment, 
//            WeddingRegistrySettings

public class WishListPrivacyFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    public String a;
    private RadioButton b;
    private RadioButton c;
    private boolean g;
    private boolean h;
    private cv i;
    private WishListReqData j;
    private Fragment k;
    private RelativeLayout l;
    private String m;
    private WeddingRegistryData n;
    private String o;
    private String p;

    public WishListPrivacyFragment(WishListReqData wishlistreqdata)
    {
        a = "public";
        n = new WeddingRegistryData();
        j = wishlistreqdata;
    }

    public WishListPrivacyFragment(WishListReqData wishlistreqdata, String s)
    {
        a = "public";
        n = new WeddingRegistryData();
        j = wishlistreqdata;
        m = s;
    }

    public WishListPrivacyFragment(WishListReqData wishlistreqdata, String s, Fragment fragment, boolean flag)
    {
        a = "public";
        n = new WeddingRegistryData();
        j = wishlistreqdata;
        p = s;
        k = fragment;
        g = flag;
    }

    public void b()
    {
        j.setPrivacySetting(a);
        WishlistAdditionalOptions wishlistadditionaloptions;
        Fragment fragment;
        if (m != null && !m.isEmpty())
        {
            wishlistadditionaloptions = new WishlistAdditionalOptions(j, m);
        } else
        {
            wishlistadditionaloptions = new WishlistAdditionalOptions(j);
        }
        fragment = getParentFragment();
        if (fragment instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(wishlistadditionaloptions, true, "WishlistAdditionalOptions");
        }
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(wishlistadditionaloptions, true, "WishlistAdditionalOptions");
        }
        if (fragment instanceof HomeTabContainer)
        {
            ((HomeTabContainer)fragment).a(wishlistadditionaloptions, true);
        }
    }

    public void c()
    {
        if (g)
        {
            j.setPrivacySetting(a);
            ((WishListSettingsFragment)k).a(j, false, 0);
            ((HomeActivity)d).onBackPressed();
        }
        if (h)
        {
            Bundle bundle = new Bundle();
            bundle.putString("privacySetting", a);
            n.setPrivacySetting(a);
            ((WeddingRegistrySettings)k).a(bundle, n, false, 0);
            ((HomeActivity)d).onBackPressed();
        }
    }

    public void g()
    {
        if (g || h)
        {
            c();
            return;
        } else
        {
            b();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        i = (cv)activity;
        i.onCreateWishListFragmentLaunch();
    }

    public void onClick(View view)
    {
        if (view == c)
        {
            a = "public";
        } else
        {
            if (view == b)
            {
                a = "private";
                return;
            }
            if (view == l)
            {
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03011b, viewgroup, false);
        l = (RelativeLayout)layoutinflater.findViewById(0x7f0c0076);
        c = (RadioButton)layoutinflater.findViewById(0x7f0c0424);
        b = (RadioButton)layoutinflater.findViewById(0x7f0c0425);
        c.setChecked(true);
        if (j != null)
        {
            j.setPrivacySetting("public");
        }
        if (o != null)
        {
            if (o.equalsIgnoreCase("public"))
            {
                a = "public";
                c.setChecked(true);
            } else
            if (o.equalsIgnoreCase("private"))
            {
                a = "private";
                b.setChecked(true);
            } else
            {
                a = "public";
            }
        }
        c.setText(Html.fromHtml(getActivity().getResources().getString(0x7f0802c4)));
        b.setText(Html.fromHtml(getActivity().getResources().getString(0x7f0802b4)));
        c.setOnClickListener(this);
        b.setOnClickListener(this);
        l.setOnClickListener(this);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)getActivity()).changeActionBarSearchVisibility(getActivity(), false);
        if (p != null)
        {
            if (p.equalsIgnoreCase("public"))
            {
                a = "public";
                c.setChecked(true);
            } else
            if (p.equalsIgnoreCase("private"))
            {
                a = "private";
                b.setChecked(true);
            } else
            {
                a = "public";
            }
        }
        HomeActivity.inLifeEventsFragment = true;
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (g || h)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("Privacy");
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "Save", true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f08033b));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
            return;
        }
    }
}
