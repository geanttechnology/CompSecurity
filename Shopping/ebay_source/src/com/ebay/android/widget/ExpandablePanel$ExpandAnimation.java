// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.ebay.android.widget:
//            ExpandablePanel

private class mDeltaHeight extends Animation
{

    private final int mDeltaHeight;
    private final int mStartHeight;
    final ExpandablePanel this$0;

    protected void applyTransformation(float f, Transformation transformation)
    {
        transformation = ExpandablePanel.access$600(ExpandablePanel.this).getLayoutParams();
        transformation._fld0 = (int)((float)mStartHeight + (float)mDeltaHeight * f);
        ExpandablePanel.access$600(ExpandablePanel.this).setLayoutParams(transformation);
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public (int i, int j)
    {
        this$0 = ExpandablePanel.this;
        super();
        mStartHeight = i;
        mDeltaHeight = j - i;
    }
}
