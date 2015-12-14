// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.screensaver;

import android.view.View;

public class FadingTransformer
    implements android.support.v4.view.ViewPager.PageTransformer
{

    public FadingTransformer()
    {
    }

    public void transformPage(View view, float f)
    {
        view.setTranslationX((float)view.getWidth() * -f);
        if (f <= -1F || f >= 1.0F)
        {
            view.setAlpha(0.0F);
            view.setTranslationX(0.0F);
            return;
        }
        if (f == 0.0F)
        {
            view.setAlpha(1.0F);
            return;
        } else
        {
            view.setAlpha(1.0F - Math.abs(f));
            return;
        }
    }
}
