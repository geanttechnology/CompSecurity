// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BlackBackGroundView extends View
{

    int bgColor;
    Paint paint;
    RectF rectf;

    public BlackBackGroundView(Context context)
    {
        super(context);
        bgColor = 0xff000000;
        paint = new Paint();
        init();
    }

    public BlackBackGroundView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bgColor = 0xff000000;
        paint = new Paint();
        init();
    }

    public BlackBackGroundView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        bgColor = 0xff000000;
        paint = new Paint();
        init();
    }

    private void init()
    {
        rectf = new RectF(0.0F, 0.0F, getWidth(), getHeight());
    }

    protected void onDraw(Canvas canvas)
    {
        int i = bgColor;
        paint.setColor(Color.argb((int)((float)Color.alpha(i) * 0.5F), Color.red(i), Color.green(i), Color.blue(i)));
        paint.setStyle(android.graphics.Paint.Style.FILL);
        rectf.right = getWidth();
        rectf.bottom = getHeight();
        canvas.drawRect(rectf, paint);
    }
}
