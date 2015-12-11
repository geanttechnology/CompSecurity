// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.groupon.view:
//            ExpandablePanel

private static class mContent extends Animation
{

    private final View mContent;
    private final int mDeltaHeight;
    private final int mStartHeight;

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = mContent.getLayoutParams();
        transformation.mContent = (int)((float)mStartHeight + (float)mDeltaHeight * f);
        mContent.setLayoutParams(transformation);
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public (int i, int j, View view)
    {
        mStartHeight = i;
        mDeltaHeight = j - i;
        mContent = view;
    }
}
