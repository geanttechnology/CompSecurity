// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class TypefaceSpan extends MetricAffectingSpan
{

    private static LruCache sTypefaceCache = new LruCache(12);
    private Typeface mTypeface;

    public TypefaceSpan(Context context, String s)
    {
        mTypeface = (Typeface)sTypefaceCache.get(s);
        if (mTypeface == null)
        {
            mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), s);
            sTypefaceCache.put(s, mTypeface);
        }
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setShadowLayer(5F, 0.0F, 1.0F, 0xff000000);
        textpaint.setTypeface(mTypeface);
    }

    public void updateMeasureState(TextPaint textpaint)
    {
        textpaint.setShadowLayer(5F, 0.0F, 1.0F, 0xff000000);
        textpaint.setTypeface(mTypeface);
    }

}
