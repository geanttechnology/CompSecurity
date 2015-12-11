// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandCollapseAnimation
{

    private static final int DURATION_MS = 300;

    public ExpandCollapseAnimation()
    {
    }

    public static void collapse(View view, int i)
    {
        Animation animation = new Animation(view, i) {

            final int val$initialHeight;
            final View val$view;

            protected void applyTransformation(float f, Transformation transformation)
            {
                if (f == 1.0F)
                {
                    view.setVisibility(8);
                    return;
                } else
                {
                    view.getLayoutParams().height = initialHeight - (int)((float)initialHeight * f);
                    view.requestLayout();
                    return;
                }
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                view = view1;
                initialHeight = i;
                super();
            }
        };
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    public static void expand(View view, int i)
    {
        view.getLayoutParams().height = 1;
        view.setVisibility(0);
        Animation animation = new Animation(view, i) {

            final int val$targetHeight;
            final View val$view;

            protected void applyTransformation(float f, Transformation transformation)
            {
                transformation = view.getLayoutParams();
                int j;
                if (f == 1.0F)
                {
                    j = targetHeight;
                } else
                {
                    j = (int)((float)targetHeight * f);
                }
                transformation.height = j;
                view.requestLayout();
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                view = view1;
                targetHeight = i;
                super();
            }
        };
        animation.setDuration(300L);
        view.startAnimation(animation);
    }
}
