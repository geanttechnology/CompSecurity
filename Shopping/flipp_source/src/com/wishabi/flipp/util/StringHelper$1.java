// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

final class  extends SuperscriptSpan
{

    public final void updateDrawState(TextPaint textpaint)
    {
        textpaint.baselineShift = textpaint.baselineShift + (int)(textpaint.ascent() / 2.0F);
        textpaint.setTextSize(textpaint.getTextSize() / 2.0F);
    }

    public final void updateMeasureState(TextPaint textpaint)
    {
        textpaint.baselineShift = textpaint.baselineShift + (int)(textpaint.ascent() / 2.0F);
        textpaint.setTextSize(textpaint.getTextSize() / 2.0F);
    }

    ()
    {
    }
}
