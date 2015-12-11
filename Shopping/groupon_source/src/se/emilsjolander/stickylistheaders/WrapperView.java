// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class WrapperView extends ViewGroup
{

    Drawable mDivider;
    int mDividerHeight;
    View mHeader;
    View mItem;
    int mItemTop;

    WrapperView(Context context)
    {
        super(context);
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mHeader == null && mDivider != null && mItem.getVisibility() != 8)
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                canvas.clipRect(0, 0, getWidth(), mDividerHeight);
            }
            mDivider.draw(canvas);
        }
    }

    public View getHeader()
    {
        return mHeader;
    }

    public View getItem()
    {
        return mItem;
    }

    public boolean hasHeader()
    {
        return mHeader != null;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        i = getWidth();
        j = getHeight();
        if (mHeader != null)
        {
            k = mHeader.getMeasuredHeight();
            mHeader.layout(0, 0, i, k);
            mItemTop = k;
            mItem.layout(0, k, i, j);
            return;
        }
        if (mDivider != null)
        {
            mDivider.setBounds(0, 0, i, mDividerHeight);
            mItemTop = mDividerHeight;
            mItem.layout(0, mDividerHeight, i, j);
            return;
        } else
        {
            mItemTop = 0;
            mItem.layout(0, 0, i, j);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000);
        j = 0;
        android.view.ViewGroup.LayoutParams layoutparams;
        if (mHeader != null)
        {
            layoutparams = mHeader.getLayoutParams();
            if (layoutparams != null && layoutparams.height > 0)
            {
                mHeader.measure(l, android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000));
            } else
            {
                mHeader.measure(l, android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            i = 0 + mHeader.getMeasuredHeight();
        } else
        {
            i = j;
            if (mDivider != null)
            {
                i = j;
                if (mItem.getVisibility() != 8)
                {
                    i = 0 + mDividerHeight;
                }
            }
        }
        layoutparams = mItem.getLayoutParams();
        if (mItem.getVisibility() == 8)
        {
            mItem.measure(l, android.view.View.MeasureSpec.makeMeasureSpec(0, 0x40000000));
        } else
        if (layoutparams != null && layoutparams.height >= 0)
        {
            mItem.measure(l, android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000));
            i += mItem.getMeasuredHeight();
        } else
        {
            mItem.measure(l, android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
            i += mItem.getMeasuredHeight();
        }
        setMeasuredDimension(k, i);
    }

    void update(View view, View view1, Drawable drawable, int i)
    {
        if (view == null)
        {
            throw new NullPointerException("List view item must not be null.");
        }
        if (mItem != view)
        {
            removeView(mItem);
            mItem = view;
            android.view.ViewParent viewparent = view.getParent();
            if (viewparent != null && viewparent != this && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(view);
            }
            addView(view);
        }
        if (mHeader != view1)
        {
            if (mHeader != null)
            {
                removeView(mHeader);
            }
            mHeader = view1;
            if (view1 != null)
            {
                addView(view1);
            }
        }
        if (mDivider != drawable)
        {
            mDivider = drawable;
            mDividerHeight = i;
            invalidate();
        }
    }
}
