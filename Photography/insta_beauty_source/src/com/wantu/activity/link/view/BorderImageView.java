// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

// Referenced classes of package com.wantu.activity.link.view:
//            LinkImageView

public class BorderImageView extends LinkImageView
{

    int borderColor;
    float borderWidth;
    Paint paint;

    public BorderImageView(Context context)
    {
        super(context);
        borderColor = 0xff888888;
        borderWidth = 2.0F;
        paint = new Paint();
    }

    public BorderImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        borderColor = 0xff888888;
        borderWidth = 2.0F;
        paint = new Paint();
        context = context.obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.BorderImageView);
        borderColor = context.getColor(0, -1);
        borderWidth = context.getDimension(1, 2.0F);
        context.recycle();
    }

    public BorderImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        borderColor = 0xff888888;
        borderWidth = 2.0F;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Rect rect = canvas.getClipBounds();
        rect.bottom = rect.bottom - 1;
        rect.right = rect.right - 1;
        paint.setColor(borderColor);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);
        canvas.drawRect(rect, paint);
    }
}
