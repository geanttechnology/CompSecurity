// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BorderImageView extends ImageView
{

    private int color;

    public BorderImageView(Context context)
    {
        super(context);
        color = 0xff888888;
    }

    public BorderImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        color = 0xff888888;
    }

    public BorderImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        color = 0xff888888;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Rect rect = canvas.getClipBounds();
        rect.bottom = rect.bottom - 1;
        rect.right = rect.right - 1;
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
    }
}
