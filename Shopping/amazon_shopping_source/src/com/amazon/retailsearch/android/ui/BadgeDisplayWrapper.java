// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;

public class BadgeDisplayWrapper extends DynamicDrawableSpan
{

    private String badgeID;
    private Integer baseStyleId;
    private Drawable drawableImage;
    private int imageAlign;

    public BadgeDisplayWrapper(Drawable drawable, int i, Integer integer, String s)
    {
        drawableImage = drawable;
        imageAlign = i;
        baseStyleId = integer;
        badgeID = s;
    }

    public void draw(Canvas canvas, CharSequence charsequence, int i, int j, float f, int k, int l, 
            int i1, Paint paint)
    {
        charsequence = drawableImage;
        if (charsequence == null || canvas == null || paint == null)
        {
            return;
        }
        canvas.save();
        j = i1 - charsequence.getBounds().bottom;
        i = j;
        if (imageAlign != 1) goto _L2; else goto _L1
_L1:
        j -= paint.getFontMetricsInt().descent;
        i = j;
        if (baseStyleId == null) goto _L2; else goto _L3
_L3:
        i = j;
        if (baseStyleId.intValue() != com.amazon.retailsearch.R.style.Results_PriceBadgeSpan) goto _L2; else goto _L4
_L4:
        i = j;
        if (k != 0) goto _L2; else goto _L5
_L5:
        i = j;
        if (badgeID == null) goto _L2; else goto _L6
_L6:
        if (!badgeID.equals("primeBadge") && !badgeID.equals("primeFreshBadge")) goto _L8; else goto _L7
_L7:
        i = j - (paint.getFontMetricsInt().descent / 5) * 4;
_L2:
        canvas.translate(f, i);
        charsequence.draw(canvas);
        canvas.restore();
        return;
_L8:
        i = j;
        if (badgeID.equals("addOnBadge"))
        {
            i = j - (paint.getFontMetricsInt().descent / 5) * 2;
        }
        if (true) goto _L2; else goto _L9
_L9:
    }

    public Drawable getDrawable()
    {
        return drawableImage;
    }
}
