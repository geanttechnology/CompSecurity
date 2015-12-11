// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class PaddingSpan extends ReplacementSpan
{

    private RectF mRect;
    private final float minWidth;
    private final float padding;

    public PaddingSpan(float f, float f1)
    {
        mRect = new RectF();
        minWidth = f;
        padding = f1;
    }

    public void draw(Canvas canvas, CharSequence charsequence, int i, int j, float f, int k, int l, 
            int i1, Paint paint)
    {
        float f2 = paint.measureText(charsequence, i, j);
        float f1 = f;
        if (minWidth > f2)
        {
            f1 = f + (minWidth - f2) / 2.0F;
        }
        k = Math.round(f1);
        l = (int)((float)(canvas.getHeight() / 2) - (paint.descent() + paint.ascent()) / 2.0F);
        canvas.drawText(charsequence, i, j, k, l, paint);
    }

    public int getSize(Paint paint, CharSequence charsequence, int i, int j, android.graphics.Paint.FontMetricsInt fontmetricsint)
    {
        return Math.round(Math.max(paint.measureText(charsequence, i, j) + padding, minWidth));
    }
}
