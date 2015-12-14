// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.billing.d;
import java.util.Locale;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.shop:
//            o

public class ShopItemsListActivity extends BaseActivity
{

    private o a;

    public ShopItemsListActivity()
    {
        a = null;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (!m.a(this, getString(0x7f0808be)).handleActivityResult(i, j, intent))
        {
            super.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent intent = new Intent();
        boolean flag;
        if (a == null)
        {
            flag = true;
        } else
        {
            flag = a.d;
        }
        intent.putExtra("needUpdate", flag);
        setResult(-1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002a);
        bundle = getIntent().getStringExtra("selectedTag");
        Object obj = getIntent().getStringExtra("fromSource");
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ShopCategoryOpenEvent(bundle, ((String) (obj)), getResources().getConfiguration().locale.getCountry()));
        obj = getSupportFragmentManager();
        a = (o)((FragmentManager) (obj)).findFragmentByTag("shopItemsFragmentTag");
        if (a == null)
        {
            a = new o();
            Bundle bundle1 = new Bundle();
            bundle1.putString("price", "all");
            bundle1.putString("tag", bundle);
            a.setArguments(bundle1);
            a.setRetainInstance(true);
            ((FragmentManager) (obj)).beginTransaction().add(0x7f100187, a, "shopItemsFragmentTag").commit();
        } else
        if (a.isAdded())
        {
            ((FragmentManager) (obj)).beginTransaction().show(a).commit();
        } else
        {
            ((FragmentManager) (obj)).beginTransaction().add(0x7f100187, a, "shopItemsFragmentTag").commit();
        }
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle(bundle);
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
        a.a();
    }
}
