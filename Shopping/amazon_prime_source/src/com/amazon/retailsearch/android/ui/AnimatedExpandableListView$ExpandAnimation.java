// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            AnimatedExpandableListView

private static class <init> extends Animation
{

    private int baseHeight;
    private int delta;
    private view groupInfo;
    private View view;

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        if (f < 1.0F)
        {
            int i = baseHeight + (int)((float)delta * f);
            view.getLayoutParams().view = i;
            groupInfo.eight = i;
            view.requestLayout();
            return;
        } else
        {
            int j = baseHeight + delta;
            view.getLayoutParams().view = j;
            groupInfo.eight = j;
            view.requestLayout();
            return;
        }
    }

    private (View view1, int i, int j,  )
    {
        baseHeight = i;
        delta = j - i;
        view = view1;
        groupInfo = ;
        view.getLayoutParams().view = i;
        view.requestLayout();
    }

    view(View view1, int i, int j, view view2, view view3)
    {
        this(view1, i, j, view2);
    }
}
