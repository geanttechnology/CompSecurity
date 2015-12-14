// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            c, b, a

public class IconPageIndicator extends HorizontalScrollView
    implements c
{

    private final b a;
    private ViewPager b;
    private android.support.v4.view.ViewPager.OnPageChangeListener c;
    private Runnable d;
    private int e;

    public IconPageIndicator(Context context)
    {
        this(context, null);
    }

    public IconPageIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setHorizontalScrollBarEnabled(false);
        a = new b(context, 0x7f01015c);
        addView(a, new android.widget.FrameLayout.LayoutParams(-2, -1, 17));
    }

    static Runnable a(IconPageIndicator iconpageindicator)
    {
        iconpageindicator.d = null;
        return null;
    }

    private void a()
    {
        a.removeAllViews();
        a a1 = (a)b.getAdapter();
        int j = a1.b();
        for (int i = 0; i < j; i++)
        {
            ImageView imageview = new ImageView(getContext(), null, 0x7f01015c);
            imageview.setImageResource(a1.a());
            a.addView(imageview);
        }

        if (e > j)
        {
            e = j - 1;
        }
        setCurrentItem(e);
        requestLayout();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (d != null)
        {
            post(d);
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (d != null)
        {
            removeCallbacks(d);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (c != null)
        {
            c.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (c != null)
        {
            c.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        setCurrentItem(i);
        if (c != null)
        {
            c.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i)
    {
        if (b == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        e = i;
        b.setCurrentItem(i);
        int k = a.getChildCount();
        int j = 0;
        while (j < k) 
        {
            View view = a.getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (!flag)
            {
                continue;
            }
            view = a.getChildAt(i);
            if (d != null)
            {
                removeCallbacks(d);
            }
            d = new Runnable(view) {

                private View a;
                private IconPageIndicator b;

                public final void run()
                {
                    int l = a.getLeft();
                    int i1 = (b.getWidth() - a.getWidth()) / 2;
                    b.smoothScrollTo(l - i1, 0);
                    IconPageIndicator.a(b);
                }

            
            {
                b = IconPageIndicator.this;
                a = view;
                super();
            }
            };
            post(d);
            j++;
        }
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        c = onpagechangelistener;
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (b == viewpager)
        {
            return;
        }
        if (b != null)
        {
            b.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            b = viewpager;
            viewpager.setOnPageChangeListener(this);
            a();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i)
    {
        setViewPager(viewpager);
        setCurrentItem(i);
    }
}
