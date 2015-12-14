// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.facebook.FacebookSdk;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.picsart.profile.fragment.ca;
import com.socialin.android.util.FileUtils;
import java.io.File;

public class WelcomeActivity extends BaseActivity
{

    private ca a;

    public WelcomeActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (FacebookSdk.isFacebookRequestCode(i))
        {
            a.onActivityResult(i, j, intent);
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
        bundle = getFragmentManager().beginTransaction();
        bundle.setTransition(8194);
        a = new ca();
        bundle.replace(0x7f1009c7, a, "welcome_fragmetn_tag");
        bundle.commit();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        FileUtils.a(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f08096d)).toString()));
    }

    public void onFragmentFinishWithResultOK(int i)
    {
        switch (i)
        {
        default:
            return;

        case 131: 
        case 150: 
        case 151: 
        case 163: 
            getIntent().putExtra("reloadPager", true);
            break;
        }
        setResult(-1, getIntent());
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem != null && menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
