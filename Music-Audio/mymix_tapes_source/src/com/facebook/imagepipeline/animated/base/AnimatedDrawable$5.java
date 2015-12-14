// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.base;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.facebook.imagepipeline.animated.base:
//            AnimatedDrawable

class this._cls0
    implements com.nineoldandroids.animation.torUpdateListener
{

    final AnimatedDrawable this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        setLevel(((Integer)valueanimator.getAnimatedValue()).intValue());
    }

    stener()
    {
        this$0 = AnimatedDrawable.this;
        super();
    }
}
