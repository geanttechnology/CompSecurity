// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.groupon.animation:
//            ExpandCollapseAnimation

static final class val.targetHeight extends Animation
{

    final int val$targetHeight;
    final View val$view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = val$view.getLayoutParams();
        int i;
        if (f == 1.0F)
        {
            i = val$targetHeight;
        } else
        {
            i = (int)((float)val$targetHeight * f);
        }
        transformation.ght = i;
        val$view.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    (View view1, int i)
    {
        val$view = view1;
        val$targetHeight = i;
        super();
    }
}
