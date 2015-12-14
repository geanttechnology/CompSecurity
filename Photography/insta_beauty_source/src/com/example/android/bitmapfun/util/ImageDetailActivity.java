// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import aaj;
import aef;
import aeh;
import aei;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import gp;
import gq;
import java.util.ArrayList;
import zr;
import zt;

public abstract class ImageDetailActivity extends FragmentActivity
    implements android.view.View.OnClickListener
{

    private gq a;
    private zt b;
    private ViewPager c;
    private ArrayList d;

    public ImageDetailActivity()
    {
    }

    public static ArrayList a(ImageDetailActivity imagedetailactivity)
    {
        return imagedetailactivity.d;
    }

    protected abstract zt a();

    public zt b()
    {
        return b;
    }

    public void onClick(View view)
    {
        if ((c.getSystemUiVisibility() & 1) != 0)
        {
            c.setSystemUiVisibility(0);
            return;
        } else
        {
            c.setSystemUiVisibility(1);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(aei.image_detail_pager);
        bundle = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(bundle);
        int i = ((DisplayMetrics) (bundle)).heightPixels;
        int j = ((DisplayMetrics) (bundle)).widthPixels;
        if (i <= j)
        {
            i = j;
        }
        i /= 2;
        (new zr(this, "images")).a(0.05F);
        b = a();
        i = getIntent().getIntExtra("extra_image", -1);
        d = getIntent().getStringArrayListExtra("android.intent.extra.STREAM");
        if (i != -1 && d != null && d.size() < i)
        {
            i = d.size() - 1;
        }
        a = new gq(this, getSupportFragmentManager());
        c = (ViewPager)findViewById(aeh.pager);
        c.setAdapter(a);
        c.setPageMargin((int)getResources().getDimension(aef.image_detail_pager_margin));
        c.setOffscreenPageLimit(1);
        c.setCurrentItem(i);
        getWindow().addFlags(1024);
        if (aaj.c())
        {
            bundle = getActionBar();
            bundle.setDisplayShowTitleEnabled(false);
            bundle.setDisplayHomeAsUpEnabled(true);
            c.setOnSystemUiVisibilityChangeListener(new gp(this, bundle));
            c.setSystemUiVisibility(1);
            bundle.hide();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        b.j();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            finish();
            break;
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        b.a(true);
        b.i();
    }

    public void onResume()
    {
        super.onResume();
        b.a(false);
    }
}
