// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;
import nb;

public class MyBBYResetPasswordActivity extends BBYBaseFragmentActivity
{

    private nb a;

    public MyBBYResetPasswordActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setHomeAsUpIndicator(0x7f020002);
        getActionBar().setTitle("");
        a = nb.a();
        a.c("Foreground");
        bundle = new MdotWebFragment(false);
        Object obj = new Bundle();
        ((Bundle) (obj)).putString(getResources().getString(0x7f080055), a.k());
        bundle.setArguments(((Bundle) (obj)));
        obj = getSupportFragmentManager().beginTransaction();
        ((FragmentTransaction) (obj)).add(0x7f0c0182, bundle, "MdotWebFragment");
        ((FragmentTransaction) (obj)).addToBackStack(null);
        ((FragmentTransaction) (obj)).commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            break;
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            return super.onOptionsItemSelected(menuitem);
        }
        menuitem = getSupportFragmentManager().findFragmentById(0x7f0c0182);
        if (menuitem instanceof MdotWebFragment)
        {
            menuitem = (MdotWebFragment)menuitem;
            if (menuitem.d())
            {
                menuitem.e();
            } else
            {
                finish();
            }
        } else
        {
            finish();
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        lu.a();
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
    }
}
