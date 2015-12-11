// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bb;
import android.support.v4.view.co;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.views:
//            g, d, e, f

public class SlidingTabLayout extends HorizontalScrollView
{

    private int a;
    private boolean b;
    private ViewPager c;
    private SparseArray d;
    private co e;
    private final g f;

    public SlidingTabLayout(Context context)
    {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d = new SparseArray();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        a = (int)(24F * getResources().getDisplayMetrics().density);
        f = new g(context);
        addView(f, -1, -2);
    }

    static g a(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.f;
    }

    private void a(int i, int j)
    {
        int k = f.getChildCount();
        View view;
        if (k != 0 && i >= 0 && i < k)
        {
            if ((view = f.getChildAt(i)) != null)
            {
label0:
                {
                    int l = view.getLeft() + j;
                    if (i <= 0)
                    {
                        i = l;
                        if (j <= 0)
                        {
                            break label0;
                        }
                    }
                    i = l - a;
                }
                scrollTo(i, 0);
                return;
            }
        }
    }

    static void a(SlidingTabLayout slidingtablayout, int i, int j)
    {
        slidingtablayout.a(i, j);
    }

    static co b(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.e;
    }

    static ViewPager c(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.c;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (c != null)
        {
            a(c.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(f f1)
    {
        f.setCustomTabColorizer(f1);
    }

    public void setDistributeEvenly(boolean flag)
    {
        b = flag;
    }

    public void setOnPageChangeListener(co co)
    {
        e = co;
    }

    public transient void setSelectedIndicatorColors(int ai[])
    {
        f.setSelectedIndicatorColors(ai);
    }

    public void setViewPager(ViewPager viewpager)
    {
        f.removeAllViews();
        c = viewpager;
        if (viewpager != null)
        {
            viewpager.setOnPageChangeListener(new d(this, (byte)0));
            bb bb1 = c.getAdapter();
            e e1 = new e(this, (byte)0);
            int i = 0;
            while (i < bb1.b()) 
            {
                TextView textview = new TextView(getContext());
                textview.setGravity(17);
                textview.setTextSize(2, 16F);
                textview.setTypeface(Typeface.DEFAULT_BOLD);
                textview.setTextColor(getResources().getColor(0x7f0e0112));
                textview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
                viewpager = new TypedValue();
                getContext().getTheme().resolveAttribute(0x101030e, viewpager, true);
                textview.setBackgroundResource(((TypedValue) (viewpager)).resourceId);
                int j = (int)(13F * getResources().getDisplayMetrics().density);
                textview.setPadding(j, j, j, j);
                if (android/widget/TextView.isInstance(textview))
                {
                    viewpager = (TextView)textview;
                } else
                {
                    viewpager = null;
                }
                if (b)
                {
                    android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)textview.getLayoutParams();
                    layoutparams.width = 0;
                    layoutparams.weight = 1.0F;
                }
                viewpager.setText(bb1.b(i));
                textview.setOnClickListener(e1);
                viewpager = (String)d.get(i, null);
                if (viewpager != null)
                {
                    textview.setContentDescription(viewpager);
                }
                f.addView(textview);
                if (i == c.getCurrentItem())
                {
                    textview.setSelected(true);
                }
                i++;
            }
        }
    }
}
