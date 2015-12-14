// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package viewpagerindicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import cfm;
import cfn;
import cfo;

// Referenced classes of package viewpagerindicator:
//            PageIndicator

public class IconPageIndicator extends HorizontalScrollView
    implements PageIndicator
{

    private Runnable mIconSelector;
    private final cfo mIconsLayout;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private int mSelectedIndex;
    private ViewPager mViewPager;

    public IconPageIndicator(Context context)
    {
        this(context, null);
    }

    public IconPageIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setHorizontalScrollBarEnabled(false);
        mIconsLayout = new cfo(context, 0x7f0100e4);
        addView(mIconsLayout, new android.widget.FrameLayout.LayoutParams(-2, -1, 17));
    }

    private void animateToIcon(int i)
    {
        View view = mIconsLayout.getChildAt(i);
        if (mIconSelector != null)
        {
            removeCallbacks(mIconSelector);
        }
        mIconSelector = new cfm(this, view);
        post(mIconSelector);
    }

    public void notifyDataSetChanged()
    {
        mIconsLayout.removeAllViews();
        cfn cfn1 = (cfn)mViewPager.getAdapter();
        int j = cfn1.a();
        for (int i = 0; i < j; i++)
        {
            ImageView imageview = new ImageView(getContext(), null, 0x7f0100e4);
            imageview.setImageResource(cfn1.a(i));
            mIconsLayout.addView(imageview);
        }

        if (mSelectedIndex > j)
        {
            mSelectedIndex = j - 1;
        }
        setCurrentItem(mSelectedIndex);
        requestLayout();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mIconSelector != null)
        {
            post(mIconSelector);
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mIconSelector != null)
        {
            removeCallbacks(mIconSelector);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (mListener != null)
        {
            mListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (mListener != null)
        {
            mListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        setCurrentItem(i);
        if (mListener != null)
        {
            mListener.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i)
    {
        if (mViewPager == null)
        {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        mSelectedIndex = i;
        mViewPager.setCurrentItem(i);
        int k = mIconsLayout.getChildCount();
        int j = 0;
        while (j < k) 
        {
            View view = mIconsLayout.getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (flag)
            {
                animateToIcon(i);
            }
            j++;
        }
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (mViewPager == viewpager)
        {
            return;
        }
        if (mViewPager != null)
        {
            mViewPager.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            mViewPager = viewpager;
            viewpager.setOnPageChangeListener(this);
            notifyDataSetChanged();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i)
    {
        setViewPager(viewpager);
        setCurrentItem(i);
    }


/*
    public static Runnable access$002(IconPageIndicator iconpageindicator, Runnable runnable)
    {
        iconpageindicator.mIconSelector = runnable;
        return runnable;
    }

*/
}
