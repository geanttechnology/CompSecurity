// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelActivity

public static class setDuration extends Animation
{

    final long animationDuration;
    int finishHeight;
    int heightDif;
    int startHeight;
    View view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i = (int)((float)heightDif * f) + startHeight;
        if (f >= 1.0F)
        {
            i = finishHeight;
        }
        view.getLayoutParams().view = i;
        view.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public (View view1, int i, int j)
    {
        animationDuration = 500L;
        view = view1;
        startHeight = i;
        finishHeight = j;
        heightDif = j - i;
        setDuration(500L);
    }

    public setDuration(View view1, int i, int j, int k)
    {
        animationDuration = 500L;
        view = view1;
        startHeight = i;
        finishHeight = k;
        heightDif = j - i;
        setDuration(500L);
    }
}
