// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import l;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity, SplashFragment

public class SplashActivity extends BBYBaseFragmentActivity
{

    private static final String a = com/bestbuy/android/activities/home/SplashActivity.getSimpleName();
    private nb b;

    public SplashActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        l.a("AD-AAB-AAB-GRA", getApplicationContext());
        lu.a(getApplicationContext());
        b = nb.a();
        if (b != null && !b.x())
        {
            startActivity(new Intent(this, com/bestbuy/android/activities/home/HomeActivity));
            finish();
            return;
        } else
        {
            setContentView(0x7f0300f4);
            bundle = new SplashFragment();
            getSupportFragmentManager().beginTransaction().add(0x7f0c0056, bundle).commit();
            return;
        }
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
