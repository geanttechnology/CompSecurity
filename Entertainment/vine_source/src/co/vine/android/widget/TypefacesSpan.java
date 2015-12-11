// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class TypefacesSpan extends TypefaceSpan
{

    private final Typeface newType;

    public TypefacesSpan(Typeface typeface)
    {
        super("");
        newType = typeface;
    }

    public TypefacesSpan(String s, Typeface typeface)
    {
        super(s);
        newType = typeface;
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface)
    {
        paint.setTypeface(typeface);
    }

    public Typeface getType()
    {
        return newType;
    }

    public void updateDrawState(TextPaint textpaint)
    {
        applyCustomTypeFace(textpaint, newType);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        applyCustomTypeFace(textpaint, newType);
    }
}
