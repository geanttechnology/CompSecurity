// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.user.symban;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.ebay.mobile.user.symban:
//            SymbanFragment

private static class animInterpolator extends Animation
{

    private static final AccelerateInterpolator animInterpolator = new AccelerateInterpolator();
    final int startHeight;
    final View view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i = (int)((float)startHeight * (1.0F - f));
        view.getLayoutParams().view = i;
        view.requestLayout();
    }


    public (View view1)
    {
        view = view1;
        startHeight = view1.getHeight();
        setInterpolator(animInterpolator);
    }
}
