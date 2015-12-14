// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;


// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimation, GlideAnimationFactory

public class NoAnimation
    implements GlideAnimation
{
    public static class NoAnimationFactory
        implements GlideAnimationFactory
    {

        public GlideAnimation build(boolean flag, boolean flag1)
        {
            return NoAnimation.NO_ANIMATION;
        }

        public NoAnimationFactory()
        {
        }
    }


    private static final NoAnimation NO_ANIMATION = new NoAnimation();
    private static final GlideAnimationFactory NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public NoAnimation()
    {
    }

    public static GlideAnimation get()
    {
        return NO_ANIMATION;
    }

    public static GlideAnimationFactory getFactory()
    {
        return NO_ANIMATION_FACTORY;
    }

    public boolean animate(Object obj, GlideAnimation.ViewAdapter viewadapter)
    {
        return false;
    }


}
