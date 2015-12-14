// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.socialin.android.util.c;

public class ColorView extends View
{

    private int a;
    private Paint b;
    private Rect c;
    private Bitmap d;

    public ColorView(Context context, int i)
    {
        super(context);
        a(context, i, 1);
    }

    public ColorView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, 0, 0);
    }

    public ColorView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, 0, 0);
    }

    private void a(Context context, int i, int j)
    {
        b = new Paint(5);
        b.setColor(i);
        switch (j)
        {
        default:
            return;

        case 1: // '\001'
            TypedValue.applyDimension(1, 17F, context.getResources().getDisplayMetrics());
            TypedValue.applyDimension(1, 17F, context.getResources().getDisplayMetrics());
            a = (int)TypedValue.applyDimension(1, 18F, context.getResources().getDisplayMetrics());
            c = new Rect(-1, -1, a * 2, a * 2);
            return;

        case 0: // '\0'
            TypedValue.applyDimension(1, 14F, context.getResources().getDisplayMetrics());
            TypedValue.applyDimension(1, 14F, context.getResources().getDisplayMetrics());
            a = (int)TypedValue.applyDimension(1, 13F, context.getResources().getDisplayMetrics());
            c = new Rect(1, 1, a * 2, a * 2);
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        com.socialin.android.util.c.a(d);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (b.getColor() != 0)
        {
            canvas.drawRect(c, b);
            return;
        }
        if (d == null)
        {
            d = com.socialin.android.util.c.a(getContext().getResources(), 0x7f02012a);
        }
        canvas.drawBitmap(d, null, c, null);
    }

    public void setColor(int i)
    {
        b.setColor(i);
        invalidate();
    }
}
