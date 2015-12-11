// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;

public class MessageTransformer
    implements android.support.v4.view.ViewPager.PageTransformer
{

    private static final float MIN_OPACITY = 0.15F;
    private static final float MIN_SCALE = 0.8F;

    public MessageTransformer()
    {
    }

    public void transformPage(View view, float f)
    {
        int i = view.getWidth();
        if (f < -1F)
        {
            view.setAlpha(0.0F);
            return;
        }
        if (f <= 0.0F)
        {
            view.setAlpha(1.0F);
            view.setVisibility(0);
            view.setTranslationX(0.0F);
            view.setScaleX(1.0F);
            view.setScaleY(1.0F);
            return;
        }
        if (f <= 1.0F)
        {
            float f1 = 1.0F - f;
            if (f1 < 0.15F)
            {
                view.setAlpha(0.15F);
                view.setVisibility(8);
            } else
            {
                view.setAlpha(f1);
                view.setVisibility(0);
            }
            view.setTranslationX((float)i * -f);
            f = 0.8F + 0.2F * (1.0F - Math.abs(f));
            view.setScaleX(f);
            view.setScaleY(f);
            return;
        } else
        {
            view.setAlpha(0.0F);
            return;
        }
    }
}
