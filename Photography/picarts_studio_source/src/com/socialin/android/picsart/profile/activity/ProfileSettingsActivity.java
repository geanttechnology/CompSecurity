// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.fragment.ay;
import com.socialin.android.util.FileUtils;
import java.io.File;
import myobfuscated.cy.b;

public class ProfileSettingsActivity extends BaseActivity
{

    private g a;
    private ay b;
    private FragmentManager c;

    public ProfileSettingsActivity()
    {
    }

    private void a()
    {
        FragmentTransaction fragmenttransaction = c.beginTransaction();
        b = new ay();
        fragmenttransaction.replace(0x1020002, b);
        fragmenttransaction.commit();
    }

    public void dismissFragmentProgressDialog()
    {
        FragmentTransaction fragmenttransaction;
        Fragment fragment;
        try
        {
            fragmenttransaction = c.beginTransaction();
            fragment = c.findFragmentByTag("fragmentProgressDialog");
        }
        catch (Exception exception)
        {
            d.a("ProfileSettings", exception);
            return;
        }
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (fragment.isAdded() && !fragment.isRemoving() && !isFinishing())
        {
            fragmenttransaction.remove(fragment);
        }
        fragmenttransaction.commitAllowingStateLoss();
        return;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (b != null)
        {
            b.a(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = new g(this);
        a.setMessage(getString(0x7f08043d));
        a.setCancelable(true);
        c = getFragmentManager();
        bundle = getSupportActionBar();
        bundle.setTitle(0x7f080534);
        bundle.setDisplayHomeAsUpEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            bundle.setDisplayShowHomeEnabled(false);
        }
        a();
        AnalyticUtils.getInstance(this).trackLocalAction("profile_settings:onCreate");
    }

    protected void onDestroy()
    {
        super.onDestroy();
        FileUtils.a(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096d)).toString()));
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        if (i == 120)
        {
            Intent intent = new Intent();
            intent.setFlags(0x24000000);
            intent.putExtra("logout", true);
            setResult(-1, intent);
            finish();
        }
    }

    public void onInstagramTokenResult()
    {
        a();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            boolean flag;
            if (b != null && b.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            boolean flag;
            if (b != null && b.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                finish();
            }
        }
        return true;
    }

    public void showFragmentNoNetworkDialog()
    {
        DialogUtils.showNoNetworkDialogFragment(this, "dialog");
    }

    public void showFragmentProgressDialog(String s, String s1, boolean flag)
    {
        FragmentTransaction fragmenttransaction;
        Fragment fragment;
        fragmenttransaction = c.beginTransaction();
        fragment = c.findFragmentByTag("fragmentProgressDialog");
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (fragment.isAdded() && !fragment.isRemoving() && !isFinishing())
        {
            if (!fragment.isVisible())
            {
                ((DialogFragment)fragment).show(c, "fragmentProgressDialog");
                return;
            }
            break MISSING_BLOCK_LABEL_115;
        }
        try
        {
            s = myobfuscated.cy.b.a(s, s1);
            s.onCancel(a);
            s.setCancelable(flag);
            s.show(c, "fragmentProgressDialog");
            fragmenttransaction.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d.a("ProfileSettings", s);
        }
    }
}
