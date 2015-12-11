// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.a;
import android.support.v4.view.a.d;
import android.support.v4.view.ai;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.List;

public class ViewPagerIndicator extends LinearLayout
{

    public static final String TAG = com/target/ui/view/common/ViewPagerIndicator.getSimpleName();
    private a mAccessibilityDelegate;
    private CharSequence mContentDescription;
    private int mNumPages;
    private int mSelectedIndex;
    private int mSize;

    public ViewPagerIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAccessibilityDelegate = new a() {

            final ViewPagerIndicator this$0;

            private String a()
            {
                int i = ViewPagerIndicator.b(ViewPagerIndicator.this);
                return getResources().getString(0x7f090480, new Object[] {
                    Integer.valueOf(i + 1), Integer.valueOf(com.target.ui.view.common.ViewPagerIndicator.a(ViewPagerIndicator.this))
                });
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
            {
                super.onInitializeAccessibilityEvent(view, accessibilityevent);
                accessibilityevent.setItemCount(com.target.ui.view.common.ViewPagerIndicator.a(ViewPagerIndicator.this));
                accessibilityevent.setCurrentItemIndex(ViewPagerIndicator.b(ViewPagerIndicator.this));
            }

            public void onInitializeAccessibilityNodeInfo(View view, d d1)
            {
                super.onInitializeAccessibilityNodeInfo(view, d1);
                String s = a();
                view = s;
                if (!TextUtils.isEmpty(ViewPagerIndicator.c(ViewPagerIndicator.this)))
                {
                    view = (new StringBuilder()).append(s).append((String)ViewPagerIndicator.c(ViewPagerIndicator.this)).toString();
                }
                d1.c(view);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityevent)
            {
                super.onPopulateAccessibilityEvent(view, accessibilityevent);
                accessibilityevent.getText().add(a());
                if (!TextUtils.isEmpty(ViewPagerIndicator.c(ViewPagerIndicator.this)))
                {
                    accessibilityevent.getText().add(ViewPagerIndicator.c(ViewPagerIndicator.this));
                }
            }

            
            {
                this$0 = ViewPagerIndicator.this;
                super();
            }
        };
        setOrientation(0);
        context = context.getTheme().obtainStyledAttributes(attributeset, com.target.ui.a.a.ViewPagerIndicator, 0, 0);
        mSize = context.getDimensionPixelSize(0, 0);
        context.recycle();
        ai.a(this, mAccessibilityDelegate);
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    static int a(ViewPagerIndicator viewpagerindicator)
    {
        return viewpagerindicator.mNumPages;
    }

    static int b(ViewPagerIndicator viewpagerindicator)
    {
        return viewpagerindicator.mSelectedIndex;
    }

    static CharSequence c(ViewPagerIndicator viewpagerindicator)
    {
        return viewpagerindicator.mContentDescription;
    }

    public void a(int i)
    {
        mSelectedIndex = i;
        int j = 0;
        while (j < mNumPages) 
        {
            View view = getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            j++;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.dispatchPopulateAccessibilityEvent(accessibilityevent);
        int i = mSelectedIndex;
        String s = getResources().getString(0x7f090480, new Object[] {
            Integer.valueOf(i + 1), Integer.valueOf(mNumPages)
        });
        accessibilityevent.getText().add(s);
        if (mContentDescription != null && !TextUtils.isEmpty(mContentDescription))
        {
            accessibilityevent.getText().add(mContentDescription);
        }
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        super.onPopulateAccessibilityEvent(accessibilityevent);
    }

    public void setContentDescription(CharSequence charsequence)
    {
        mContentDescription = charsequence;
    }

    public void setPageCount(int i)
    {
        mNumPages = i;
        removeAllViews();
        for (int j = 0; j < i; j++)
        {
            ImageView imageview = new ImageView(getContext(), null);
            imageview.setImageResource(0x7f020234);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(mSize, mSize);
            if (j > 0)
            {
                layoutparams.setMargins(mSize, 0, 0, 0);
            }
            imageview.setLayoutParams(layoutparams);
            addView(imageview);
        }

        if (mSelectedIndex >= mNumPages)
        {
            mSelectedIndex = mNumPages - 1;
        }
        a(mSelectedIndex);
        requestLayout();
    }

}
