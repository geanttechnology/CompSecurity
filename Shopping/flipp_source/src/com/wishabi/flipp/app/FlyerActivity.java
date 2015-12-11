// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.bd;
import android.support.v4.app.dd;
import android.support.v4.view.ae;
import android.support.v4.view.ch;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.wishabi.flipp.b.a;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

// Referenced classes of package com.wishabi.flipp.app:
//            bd, FlyerCarouselFragment, bb, bc, 
//            bm

public class FlyerActivity extends Activity
{

    private View a;
    private com.wishabi.flipp.content.Flyer.Model b;
    private Handler c;
    private SharedPreferences d;

    public FlyerActivity()
    {
    }

    static View a(FlyerActivity flyeractivity, View view)
    {
        flyeractivity.a = view;
        return view;
    }

    static com.wishabi.flipp.content.Flyer.Model a(FlyerActivity flyeractivity, com.wishabi.flipp.content.Flyer.Model model)
    {
        flyeractivity.b = model;
        return model;
    }

    private void a()
    {
        if (a != null)
        {
            a.clearAnimation();
            a.setVisibility(4);
        }
        if (c != null)
        {
            c.removeCallbacksAndMessages(null);
        }
    }

    static void a(FlyerActivity flyeractivity)
    {
        if (flyeractivity.b != null && flyeractivity.a != null)
        {
            if (!flyeractivity.b.p)
            {
                flyeractivity.a();
                return;
            }
            if ((flyeractivity.a.getAnimation() == null || flyeractivity.a.getAnimation().hasEnded()) && !flyeractivity.c.hasMessages(0))
            {
                flyeractivity.a.setVisibility(0);
                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation.setDuration(500L);
                flyeractivity.a.startAnimation(alphaanimation);
                flyeractivity.c.removeCallbacksAndMessages(null);
                flyeractivity.c.postDelayed(new com.wishabi.flipp.app.bd(flyeractivity), 3000L);
                return;
            }
        }
    }

    static View b(FlyerActivity flyeractivity)
    {
        View view = flyeractivity.getLayoutInflater().inflate(0x7f030052, null);
        float f = flyeractivity.getResources().getDisplayMetrics().density;
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams((int)(250F * f), -2);
        layoutparams.gravity = 53;
        layoutparams.rightMargin = (int)(6F * f);
        flyeractivity = flyeractivity.findViewById(0x7f0b00ab);
        int ai[] = new int[2];
        flyeractivity.getLocationInWindow(ai);
        layoutparams.topMargin = ai[1] - (int)(40F * f);
        int i = layoutparams.topMargin;
        layoutparams.topMargin = (int)(f * 10F) + i;
        view.setLayoutParams(layoutparams);
        return view;
    }

    static View c(FlyerActivity flyeractivity)
    {
        return flyeractivity.a;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f040000, 0x7f040003);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        bundle = (FlyerCarouselFragment)getFragmentManager().findFragmentById(0x7f0b001e);
        if (bundle != null)
        {
            bundle.b = new bb(this);
        }
        bundle = getActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
        }
        d = getSharedPreferences("com.wishabi.flipp.preferences", 0);
        if (getWindow() != null && getWindow().getDecorView() != null)
        {
            bundle = getWindow().getDecorView().getViewTreeObserver();
        } else
        {
            bundle = null;
        }
        if (bundle != null && !d.getBoolean("has_seen_select_pop", false))
        {
            bundle.addOnGlobalLayoutListener(new bc(this));
        }
        c = new Handler();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            if (bd.a(this, bd.a(this)))
            {
                dd.a(this).a(this).a();
                return true;
            } else
            {
                finish();
                overridePendingTransition(0x7f040000, 0x7f040003);
                return true;
            }

        case 2131427679: 
            break;
        }
        if (!d.getBoolean("has_seen_select_pop", false) && b != null && b.p)
        {
            d.edit().putBoolean("has_seen_select_pop", true).apply();
            a();
            a = null;
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onPause()
    {
        super.onPause();
        a.a.a();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        bundle = (FlyerCarouselFragment)getFragmentManager().findFragmentById(0x7f0b001e);
        if (bundle != null)
        {
            bundle.c = getIntent().getExtras();
            bundle.d = ((FlyerCarouselFragment) (bundle)).c.getParcelableArray("models");
            ((FlyerCarouselFragment) (bundle)).e.getAdapter().a.notifyChanged();
            int i = ((FlyerCarouselFragment) (bundle)).c.getInt("flyer_mode", -1);
            if (i != -1)
            {
                bundle.j = com.wishabi.flipp.app.bm.a()[i];
            }
            Object obj;
            int j;
            if (((FlyerCarouselFragment) (bundle)).i == null)
            {
                i = ((FlyerCarouselFragment) (bundle)).c.getInt("position");
            } else
            {
                i = ((FlyerCarouselFragment) (bundle)).i.intValue();
            }
            j = ((FlyerCarouselFragment) (bundle)).e.getCurrentItem();
            ((FlyerCarouselFragment) (bundle)).e.setCurrentItem(i);
            if (j == ((FlyerCarouselFragment) (bundle)).e.getCurrentItem())
            {
                ((FlyerCarouselFragment) (bundle)).a.a(i);
            }
            obj = (com.wishabi.flipp.content.Flyer.Model)((FlyerCarouselFragment) (bundle)).d[((FlyerCarouselFragment) (bundle)).e.getCurrentItem()];
            bundle.g = ((com.wishabi.flipp.content.Flyer.Model) (obj)).n;
            bundle.f = ((com.wishabi.flipp.content.Flyer.Model) (obj)).d;
            bundle.h = String.valueOf(((com.wishabi.flipp.content.Flyer.Model) (obj)).a);
            obj = bundle.getLoaderManager();
            if (obj != null)
            {
                ((LoaderManager) (obj)).initLoader(0, null, bundle);
            }
        }
    }

    protected void onResume()
    {
        super.onResume();
        a.a.a("flyerView");
    }

    protected void onStop()
    {
        super.onStop();
        a();
    }
}
