// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.facebook.appevents.AppEventsLogger;
import com.firegnom.rat.util.DialogUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.fragment.ao;
import myobfuscated.cy.b;
import myobfuscated.f.m;

public class LoginFragmentActivity extends BaseActivity
{

    private static final String a = com/socialin/android/picsart/profile/activity/LoginFragmentActivity.getSimpleName();
    private g b;
    private GoogleApiClient c;

    public LoginFragmentActivity()
    {
    }

    private void a()
    {
        getIntent().putExtra("reloadPager", true);
        setResult(-1, getIntent());
        finish();
    }

    public void dismissFragmentProgressDialog()
    {
        FragmentTransaction fragmenttransaction;
        Object obj;
        try
        {
            obj = getFragmentManager();
            fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
            obj = ((FragmentManager) (obj)).findFragmentByTag("fragmentProgressDialog");
        }
        catch (Exception exception)
        {
            d.a(a, exception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (((Fragment) (obj)).isAdded() && !((Fragment) (obj)).isRemoving() && !isFinishing())
        {
            fragmenttransaction.remove(((Fragment) (obj)));
        }
        fragmenttransaction.commitAllowingStateLoss();
        return;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && (i == 122 || i == 151))
        {
            a();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = getFragmentManager().findFragmentByTag("fragmentLoginTag");
        if (configuration != null && (configuration instanceof ao))
        {
            ((ao)configuration).a();
        }
    }

    protected void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            bundle = getSupportActionBar();
            if (bundle != null)
            {
                bundle.setDisplayHomeAsUpEnabled(true);
                bundle.setDisplayShowHomeEnabled(true);
            }
            setContentView(0x7f030212);
            b = new g(self);
            b.setMessage(getString(0x7f080450));
            b.setCancelable(true);
            Object obj = getFragmentManager();
            bundle = ((FragmentManager) (obj)).beginTransaction();
            Object obj1 = ((FragmentManager) (obj)).findFragmentByTag("fragmentLoginTag");
            obj = new Bundle();
            String s;
            if (obj1 != null && ((Fragment) (obj1)).isAdded() && !((Fragment) (obj1)).isRemoving() && !isFinishing())
            {
                bundle.show(((Fragment) (obj1)));
            } else
            {
                ao ao1 = new ao();
                ((Bundle) (obj)).putString("invite_mode", getIntent().getStringExtra("invite_mode"));
                ao1.setArguments(((Bundle) (obj)));
                bundle.add(0x7f1009a6, ao1, "fragmentLoginTag");
            }
            bundle.commitAllowingStateLoss();
            getIntent().putExtra("reloadPager", false);
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.SignInOpenEvent(m.a(getIntent(), "from")));
            AnalyticUtils.getInstance(this).trackLocalAction("SIGNIN:onCreate");
            s = getIntent().getStringExtra("invite_mode");
            obj1 = "";
            if (getIntent().hasExtra("from"))
            {
                bundle = getIntent().getStringExtra("from");
            } else
            {
                bundle = "";
            }
            obj = obj1;
            if (s == null)
            {
                break label0;
            }
            if (!com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER.name().equals(s))
            {
                obj = obj1;
                if (!com.socialin.android.constants.CommonConstants.InviteMode.AD_REMOVER_AUTO.name().equals(s))
                {
                    break label0;
                }
            }
            obj = "ad_remover";
        }
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.LoginPageOpenEvent(bundle.toLowerCase(), ((String) (obj))));
        c = m.a(this);
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        if (i == 150 || i == 131 || i == 151)
        {
            a();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            AppEventsLogger.activateApp(this);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            d.a(a, illegalargumentexception);
        }
    }

    protected void onStart()
    {
        super.onStart();
        c.connect();
        m.a(c, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
    }

    protected void onStop()
    {
        super.onStop();
        m.b(c, "http://schema.org/ViewAction", getString(0x7f0803df), "android-app://com.picsart.studio/picsart/login");
        c.disconnect();
    }

    public void showFragmentNoNetworkDialog()
    {
        DialogUtils.showNoNetworkDialogFragment(this, "dialog");
    }

    public void showFragmentProgressDialog(String s, String s1, boolean flag)
    {
        FragmentManager fragmentmanager;
        FragmentTransaction fragmenttransaction;
        Fragment fragment;
        fragmentmanager = getFragmentManager();
        fragmenttransaction = fragmentmanager.beginTransaction();
        fragment = fragmentmanager.findFragmentByTag("fragmentProgressDialog");
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (fragment.isAdded() && !fragment.isRemoving() && !isFinishing())
        {
            if (!fragment.isVisible())
            {
                ((DialogFragment)fragment).show(fragmentmanager, "fragmentProgressDialog");
                return;
            }
            break MISSING_BLOCK_LABEL_114;
        }
        try
        {
            s = myobfuscated.cy.b.a(s, s1);
            s.onCancel(b);
            s.setCancelable(flag);
            s.show(fragmentmanager, "fragmentProgressDialog");
            fragmenttransaction.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d.a(a, s);
        }
    }

}
