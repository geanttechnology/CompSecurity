// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ResultCloseSeparatorBackgroundDrawable extends Drawable
{

    int borderColor;
    int borderWidth;
    int crossColor;
    Paint paintFill;

    public ResultCloseSeparatorBackgroundDrawable(int i, int j, int k)
    {
        paintFill = new Paint();
        paintFill.setColor(i);
        borderColor = j;
        crossColor = k;
        borderWidth = 2;
    }

    private void drawCross(Canvas canvas, float f, float f1, float f2)
    {
        Paint paint = new Paint();
        paint.setColor(crossColor);
        paint.setStrokeWidth(7F);
        f2 = (float)(((double)f2 / 1.4139999999999999D) * 0.59999999999999998D);
        canvas.drawLine(f - f2, f1 + f2, f + f2, f1 - f2, paint);
        canvas.drawLine(f - f2, f1 - f2, f + f2, f1 + f2, paint);
    }

    private void drawTopBorderArc(Canvas canvas, float f, float f1, float f2)
    {
        Paint paint = new Paint();
        RectF rectf = new RectF();
        rectf.set(f - f2, f1 - f2, f + f2, f1 + f2);
        paint.setColor(borderColor);
        paint.setStrokeWidth(borderWidth);
        paint.setAntiAlias(true);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        canvas.drawArc(rectf, 210F, 120F, false, paint);
    }

    private void drawTopBorderLine(Canvas canvas, float f, int i)
    {
        Paint paint = new Paint();
        paint.setColor(borderColor);
        paint.setStrokeWidth(borderWidth);
        canvas.drawLine(0.0F, f, i, f, paint);
    }

    public void draw(Canvas canvas)
    {
        int i = getBounds().height();
        int j = getBounds().width();
        double d = (double)i * 0.050000000000000003D;
        float f = (float)(((double)i - 2D * d) / 2D);
        float f1 = (float)((double)j / 2D);
        float f2 = (float)((double)i / 2D);
        float f3 = (float)((double)(f / 2.0F) + d);
        canvas.drawRect(0.0F, f3, j, (float)((double)((float)i - (float)((double)f / 2D)) - d), paintFill);
        drawTopBorderLine(canvas, f3, j);
        canvas.drawCircle(f1, f2, f, paintFill);
        drawCross(canvas, f1, f2, f);
        drawTopBorderArc(canvas, f1, f2, f);
    }

    public int getOpacity()
    {
        return -1;
    }

    public void setAlpha(int i)
    {
        paintFill.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        paintFill.setColorFilter(colorfilter);
    }
}
