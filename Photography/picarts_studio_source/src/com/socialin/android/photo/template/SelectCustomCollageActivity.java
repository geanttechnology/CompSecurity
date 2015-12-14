// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.photo.template:
//            g

public class SelectCustomCollageActivity extends AdBaseActivity
{

    private ViewPager a;

    public SelectCustomCollageActivity()
    {
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
        bundle = getSupportActionBar();
        bundle.setDisplayHomeAsUpEnabled(true);
        bundle.setBackgroundDrawable(getResources().getDrawable(0x7f0205b6));
        bundle.setTitle(0x7f080269);
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
            a.setAdapter(new g(getFragmentManager()));
        } else
        {
            setContentView(0x7f030067);
            Object obj = new g(getFragmentManager());
            bundle = ((g) (obj)).getItem(0);
            obj = ((g) (obj)).getItem(1);
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f100169, bundle);
            fragmenttransaction.add(0x7f100169, ((android.app.Fragment) (obj)));
            fragmenttransaction.commit();
        }
        initAd();
        if (getIntent() != null && a != null)
        {
            int j = getIntent().getIntExtra("screen", -1);
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
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        if (true) goto _L1; else goto _L3
_L3:
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
}
