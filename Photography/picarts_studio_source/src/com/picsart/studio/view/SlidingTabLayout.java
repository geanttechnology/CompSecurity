// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view:
//            SlidingTabStrip, h, g, i

public class SlidingTabLayout extends HorizontalScrollView
{

    private int a;
    private ViewPager b;
    private android.support.v4.view.ViewPager.OnPageChangeListener c;
    private final SlidingTabStrip d;

    public SlidingTabLayout(Context context)
    {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01009e);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset, int j)
    {
        TypedArray typedarray;
        super(context, attributeset, j);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        a = (int)(24F * getResources().getDisplayMetrics().density);
        d = new SlidingTabStrip(context);
        addView(d, -1, -2);
        typedarray = context.getTheme().obtainStyledAttributes(attributeset, a.SlidingTabLayout, j, 0);
        if (typedarray.hasValue(a.SlidingTabLayout_tabIndicator))
        {
            Drawable drawable = typedarray.getDrawable(a.SlidingTabLayout_tabIndicator);
            attributeset = drawable;
            if (drawable == null)
            {
                attributeset = new ColorDrawable(typedarray.getColor(a.SlidingTabLayout_tabIndicator, context.getResources().getColor(0x7f0f0039)));
            }
            d.a(attributeset);
        }
        if (typedarray.hasValue(a.SlidingTabLayout_tabDivider))
        {
            Drawable drawable1 = typedarray.getDrawable(a.SlidingTabLayout_tabDivider);
            attributeset = drawable1;
            if (drawable1 == null)
            {
                attributeset = new ColorDrawable(typedarray.getColor(a.SlidingTabLayout_tabDivider, context.getResources().getColor(0x7f0f002e)));
            }
            d.setDividerDrawable(attributeset);
        }
        if (typedarray.hasValue(a.SlidingTabLayout_bottomBorder))
        {
            attributeset = typedarray.getDrawable(a.SlidingTabLayout_bottomBorder);
            context = attributeset;
            if (attributeset == null)
            {
                context = new ColorDrawable(typedarray.getColor(a.SlidingTabLayout_bottomBorder, -1));
            }
            attributeset = d;
            attributeset.a = context;
            attributeset.invalidate();
        }
        if (typedarray.hasValue(a.SlidingTabLayout_dividerHeight))
        {
            float f = typedarray.getFraction(a.SlidingTabLayout_dividerHeight, 1, 1, 1.0F);
            context = d;
            context.b = f;
            context.invalidate();
        }
        if (!typedarray.hasValue(a.SlidingTabLayout_indicatorPosition)) goto _L2; else goto _L1
_L1:
        context = null;
        typedarray.getInt(a.SlidingTabLayout_indicatorPosition, 0);
        JVM INSTR tableswitch 0 1: default 336
    //                   0 356
    //                   1 363;
           goto _L3 _L4 _L5
_L3:
        attributeset = d;
        attributeset.c = context;
        attributeset.invalidate();
_L2:
        typedarray.recycle();
        return;
_L4:
        context = SlidingTabStrip.IndicatorPosition.TOP;
        continue; /* Loop/switch isn't completed */
_L5:
        context = SlidingTabStrip.IndicatorPosition.BOTTOM;
        if (true) goto _L3; else goto _L6
_L6:
    }

    static SlidingTabStrip a(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.d;
    }

    private void a(int j, int k)
    {
        int l = d.getChildCount();
        View view;
        if (l != 0 && j >= 0 && j < l)
        {
            if ((view = d.getChildAt(j)) != null)
            {
label0:
                {
                    int i1 = view.getLeft() + k;
                    if (j <= 0)
                    {
                        j = i1;
                        if (k <= 0)
                        {
                            break label0;
                        }
                    }
                    j = i1 - a;
                }
                scrollTo(j, 0);
                return;
            }
        }
    }

    static void a(SlidingTabLayout slidingtablayout, int j, int k)
    {
        slidingtablayout.a(j, k);
    }

    static android.support.v4.view.ViewPager.OnPageChangeListener b(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.c;
    }

    static ViewPager c(SlidingTabLayout slidingtablayout)
    {
        return slidingtablayout.b;
    }

    public final View a(int j)
    {
        int k = d.getChildCount();
        if (k == 0 || j < 0 || j >= k)
        {
            return null;
        } else
        {
            return d.getChildAt(j);
        }
    }

    public final View a(Object obj)
    {
        return d.findViewWithTag(obj);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (b != null)
        {
            a(b.getCurrentItem(), 0);
        }
    }

    public void setDividerDrawable(Drawable drawable)
    {
        d.setDividerDrawable(drawable);
    }

    public void setDividerResource(int j)
    {
        SlidingTabStrip slidingtabstrip = d;
        Drawable drawable = null;
        if (j != 0)
        {
            drawable = slidingtabstrip.getResources().getDrawable(j);
        }
        slidingtabstrip.setDividerDrawable(drawable);
    }

    public void setIndicatorDrawable(Drawable drawable)
    {
        d.a(drawable);
    }

    public void setIndicatorResource(int j)
    {
        SlidingTabStrip slidingtabstrip = d;
        Drawable drawable = null;
        if (j != 0)
        {
            drawable = slidingtabstrip.getResources().getDrawable(j);
        }
        slidingtabstrip.a(drawable);
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        c = onpagechangelistener;
    }

    public void setViewPager(ViewPager viewpager)
    {
        int k = 0;
        d.removeAllViews();
        b = viewpager;
        if (viewpager != null)
        {
            viewpager.setOnPageChangeListener(new h(this, (byte)0));
            if (!(b.getAdapter() instanceof g))
            {
                throw new IllegalStateException((new StringBuilder("The adapter has to be of type ")).append(com/picsart/studio/view/g.getSimpleName()).toString());
            }
            g g1 = (g)b.getAdapter();
            i j = new i(this, (byte)0);
            for (; k < g1.getCount(); k++)
            {
                View view = g1.a(k, d);
                viewpager = view;
                if (view == null)
                {
                    viewpager = getContext();
                    Object obj = g1.c(k);
                    viewpager = new TextView(viewpager);
                    viewpager.setGravity(17);
                    viewpager.setTextSize(2, 12F);
                    viewpager.setTypeface(Typeface.DEFAULT_BOLD);
                    viewpager.setTextColor(getResources().getColor(0x7f0206eb));
                    viewpager.setText(((CharSequence) (obj)));
                    obj = new TypedValue();
                    getContext().getTheme().resolveAttribute(0x101030e, ((TypedValue) (obj)), true);
                    viewpager.setBackgroundResource(((TypedValue) (obj)).resourceId);
                    viewpager.setAllCaps(true);
                    int l = (int)(16F * getResources().getDisplayMetrics().density);
                    viewpager.setPadding(l, l, l, l);
                }
                viewpager.setOnClickListener(j);
                d.addView(viewpager, k);
            }

        }
    }
}
