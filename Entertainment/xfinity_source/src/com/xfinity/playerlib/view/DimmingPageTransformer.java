// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.view.View;

public class DimmingPageTransformer
    implements android.support.v4.view.ViewPager.PageTransformer
{

    public static float MAX_ALPHA = 1.0F;
    public static float MIN_ALPHA = 0.3F;

    public DimmingPageTransformer()
    {
    }

    public void transformPage(View view, float f)
    {
        f = Math.abs(f);
        view.setAlpha(MAX_ALPHA - (MAX_ALPHA - MIN_ALPHA) * f);
    }

}
