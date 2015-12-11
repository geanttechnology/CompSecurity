// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.groupon.animation:
//            ExpandCollapseAnimation

static final class val.initialHeight extends Animation
{

    final int val$initialHeight;
    final View val$view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        if (f == 1.0F)
        {
            val$view.setVisibility(8);
            return;
        } else
        {
            val$view.getLayoutParams().ght = val$initialHeight - (int)((float)val$initialHeight * f);
            val$view.requestLayout();
            return;
        }
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    (View view1, int i)
    {
        val$view = view1;
        val$initialHeight = i;
        super();
    }
}
