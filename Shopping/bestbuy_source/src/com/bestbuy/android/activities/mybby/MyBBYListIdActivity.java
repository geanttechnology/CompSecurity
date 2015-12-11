// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.activities.registry.ListIdModalFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import lu;
import nb;

public class MyBBYListIdActivity extends BBYBaseFragmentActivity
{

    private String a;
    private nb b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;

    public MyBBYListIdActivity()
    {
    }

    public void onBackPressed()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 1)
        {
            fragmentmanager.popBackStack();
        } else
        {
            setResult(0);
        }
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030101);
        b = nb.a();
        b.i(true);
        getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00385f));
        getActionBar().setTitle("");
        getActionBar().setDisplayShowHomeEnabled(false);
        bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("FragmentName"))
        {
            a = bundle.getString("FragmentName");
            c = bundle.getString("uuid");
            d = bundle.getString("retailListAlias");
            e = bundle.getString("listName");
            f = bundle.getString("listType");
            g = bundle.getBoolean("isRegistryValue");
        }
        bundle = getSupportFragmentManager().beginTransaction();
        if (a == null || a.equals("ListIdModalFragment"))
        {
            ListIdModalFragment listidmodalfragment = new ListIdModalFragment(f, c, d);
            getActionBar().hide();
            bundle.add(0x7f0c0182, listidmodalfragment, "ListIdModalFragment");
            bundle.addToBackStack(null);
            bundle.commit();
        } else
        if (a != null && a.equals("AddItemsToPLPFragment"))
        {
            return;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        b.i(false);
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
