// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimationFactory, NoAnimation, ViewAnimation, GlideAnimation

public class ViewAnimationFactory
    implements GlideAnimationFactory
{
    private static class ResourceAnimationFactory
        implements ViewAnimation.AnimationFactory
    {

        private final int animationId;
        private final Context context;

        public Animation build()
        {
            return AnimationUtils.loadAnimation(context, animationId);
        }

        public ResourceAnimationFactory(Context context1, int i)
        {
            context = context1.getApplicationContext();
            animationId = i;
        }
    }


    private final ViewAnimation.AnimationFactory animationFactory;
    private GlideAnimation glideAnimation;

    public ViewAnimationFactory(Context context, int i)
    {
        this(((ViewAnimation.AnimationFactory) (new ResourceAnimationFactory(context, i))));
    }

    ViewAnimationFactory(ViewAnimation.AnimationFactory animationfactory)
    {
        animationFactory = animationfactory;
    }

    public GlideAnimation build(boolean flag, boolean flag1)
    {
        if (flag || !flag1)
        {
            return NoAnimation.get();
        }
        if (glideAnimation == null)
        {
            glideAnimation = new ViewAnimation(animationFactory);
        }
        return glideAnimation;
    }
}
