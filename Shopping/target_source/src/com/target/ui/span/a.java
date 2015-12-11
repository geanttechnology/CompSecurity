// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.span;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class a extends MetricAffectingSpan
{

    private Typeface mTypeface;

    public a(Typeface typeface)
    {
        mTypeface = typeface;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setTypeface(mTypeface);
        textpaint.setFlags(textpaint.getFlags() | 0x80);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        textpaint.setTypeface(mTypeface);
        textpaint.setFlags(textpaint.getFlags() | 0x80);
    }
}
