// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimationFactory, ViewAnimationFactory, NoAnimation, DrawableCrossFadeViewAnimation, 
//            GlideAnimation

public class DrawableCrossFadeFactory
    implements GlideAnimationFactory
{
    private static class DefaultAnimationFactory
        implements ViewAnimation.AnimationFactory
    {

        public Animation build()
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(150L);
            return alphaanimation;
        }

        private DefaultAnimationFactory()
        {
        }

    }


    private DrawableCrossFadeViewAnimation animation;
    private final ViewAnimationFactory animationFactory;
    private final int duration;

    public DrawableCrossFadeFactory()
    {
        this(300);
    }

    public DrawableCrossFadeFactory(int i)
    {
        this(new ViewAnimationFactory(new DefaultAnimationFactory()), i);
    }

    DrawableCrossFadeFactory(ViewAnimationFactory viewanimationfactory, int i)
    {
        animationFactory = viewanimationfactory;
        duration = i;
    }

    public GlideAnimation build(boolean flag, boolean flag1)
    {
        if (flag)
        {
            return NoAnimation.get();
        }
        if (animation == null)
        {
            animation = new DrawableCrossFadeViewAnimation(animationFactory.build(false, flag1), duration);
        }
        return animation;
    }
}
