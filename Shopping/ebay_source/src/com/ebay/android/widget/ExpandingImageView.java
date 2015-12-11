// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ExpandingImageView extends ImageView
{

    private boolean adjustHeight;

    public ExpandingImageView(Context context)
    {
        super(context);
        adjustHeight = true;
    }

    public ExpandingImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        adjustHeight = true;
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        int k1;
        int l1;
        Drawable drawable = getDrawable();
        k1 = drawable.getIntrinsicWidth();
        l1 = drawable.getIntrinsicHeight();
        k = i;
        l = j;
        if (k1 <= 0) goto _L2; else goto _L1
_L1:
        k = i;
        l = j;
        if (l1 <= 0) goto _L2; else goto _L3
_L3:
        int i1;
        int j1;
        i1 = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getSize(j);
        if (!adjustHeight) goto _L5; else goto _L4
_L4:
        i1 = (i1 * l1) / k1;
        k = i;
        l = j;
        if (i1 != j1)
        {
            l = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            k = i;
        }
_L2:
        super.onMeasure(k, l);
        return;
_L5:
        j1 = (j1 * k1) / l1;
        k = i;
        l = j;
        if (j1 != i1)
        {
            k = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
            l = j;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }
}
