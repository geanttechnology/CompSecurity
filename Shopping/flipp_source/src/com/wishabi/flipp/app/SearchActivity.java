// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.bd;
import android.support.v4.app.dd;
import android.view.MenuItem;

// Referenced classes of package com.wishabi.flipp.app:
//            dy, SearchFragment, en

public class SearchActivity extends Activity
{

    private SearchFragment a;
    private final BroadcastReceiver b = new dy(this);

    public SearchActivity()
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f040000, 0x7f040003);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        registerReceiver(b, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        registerReceiver(b, new IntentFilter("android.intent.action.TIME_SET"));
        registerReceiver(b, new IntentFilter("android.intent.action.DATE_CHANGED"));
        setContentView(0x7f030004);
        a = (SearchFragment)getFragmentManager().findFragmentById(0x7f0b002c);
        if (bundle == null)
        {
            bundle = getIntent().getBundleExtra("com.wishabi.flipp.search_bundle");
            if (bundle != null)
            {
                int i = bundle.getInt("search_mode", -1);
                if (i != -1)
                {
                    a.a(en.a()[i]);
                }
            }
            onNewIntent(getIntent());
        }
        if (a.b == en.b)
        {
            setTitle(a.a);
        } else
        {
            setTitle(0x7f0e011e);
        }
        bundle = getActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(b);
    }

    public void onNewIntent(Intent intent)
    {
        if (a != null && "android.intent.action.SEARCH".equals(intent.getAction()))
        {
            Bundle bundle = intent.getBundleExtra("com.wishabi.flipp.search_bundle");
            boolean flag2 = true;
            boolean flag1 = true;
            boolean flag = flag2;
            if (bundle != null)
            {
                int i = bundle.getInt("search_mode", -1);
                flag = flag2;
                if (i != -1)
                {
                    i = en.a()[i];
                    flag = flag1;
                    if (i == en.b)
                    {
                        flag = false;
                    }
                    a.a(i);
                }
            }
            a.a(intent.getStringExtra("query"), flag);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            menuitem = bd.a(this);
            if (android.os.Build.VERSION.SDK_INT >= 16 && bd.a(this, menuitem))
            {
                dd.a(this).a(this).a();
            } else
            {
                finish();
                overridePendingTransition(0x7f040000, 0x7f040003);
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
