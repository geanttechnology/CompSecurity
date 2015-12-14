// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.devspark.robototextview.style;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.devspark.robototextview.util.RobotoTextViewUtils;
import com.devspark.robototextview.util.RobotoTypefaceManager;

public class RobotoTypefaceSpan extends MetricAffectingSpan
{

    private final Typeface mTypeface;

    public RobotoTypefaceSpan(Context context)
    {
        this(context, 4);
    }

    public RobotoTypefaceSpan(Context context, int i)
    {
        mTypeface = RobotoTypefaceManager.obtainTypeface(context, i);
    }

    public RobotoTypefaceSpan(Context context, int i, int j, int k)
    {
        mTypeface = RobotoTypefaceManager.obtainTypeface(context, i, j, k);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        RobotoTextViewUtils.setTypeface(textpaint, mTypeface);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        RobotoTextViewUtils.setTypeface(textpaint, mTypeface);
    }
}
