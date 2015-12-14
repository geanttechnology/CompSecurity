// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.d;

// Referenced classes of package com.picsart.collages:
//            h

public class SelectCollageActivity extends AdBaseActivity
{

    private ViewPager a;
    private String b;

    public SelectCollageActivity()
    {
    }

    static String a(SelectCollageActivity selectcollageactivity)
    {
        return selectcollageactivity.b;
    }

    private boolean a()
    {
        if (a != null && a.getCurrentItem() == 1)
        {
            a.setCurrentItem(0);
            return true;
        } else
        {
            return false;
        }
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onBackPressed()
    {
        if (!a())
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        actionbar.setTitle(0x7f080269);
        int i = getWindowManager().getDefaultDisplay().getWidth();
        float f = (float)i / getResources().getDisplayMetrics().density;
        if (d.b)
        {
            (new StringBuilder("screenwidthDp:")).append(f).append(" screenWidthPx: ").append(i);
        }
        if (f < 450F || i < 600)
        {
            setContentView(0x7f030066);
            a = (ViewPager)findViewById(0x7f100169);
            int k = (int)(220F * getResources().getDisplayMetrics().density);
            a.setPageMargin(k - i);
            a.setAdapter(new h(this, getFragmentManager()));
        } else
        {
            setContentView(0x7f030067);
            Object obj = new h(this, getFragmentManager());
            android.app.Fragment fragment = ((h) (obj)).getItem(0);
            obj = ((h) (obj)).getItem(1);
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f100169, fragment);
            fragmenttransaction.add(0x7f100169, ((android.app.Fragment) (obj)));
            fragmenttransaction.commit();
        }
        initAd();
        if (getIntent() != null && a != null)
        {
            int j;
            if (bundle == null)
            {
                b = getIntent().getStringExtra("session_id");
            } else
            {
                b = bundle.getString("session_id");
            }
            j = getIntent().getIntExtra("screen", -1);
            if (j != -1)
            {
                a.setCurrentItem(j);
            }
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && i == 4)
        {
            a();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c && !a())
        {
            finish();
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistablebundle)
    {
        super.onSaveInstanceState(bundle, persistablebundle);
        bundle.putString("session_id", b);
    }
}
