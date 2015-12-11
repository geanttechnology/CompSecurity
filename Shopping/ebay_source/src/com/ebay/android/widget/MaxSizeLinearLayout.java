// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

// Referenced classes of package com.ebay.android.widget:
//            MaxSizeHelper

public class MaxSizeLinearLayout extends LinearLayout
    implements MaxSizeHelper.MaxSizeWidget
{

    MaxSizeHelper maxSizeData;

    public MaxSizeLinearLayout(Context context)
    {
        super(context);
        maxSizeData = new MaxSizeHelper();
    }

    public MaxSizeLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        maxSizeData = new MaxSizeHelper(context, attributeset);
    }

    public int getMaxHeight()
    {
        return maxSizeData.getMaxHeight();
    }

    public int getMaxWidth()
    {
        return maxSizeData.getMaxWidth();
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(maxSizeData.getWidthMeasureSpec(i), maxSizeData.getHeightMeasureSpec(j));
    }

    public void setMaxHeight(int i)
    {
        maxSizeData.setMaxHeight(i);
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i)
    {
        maxSizeData.setMaxWidth(i);
        requestLayout();
        invalidate();
    }
}
