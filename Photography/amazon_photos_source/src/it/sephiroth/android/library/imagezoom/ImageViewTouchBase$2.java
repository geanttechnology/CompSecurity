// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class oldValueY
    implements com.nineoldandroids.animation.rUpdateListener
{

    float oldValueX;
    float oldValueY;
    final ImageViewTouchBase this$0;
    final ValueAnimator val$anim1;
    final ValueAnimator val$anim2;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)val$anim1.getAnimatedValue()).floatValue();
        float f1 = ((Float)val$anim2.getAnimatedValue()).floatValue();
        panBy(f - oldValueX, f1 - oldValueY);
        oldValueX = f;
        oldValueY = f1;
    }

    stener()
    {
        this$0 = final_imageviewtouchbase;
        val$anim1 = valueanimator;
        val$anim2 = ValueAnimator.this;
        super();
        oldValueX = 0.0F;
        oldValueY = 0.0F;
    }
}
