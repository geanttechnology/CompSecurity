// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class ColoredSpan extends CharacterStyle
{

    private int mColor;

    public ColoredSpan(int i)
    {
        mColor = i;
    }

    public int getColor()
    {
        return mColor;
    }

    public void setColor(int i)
    {
        mColor = i;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(mColor);
        textpaint.setUnderlineText(false);
    }
}
