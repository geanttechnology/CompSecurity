// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.billing.d;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.shop:
//            h, b

public class ShopActivity extends BaseActivity
{

    private h a;
    private ActionBar b;
    private TextView c;
    private b d;
    private GoogleApiClient e;

    public ShopActivity()
    {
        a = null;
    }

    static h a(ShopActivity shopactivity)
    {
        return shopactivity.a;
    }

    public final void a(int i)
    {
        b.setBackgroundDrawable(new ColorDrawable(Color.argb(i, 29, 29, 29)));
        c.setTextColor(Color.argb(i, 255, 255, 255));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (!m.a(this, getString(0x7f0808be)).handleActivityResult(i, j, intent))
        {
            super.onActivityResult(i, j, intent);
        }
        if (a != null)
        {
            a.onActivityResult(i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        getWindow().requestFeature(9);
        super.onCreate(bundle);
        setContentView(0x7f030028);
        c = (TextView)findViewById(0x7f100185);
        setSupportActionBar((Toolbar)findViewById(0x7f10017b));
        b = getSupportActionBar();
        a(0);
        c.setText(0x7f08034b);
        b.setTitle("");
        bundle = getSupportFragmentManager();
        a = (h)getSupportFragmentManager().findFragmentByTag("shopFragmentTag");
        if (a != null) goto _L2; else goto _L1
_L1:
        a = new h();
        bundle.beginTransaction().add(0x7f10013a, a, "shopFragmentTag").commit();
_L4:
        bundle = findViewById(0x7f10017b);
        bundle.measure(0, 0);
        a.a = bundle.getMeasuredHeight();
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.ShopOpenEvent(m.a(getIntent(), "from")));
        SwyftAnalytics.getInstance().createTrackEvent("shop_open").track();
        d = new b(this, (byte)0);
        registerReceiver(d, new IntentFilter("update.adds.enabled.action"));
        e = m.a(this);
        return;
_L2:
        if (a.isAdded())
        {
            if (!a.isVisible())
            {
                bundle.beginTransaction().show(a).commitAllowingStateLoss();
            }
        } else
        {
            bundle.beginTransaction().add(0x7f10013a, a, "shopFragmentTag").commit();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        b.setDisplayShowHomeEnabled(false);
        b.setDisplayHomeAsUpEnabled(true);
        b.setDisplayUseLogoEnabled(false);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (d != null)
        {
            unregisterReceiver(d);
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

    protected void onStart()
    {
        super.onStart();
        e.connect();
        m.a(e, "http://schema.org/ViewAction", getString(0x7f08058d), "android-app://com.picsart.studio/picsart/shop");
    }

    protected void onStop()
    {
        super.onStop();
        m.b(e, "http://schema.org/ViewAction", getString(0x7f08058d), "android-app://com.picsart.studio/picsart/shop");
        e.disconnect();
    }
}
