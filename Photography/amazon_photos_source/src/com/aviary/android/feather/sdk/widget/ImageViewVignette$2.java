// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewVignette, PointCloud

class val.mAnimator
    implements com.nineoldandroids.animation.tener
{

    final ImageViewVignette this$0;
    final ValueAnimator val$mAnimator;

    public void onAnimationCancel(Animator animator)
    {
        ImageViewVignette.access$100(ImageViewVignette.this).waveManager.setAlpha(0.0F);
        invalidate();
    }

    public void onAnimationEnd(Animator animator)
    {
        ImageViewVignette.access$100(ImageViewVignette.this).waveManager.setRadius(0.0F);
        ImageViewVignette.access$100(ImageViewVignette.this).waveManager.setAlpha(0.0F);
        invalidate();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        ImageViewVignette.access$100(ImageViewVignette.this).waveManager.setRadius(((Float)val$mAnimator.getAnimatedValue()).floatValue());
        ImageViewVignette.access$100(ImageViewVignette.this).waveManager.setAlpha(1.0F);
        invalidate();
    }

    er()
    {
        this$0 = final_imageviewvignette;
        val$mAnimator = ValueAnimator.this;
        super();
    }
}
