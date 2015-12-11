// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ContainerLayout extends LinearLayout
{

    private final Paint divider;
    private int dividerPadding;

    public ContainerLayout(Context context)
    {
        super(context);
        divider = new Paint();
        dividerPadding = 0;
        setOrientation(1);
        divider.setColor(getDefaultDividerColor());
    }

    public ContainerLayout(Context context, AttributeSet attributeset)
    {
        int i;
        int j;
        boolean flag;
        int k;
        super(context, attributeset);
        divider = new Paint();
        dividerPadding = 0;
        setOrientation(1);
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ContainerLayout);
        i = 0;
        flag = false;
        k = context.getIndexCount();
        j = 0;
_L2:
        int l;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        l = context.getIndex(j);
        switch (l)
        {
        default:
            break;

        case 0: // '\0'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        break MISSING_BLOCK_LABEL_111;
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        dividerPadding = context.getDimensionPixelSize(l, 0);
          goto _L3
        i = context.getColor(l, 0);
        flag = true;
          goto _L3
        context.recycle();
        if (!flag)
        {
            i = getDefaultDividerColor();
        }
        divider.setColor(i);
        return;
    }

    private int getDefaultDividerColor()
    {
        Context context = getContext();
        TypedValue typedvalue = new TypedValue();
        if (!context.getTheme().resolveAttribute(0x7f010058, typedvalue, true))
        {
            typedvalue.resourceId = 0x7f0d00ae;
        }
        if (typedvalue.resourceId != 0)
        {
            typedvalue.data = context.getResources().getColor(typedvalue.resourceId);
        }
        return typedvalue.data;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
label0:
        {
label1:
            {
                Object obj1 = view;
                Object obj = layoutparams;
                if (!view.isClickable())
                {
                    break label0;
                }
                obj1 = view;
                obj = layoutparams;
                if (view instanceof Button)
                {
                    break label0;
                }
                obj1 = view;
                obj = layoutparams;
                if (!(layoutparams instanceof android.view.ViewGroup.MarginLayoutParams))
                {
                    break label1;
                }
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)layoutparams;
                if ((marginlayoutparams.leftMargin | marginlayoutparams.topMargin | marginlayoutparams.rightMargin | marginlayoutparams.bottomMargin) == 0)
                {
                    obj1 = view;
                    obj = layoutparams;
                    if (marginlayoutparams.width == -1)
                    {
                        break label1;
                    }
                }
                obj = new android.widget.LinearLayout.LayoutParams(marginlayoutparams);
                if (marginlayoutparams instanceof android.widget.LinearLayout.LayoutParams)
                {
                    obj.gravity = ((android.widget.LinearLayout.LayoutParams)marginlayoutparams).gravity;
                }
                obj1 = new LinearLayout(getContext());
                ((LinearLayout) (obj1)).setAddStatesFromChildren(true);
                ((LinearLayout) (obj1)).setOrientation(1);
                ((LinearLayout) (obj1)).addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
                int j;
                if (layoutparams instanceof android.widget.LinearLayout.LayoutParams)
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2, ((android.widget.LinearLayout.LayoutParams)layoutparams).weight);
                } else
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
                }
            }
            j = 0x1080062;
            view = new TypedValue();
            if (getContext().getTheme().resolveAttribute(0x10102f0, view, true))
            {
                j = ((TypedValue) (view)).resourceId;
            }
            ((View) (obj1)).setBackgroundResource(j);
        }
        super.addView(((View) (obj1)), i, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (divider != null)
        {
            int k = getChildCount();
            boolean flag = false;
            int i = 0;
            while (i < k) 
            {
                View view = getChildAt(i);
                int j = ((flag) ? 1 : 0);
                if (view != null)
                {
                    j = ((flag) ? 1 : 0);
                    if (view.getVisibility() != 8)
                    {
                        if (!flag)
                        {
                            j = 1;
                        } else
                        {
                            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                            j = view.getTop() - layoutparams.topMargin;
                            canvas.drawLine(getPaddingLeft() + dividerPadding, j, getWidth() - getPaddingRight() - dividerPadding, j, divider);
                            j++;
                            canvas.drawLine(getPaddingLeft() + dividerPadding, j, getWidth() - getPaddingRight() - dividerPadding, j, divider);
                            j = ((flag) ? 1 : 0);
                        }
                    }
                }
                i++;
                flag = j;
            }
        }
    }
}
