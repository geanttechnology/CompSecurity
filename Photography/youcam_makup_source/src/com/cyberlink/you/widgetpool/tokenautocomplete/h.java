// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.view.View;

public class h extends ReplacementSpan
{

    private int a;
    protected View b;

    public h(View view, int i)
    {
        a = i;
        b = view;
        b.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
    }

    private void a()
    {
        int i = android.view.View.MeasureSpec.makeMeasureSpec(a, 0x80000000);
        int j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        b.measure(i, j);
        b.layout(0, 0, b.getMeasuredWidth(), b.getMeasuredHeight());
    }

    public void draw(Canvas canvas, CharSequence charsequence, int i, int j, float f, int k, int l, 
            int i1, Paint paint)
    {
        a();
        canvas.save();
        i = (i1 - k - b.getBottom()) / 2;
        canvas.translate(f, i1 - b.getBottom() - i);
        b.draw(canvas);
        canvas.restore();
    }

    public int getSize(Paint paint, CharSequence charsequence, int i, int j, android.graphics.Paint.FontMetricsInt fontmetricsint)
    {
        a();
        if (fontmetricsint != null)
        {
            i = b.getMeasuredHeight() - (fontmetricsint.descent - fontmetricsint.ascent);
            if (i > 0)
            {
                j = i / 2;
                fontmetricsint.descent = fontmetricsint.descent + (i - j);
                fontmetricsint.ascent = fontmetricsint.ascent - j;
                fontmetricsint.bottom = (i - j) + fontmetricsint.bottom;
                fontmetricsint.top = fontmetricsint.top - i / 2;
            }
        }
        return b.getRight();
    }
}
