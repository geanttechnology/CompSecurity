// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;

public class BBYTextAppearnceSpan extends TextAppearanceSpan
{

    private Typeface a;

    public BBYTextAppearnceSpan(Context context, int i, Typeface typeface)
    {
        super(context, i);
        a = typeface;
    }

    private static void a(Paint paint, Typeface typeface)
    {
        Typeface typeface1 = paint.getTypeface();
        int i;
        if (typeface1 == null)
        {
            i = 0;
        } else
        {
            i = typeface1.getStyle();
        }
        i &= ~typeface.getStyle();
        if ((i & 1) != 0)
        {
            paint.setFakeBoldText(true);
        }
        if ((i & 2) != 0)
        {
            paint.setTextSkewX(-0.25F);
        }
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        a(textpaint, a);
        super.updateDrawState(textpaint);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        a(textpaint, a);
        super.updateMeasureState(textpaint);
    }
}
