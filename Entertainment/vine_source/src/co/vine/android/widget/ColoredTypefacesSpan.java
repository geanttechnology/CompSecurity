// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.graphics.Typeface;
import android.text.TextPaint;

// Referenced classes of package co.vine.android.widget:
//            TypefacesSpan, ColoredSpan

public class ColoredTypefacesSpan extends TypefacesSpan
{

    private int mColor;

    public ColoredTypefacesSpan(Typeface typeface, int i)
    {
        super(null, typeface);
        mColor = i;
    }

    public ColoredTypefacesSpan(ColoredSpan coloredspan, TypefacesSpan typefacesspan)
    {
        super(typefacesspan.getFamily(), typefacesspan.getType());
        mColor = coloredspan.getColor();
    }

    public ColoredTypefacesSpan(String s, Typeface typeface, int i)
    {
        super(s, typeface);
        mColor = i;
    }

    public void setColor(int i)
    {
        mColor = i;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(mColor);
        textpaint.setUnderlineText(false);
        super.updateDrawState(textpaint);
    }
}
