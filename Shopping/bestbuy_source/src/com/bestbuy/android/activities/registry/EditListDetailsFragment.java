// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.WishListReqData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cs;
import cv;
import fr;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListPrivacyFragment, WishListFragmentContainer, RegistryFragmentContainer, WishListSettingsFragment

public class EditListDetailsFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private EditText a;
    private String b;
    private String c;
    private String g;
    private cv h;
    private boolean i;
    private Bundle j;
    private WishListReqData k;
    private Fragment l;
    private RelativeLayout m;
    private boolean n;

    public EditListDetailsFragment(WishListReqData wishlistreqdata, Fragment fragment, boolean flag)
    {
        n = false;
        l = fragment;
        k = wishlistreqdata;
        i = flag;
    }

    public EditListDetailsFragment(WishListReqData wishlistreqdata, String s)
    {
        n = false;
        k = wishlistreqdata;
        g = s;
    }

    public EditListDetailsFragment(WishListReqData wishlistreqdata, String s, String s1)
    {
        n = false;
        k = wishlistreqdata;
        g = s;
        b = s1;
    }

    public static boolean a(EditListDetailsFragment editlistdetailsfragment, boolean flag)
    {
        editlistdetailsfragment.n = flag;
        return flag;
    }

    public void b()
    {
        Object obj = a.getText().toString();
        k.setRegistryName(((String) (obj)));
        if (k != null)
        {
            obj = k.getListType().substring(0, k.getListType().length() - 1);
            lu.a((new StringBuilder()).append(lu.N).append(((String) (obj))).toString());
        }
        Fragment fragment;
        if (b != null && !b.isEmpty())
        {
            obj = new WishListPrivacyFragment(k, b);
        } else
        {
            obj = new WishListPrivacyFragment(k);
        }
        fragment = getParentFragment();
        if (fragment instanceof WishListFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(((Fragment) (obj)), true, "WishListPrivacyFragment");
        }
        if (fragment instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)fragment).a(((Fragment) (obj)), true, "WishListPrivacyFragment");
        }
        if (fragment instanceof HomeTabContainer)
        {
            ((HomeTabContainer)fragment).a(((Fragment) (obj)), true);
        }
    }

    public void c()
    {
        String s = a.getText().toString();
        k.setRegistryName(s);
        k.setAddDescription(c);
        ((WishListSettingsFragment)l).a(k, false, 0);
        ((HomeActivity)d).onBackPressed();
    }

    public void g()
    {
        if (i && n)
        {
            c();
        } else
        if (n)
        {
            b();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f080339));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        h = (cv)activity;
        h.onCreateWishListFragmentLaunch();
        if (k != null)
        {
            activity = k.getListType().substring(0, k.getListType().length() - 1);
            lu.a((new StringBuilder()).append(lu.M).append(activity).toString());
        }
    }

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030037, viewgroup, false);
        m = (RelativeLayout)layoutinflater.findViewById(0x7f0c0076);
        a = (EditText)layoutinflater.findViewById(0x7f0c00e6);
        a.requestFocus();
        a.addTextChangedListener(new cs(this, a));
        ((InputMethodManager)getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        if (k != null && k.getListType() != null)
        {
            if (k.getListType().equals("backtoschoollists"))
            {
                c = "Back To School";
            } else
            if (k.getListType().equals("holidaylists"))
            {
                c = "Holiday";
            } else
            if (k.getListType().equals("birthdaylists"))
            {
                c = "Birthday";
            } else
            if (k.getListType().equals("anniversarylists"))
            {
                c = "Anniversary";
            } else
            if (k.getListType().equals("graduationlists"))
            {
                c = "Graduation";
            } else
            if (k.getListType().equals("movinglists"))
            {
                c = "Moving";
            } else
            if (k.getListType().equals("weddinglists"))
            {
                c = "Wedding";
            } else
            {
                c = g;
            }
        }
        if (k == null || k.getRegistryName() == null || k.getRegistryName().isEmpty()) goto _L2; else goto _L1
_L1:
        a.setText(k.getRegistryName());
        a.setHint(k.getRegistryName());
_L4:
        m.setOnClickListener(this);
        return layoutinflater;
_L2:
        if (fr.e() != null)
        {
            viewgroup = fr.e().toLowerCase();
            viewgroup = (new StringBuilder()).append(Character.toString(viewgroup.charAt(0)).toUpperCase()).append(viewgroup.substring(1)).toString();
            a.setText((new StringBuilder()).append(viewgroup).append("'s ").append(c).append(" List").toString());
            a.setHint((new StringBuilder()).append(viewgroup).append("'s ").append(c).append(" List").toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onResume()
    {
        super.onResume();
        j = getArguments();
        ((HomeActivity)d).setSearchVisible(false);
        HomeActivity.inLifeEventsFragment = true;
        if (j != null)
        {
            i = j.getBoolean("isFromWishListSettings", false);
        }
        if (i)
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle("List Name");
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "Save", true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)getActivity()).updateActionBarTitle(getString(0x7f080339));
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
            return;
        }
    }
}
