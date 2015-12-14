// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.widgetpool.common.IndicatorView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            n, o

public class OpeningTutorialActivity extends BaseActivity
{

    private int a;
    private ViewPager b;
    private View c;
    private View d;
    private View e;
    private o f;

    public OpeningTutorialActivity()
    {
        a = 0;
    }

    static int a(OpeningTutorialActivity openingtutorialactivity, int i)
    {
        openingtutorialactivity.a = i;
        return i;
    }

    static ViewPager a(OpeningTutorialActivity openingtutorialactivity)
    {
        return openingtutorialactivity.b;
    }

    static void a(OpeningTutorialActivity openingtutorialactivity, IndicatorView indicatorview)
    {
        openingtutorialactivity.a(indicatorview);
    }

    static void a(OpeningTutorialActivity openingtutorialactivity, boolean flag)
    {
        openingtutorialactivity.b(flag);
    }

    private void a(IndicatorView indicatorview)
    {
        indicatorview.setVisibility(8);
    }

    private void a(IndicatorView indicatorview, int i)
    {
        indicatorview.setCount(i);
        indicatorview.setIndex(0);
        float f1 = TypedValue.applyDimension(1, 8F, getResources().getDisplayMetrics());
        indicatorview.a((int)(2.25F * f1), 0);
        android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f0208b6);
        android.graphics.drawable.Drawable drawable1 = getResources().getDrawable(0x7f0208b7);
        indicatorview.a(drawable, f1, f1, 0);
        indicatorview.b(drawable1, f1, f1, 0);
    }

    static o b(OpeningTutorialActivity openingtutorialactivity)
    {
        return openingtutorialactivity.f;
    }

    static void b(OpeningTutorialActivity openingtutorialactivity, IndicatorView indicatorview)
    {
        openingtutorialactivity.b(indicatorview);
    }

    private void b(IndicatorView indicatorview)
    {
        if (!indicatorview.isShown())
        {
            indicatorview.setVisibility(0);
        }
    }

    private void b(boolean flag)
    {
        if (c == null || d == null)
        {
            return;
        }
        if (flag)
        {
            c.setVisibility(4);
            d.setVisibility(4);
            return;
        }
        int i = b.getAdapter().getCount();
        int j = a;
        if (i <= 1)
        {
            c.setVisibility(4);
            d.setVisibility(4);
            return;
        }
        if (j <= 0)
        {
            c.setVisibility(4);
            d.setVisibility(0);
            return;
        }
        if (j >= i - 1)
        {
            c.setVisibility(0);
            d.setVisibility(4);
            return;
        } else
        {
            c.setVisibility(0);
            d.setVisibility(0);
            return;
        }
    }

    static View c(OpeningTutorialActivity openingtutorialactivity)
    {
        return openingtutorialactivity.c;
    }

    static int d(OpeningTutorialActivity openingtutorialactivity)
    {
        return openingtutorialactivity.a;
    }

    static View e(OpeningTutorialActivity openingtutorialactivity)
    {
        return openingtutorialactivity.d;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        bundle = new n(this);
        b = (ViewPager)findViewById(0x7f0c017b);
        IndicatorView indicatorview = (IndicatorView)findViewById(0x7f0c017f);
        int i = bundle.getCount();
        a(indicatorview, i);
        b.setAdapter(bundle);
        b.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener(indicatorview, i) {

            final IndicatorView a;
            final int b;
            final OpeningTutorialActivity c;

            public void onPageScrollStateChanged(int j)
            {
                if (j == 0 || j == 2)
                {
                    OpeningTutorialActivity.a(c, false);
                }
            }

            public void onPageScrolled(int j, float f1, int k)
            {
                OpeningTutorialActivity.a(c, false);
            }

            public void onPageSelected(int j)
            {
                OpeningTutorialActivity.a(c, j);
                a.setIndex(j);
                if (j == b - 1)
                {
                    OpeningTutorialActivity.a(c, a);
                    return;
                } else
                {
                    OpeningTutorialActivity.b(c, a);
                    return;
                }
            }

            
            {
                c = OpeningTutorialActivity.this;
                a = indicatorview;
                b = i;
                super();
            }
        });
        c = findViewById(0x7f0c017d);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final OpeningTutorialActivity a;

            public void onClick(View view)
            {
                view = OpeningTutorialActivity.a(a);
                view.setCurrentItem(view.getCurrentItem() - 1, true);
            }

            
            {
                a = OpeningTutorialActivity.this;
                super();
            }
        });
        d = findViewById(0x7f0c017e);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final OpeningTutorialActivity a;

            public void onClick(View view)
            {
                view = OpeningTutorialActivity.a(a);
                view.setCurrentItem(view.getCurrentItem() + 1, true);
            }

            
            {
                a = OpeningTutorialActivity.this;
                super();
            }
        });
        f = new o(this);
        e = findViewById(0x7f0c017c);
        e.setOnTouchListener(f);
        z.a("HAD_SHOWN_OPENING_TUTORIAL_V4.13.0", Boolean.valueOf(true), getApplicationContext());
    }

    protected void onPause()
    {
        Globals.d().c("openingTutorial");
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Globals.d().c(null);
    }
}
