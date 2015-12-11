// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment

private static class setDuration extends Animation
{

    final long animationDuration = 500L;
    int guessedHeight;
    boolean showing;
    View view;
    int visibleHeight;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i;
        if (showing)
        {
            i = (int)((float)guessedHeight * f);
            if (f >= 1.0F)
            {
                i = visibleHeight;
            }
        } else
        {
            i = (int)((float)guessedHeight * (1.0F - f));
        }
        view.getLayoutParams().view = i;
        view.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public (View view1, int i, int j, boolean flag)
    {
        view = view1;
        visibleHeight = i;
        showing = flag;
        guessedHeight = j;
        setDuration(500L);
    }
}
