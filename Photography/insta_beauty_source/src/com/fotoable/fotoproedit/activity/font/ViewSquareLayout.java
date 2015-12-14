// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ViewSquareLayout extends RelativeLayout
{

    public ViewSquareLayout(Context context)
    {
        super(context);
    }

    public ViewSquareLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ViewSquareLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, j));
        i = getMeasuredWidth();
        getMeasuredHeight();
        i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        super.onMeasure(i, i);
    }
}
