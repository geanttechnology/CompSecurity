// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimation

public class ViewAnimation
    implements GlideAnimation
{
    static interface AnimationFactory
    {

        public abstract Animation build();
    }


    private final AnimationFactory animationFactory;

    ViewAnimation(AnimationFactory animationfactory)
    {
        animationFactory = animationfactory;
    }

    public boolean animate(Object obj, GlideAnimation.ViewAdapter viewadapter)
    {
        obj = viewadapter.getView();
        if (obj != null)
        {
            ((View) (obj)).clearAnimation();
            ((View) (obj)).startAnimation(animationFactory.build());
        }
        return false;
    }
}
