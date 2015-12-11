// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.privacyandterms;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import nb;

public class PrivacyTermsFragment extends BBYBaseFragment
{

    private nb a;

    public PrivacyTermsFragment()
    {
    }

    static nb a(PrivacyTermsFragment privacytermsfragment)
    {
        return privacytermsfragment.a;
    }

    static void a(PrivacyTermsFragment privacytermsfragment, String s)
    {
        privacytermsfragment.a(s);
    }

    private void a(String s)
    {
        MdotWebFragment mdotwebfragment = new MdotWebFragment(false);
        Bundle bundle = new Bundle();
        bundle.putString("mDotURL", s);
        s = ((FragmentActivity)d).getSupportFragmentManager();
        mdotwebfragment.setArguments(bundle);
        s = s.beginTransaction();
        s.add(0x7f0c0033, mdotwebfragment, "MdotWebFragment");
        s.addToBackStack(null);
        s.commit();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        a = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300cb, viewgroup, false);
        viewgroup = new MdotWebFragment(false);
        bundle = new Bundle();
        bundle.putString("mDotURL", "file:///android_asset/tandc-android.html");
        viewgroup.setArguments(bundle);
        bundle = ((FragmentActivity)d).getSupportFragmentManager().beginTransaction();
        bundle.add(0x7f0c032c, viewgroup, "TermsFragment");
        bundle.commit();
        layoutinflater.findViewById(0x7f0c032b).setOnClickListener(new android.view.View.OnClickListener() {

            final PrivacyTermsFragment a;

            public void onClick(View view)
            {
                PrivacyTermsFragment.a(a, PrivacyTermsFragment.a(a).f());
            }

            
            {
                a = PrivacyTermsFragment.this;
                super();
            }
        });
        layoutinflater.findViewById(0x7f0c032a).setOnClickListener(new android.view.View.OnClickListener() {

            final PrivacyTermsFragment a;

            public void onClick(View view)
            {
                PrivacyTermsFragment.a(a, PrivacyTermsFragment.a(a).e());
            }

            
            {
                a = PrivacyTermsFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).showActionBarHome();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(a.T());
    }

    public void onResume()
    {
        super.onResume();
    }
}
