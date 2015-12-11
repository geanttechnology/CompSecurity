// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import nb;
import p;

public class MediumActivity extends Activity
{

    private int a;
    private String b;
    private String c;
    private nb d;

    public MediumActivity()
    {
        a = 0;
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        d = nb.a();
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            b = bundle.getString("mDotURL");
            c = bundle.getString("KEY_NAME");
        }
        if (b == null) goto _L2; else goto _L1
_L1:
        if (d.R())
        {
            bundle = new Intent(this, com/bestbuy/android/activities/mybby/MyBBYHomeActivity);
        } else
        {
            bundle = new Intent(this, com/bestbuy/android/activities/home/HomeActivity);
        }
        bundle.setAction("com.bestbuy.android.NOTIFICATION");
        bundle.putExtra("IS_CALLED_FROM_NOTIFICATION", true);
        bundle.putExtra("TAB_NAME", "ProductTab");
        bundle.addFlags(0x4000000);
        bundle.putExtra(getResources().getString(0x7f080055), b);
        if (!c.equalsIgnoreCase(getString(0x7f080388)) && !c.equalsIgnoreCase(getString(0x7f0802c1))) goto _L4; else goto _L3
_L3:
        bundle.putExtra("isDod", false);
_L6:
        startActivity(bundle);
_L2:
        finish();
        return;
_L4:
        if (c.equalsIgnoreCase(getString(0x7f08016f)))
        {
            bundle.putExtra("isDod", true);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        p.d(this);
    }

    protected void onPause()
    {
        super.onPause();
        p.g(this);
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    protected void onResume()
    {
        super.onResume();
        p.f(this);
    }

    protected void onStart()
    {
        super.onStart();
        p.b(this);
    }

    protected void onStop()
    {
        super.onStop();
        p.c(this);
    }
}
