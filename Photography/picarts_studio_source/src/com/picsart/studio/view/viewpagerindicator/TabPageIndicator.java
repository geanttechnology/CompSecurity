// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.melnykov.fab.a;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            c, b, a, d

public class TabPageIndicator extends HorizontalScrollView
    implements c
{

    private static final CharSequence a = "";
    private Runnable b;
    private final android.view.View.OnClickListener c;
    private final b d;
    private ViewPager e;
    private android.support.v4.view.ViewPager.OnPageChangeListener f;
    private int g;
    private int h;

    public TabPageIndicator(Context context)
    {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = new android.view.View.OnClickListener() {

            private TabPageIndicator a;

            public final void onClick(View view)
            {
                view = (d)view;
                com.picsart.studio.view.viewpagerindicator.TabPageIndicator.a(a).getCurrentItem();
                int i = ((d) (view)).a;
                com.picsart.studio.view.viewpagerindicator.TabPageIndicator.a(a).setCurrentItem(i);
            }

            
            {
                a = TabPageIndicator.this;
                super();
            }
        };
        setHorizontalScrollBarEnabled(false);
        d = new b(context, 0x7f01015f);
        addView(d, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    static ViewPager a(TabPageIndicator tabpageindicator)
    {
        return tabpageindicator.e;
    }

    private void a()
    {
        d.removeAllViews();
        PagerAdapter pageradapter = e.getAdapter();
        com.picsart.studio.view.viewpagerindicator.a a1 = null;
        if (pageradapter instanceof com.picsart.studio.view.viewpagerindicator.a)
        {
            a1 = (com.picsart.studio.view.viewpagerindicator.a)pageradapter;
        }
        int k = pageradapter.getCount();
        int i = 0;
        while (i < k) 
        {
            CharSequence charsequence = pageradapter.getPageTitle(i);
            if (charsequence == null)
            {
                charsequence = a;
            }
            d d1;
            int j;
            if (a1 != null)
            {
                j = a1.a();
            } else
            {
                j = 0;
            }
            d1 = new d(this, getContext());
            com.picsart.studio.view.viewpagerindicator.d.a(d1, i);
            d1.setFocusable(true);
            d1.setOnClickListener(c);
            d1.setText(charsequence);
            if (j != 0)
            {
                d1.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
            }
            d.addView(d1, new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F));
            i++;
        }
        if (h > k)
        {
            h = k - 1;
        }
        setCurrentItem(h);
        requestLayout();
    }

    static Runnable b(TabPageIndicator tabpageindicator)
    {
        tabpageindicator.b = null;
        return null;
    }

    static int c(TabPageIndicator tabpageindicator)
    {
        return tabpageindicator.g;
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (b != null)
        {
            post(b);
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (b != null)
        {
            removeCallbacks(b);
        }
    }

    public void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l;
        boolean flag;
        if (k == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        l = d.getChildCount();
        if (l > 1 && (k == 0x40000000 || k == 0x80000000))
        {
            if (l > 2)
            {
                g = (int)((float)android.view.View.MeasureSpec.getSize(i) * 0.4F);
            } else
            {
                g = android.view.View.MeasureSpec.getSize(i) / 2;
            }
        } else
        {
            g = -1;
        }
        k = getMeasuredWidth();
        super.onMeasure(i, j);
        i = getMeasuredWidth();
        if (flag && k != i)
        {
            setCurrentItem(h);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (f != null)
        {
            f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f1, int j)
    {
        if (f != null)
        {
            f.onPageScrolled(i, f1, j);
        }
    }

    public void onPageSelected(int i)
    {
        setCurrentItem(i);
        if (f != null)
        {
            f.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i)
    {
        if (e == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        h = i;
        e.setCurrentItem(i);
        int k = d.getChildCount();
        int j = 0;
        while (j < k) 
        {
            View view = d.getChildAt(j);
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
            view = d.getChildAt(i);
            if (b != null)
            {
                removeCallbacks(b);
            }
            b = new Runnable(view) {

                private View a;
                private TabPageIndicator b;

                public final void run()
                {
                    int l = a.getLeft();
                    int i1 = (b.getWidth() - a.getWidth()) / 2;
                    b.smoothScrollTo(l - i1, 0);
                    TabPageIndicator.b(b);
                }

            
            {
                b = TabPageIndicator.this;
                a = view;
                super();
            }
            };
            post(b);
            j++;
        }
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        f = onpagechangelistener;
    }

    public void setOnTabReselectedListener$71dab29d(a a1)
    {
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (e == viewpager)
        {
            return;
        }
        if (e != null)
        {
            e.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            e = viewpager;
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
