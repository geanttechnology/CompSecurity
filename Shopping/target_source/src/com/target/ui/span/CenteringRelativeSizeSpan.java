// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.span;

import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;

public class CenteringRelativeSizeSpan extends RelativeSizeSpan
{

    public CenteringRelativeSizeSpan(float f)
    {
        super(f);
    }

    private void a(TextPaint textpaint)
    {
        int i = Math.round(textpaint.descent() + textpaint.ascent());
        textpaint.baselineShift = (Math.round((float)i / getSizeChange()) - i) / 2;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        a(textpaint);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        super.updateMeasureState(textpaint);
        a(textpaint);
    }
}
