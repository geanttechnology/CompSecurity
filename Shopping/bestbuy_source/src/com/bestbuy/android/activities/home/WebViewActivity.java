// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;

public class WebViewActivity extends BBYBaseFragmentActivity
{

    private String a;

    public WebViewActivity()
    {
    }

    private void a(String s)
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        MdotWebFragment mdotwebfragment = new MdotWebFragment(false, false);
        Bundle bundle = new Bundle();
        bundle.putString("mDotURL", s);
        mdotwebfragment.setArguments(bundle);
        s = fragmentmanager.beginTransaction();
        s.add(0x7f0c0033, mdotwebfragment, "MdotWebFragment");
        s.commit();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            a = bundle.getString("com.bestbuy.android.URL_TOBE_LOADED");
            a(a);
        }
        getActionBar().hide();
        setContentView(0x7f030003);
    }
}
