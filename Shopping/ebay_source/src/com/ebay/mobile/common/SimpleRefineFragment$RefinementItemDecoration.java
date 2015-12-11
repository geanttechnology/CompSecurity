// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

// Referenced classes of package com.ebay.mobile.common:
//            SimpleRefineFragment

protected static class divider extends android.support.v7.widget.ider
{

    protected final Drawable divider;

    public void onDrawOver(Canvas canvas, RecyclerView recyclerview, android.support.v7.widget.ider ider)
    {
        int j = recyclerview.getWidth();
        int k = recyclerview.getChildCount();
        for (int i = 0; i < k; i++)
        {
            ider = recyclerview.getChildAt(i);
            android.support.v7.widget.ider ider1 = (android.support.v7.widget.ider)ider.getLayoutParams();
            int l = ider.getBottom() + ider1.ider;
            int i1 = divider.getIntrinsicHeight();
            divider.setBounds(0, l, j, l + i1);
            divider.draw(canvas);
        }

    }

    public (Context context)
    {
        context = context.getResources();
        ShapeDrawable shapedrawable = new ShapeDrawable(new RectShape());
        shapedrawable.getPaint().setColor(context.getColor(0x7f0d00ec));
        shapedrawable.setIntrinsicHeight((int)TypedValue.applyDimension(1, 1.0F, context.getDisplayMetrics()));
        divider = shapedrawable;
    }
}
