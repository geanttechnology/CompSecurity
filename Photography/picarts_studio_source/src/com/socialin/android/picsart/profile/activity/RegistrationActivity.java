// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.fragment.ba;
import com.socialin.android.util.b;

public class RegistrationActivity extends BaseActivity
{

    public RegistrationActivity()
    {
    }

    private void a()
    {
        ba ba1 = (ba)getFragmentManager().findFragmentByTag("registration_fragment");
        if (ba1 != null)
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.RegistrationStepEvent("reg_click_back", ba1.c(), ba1.e(), ba1.d(), ba1.f(), false));
            b.a(this).a("reg_click_back", ba1.c(), ba1.e(), ba1.d(), ba1.f(), false);
        }
    }

    public void onBackPressed()
    {
        a();
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getFragmentManager().findFragmentByTag("registration_fragment");
        if (configuration != null && (configuration instanceof ba))
        {
            ((ba)configuration).b();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03021b);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setTitle(getString(0x7f080333));
            bundle.setDisplayShowHomeEnabled(false);
            bundle.setDisplayHomeAsUpEnabled(true);
        }
        if (getIntent().hasExtra("args"))
        {
            getIntent().getBundleExtra("args");
        }
        bundle = getFragmentManager().beginTransaction();
        bundle.setTransition(8194);
        if ((ba)getFragmentManager().findFragmentByTag("registration_fragment") == null)
        {
            ba ba1 = new ba();
            ba1.setRetainInstance(true);
            Bundle bundle1 = new Bundle();
            bundle1.putString("invite_mode", getIntent().getStringExtra("invite_mode"));
            ba1.setArguments(bundle1);
            bundle.add(0x7f1009c7, ba1, "registration_fragment");
        }
        bundle.commit();
        AnalyticUtils.getInstance(this).trackLocalAction("signup:onCreate");
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        if (i == 152 || i == 151)
        {
            getIntent().putExtra("reloadPager", true);
            setResult(-1, getIntent());
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem != null && menuitem.getItemId() == 0x102002c)
        {
            a();
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
