// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewTiltiShiftTouch, PointCloud

class this._cls0
    implements com.nineoldandroids.animation.Touch._cls2
{

    final ImageViewTiltiShiftTouch this$0;

    public void onAnimationCancel(Animator animator)
    {
        if (ImageViewTiltiShiftTouch.access$000(ImageViewTiltiShiftTouch.this))
        {
            ImageViewTiltiShiftTouch.access$200(ImageViewTiltiShiftTouch.this).waveManager.lpha(0.0F);
            invalidate();
        }
    }

    public void onAnimationEnd(Animator animator)
    {
        if (ImageViewTiltiShiftTouch.access$000(ImageViewTiltiShiftTouch.this))
        {
            ImageViewTiltiShiftTouch.access$200(ImageViewTiltiShiftTouch.this).waveManager.adius(0.0F);
            ImageViewTiltiShiftTouch.access$200(ImageViewTiltiShiftTouch.this).waveManager.lpha(0.0F);
            invalidate();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        if (ImageViewTiltiShiftTouch.access$000(ImageViewTiltiShiftTouch.this))
        {
            ImageViewTiltiShiftTouch.access$200(ImageViewTiltiShiftTouch.this).waveManager.adius(((Float)ImageViewTiltiShiftTouch.access$100(ImageViewTiltiShiftTouch.this).getAnimatedValue()).floatValue());
            ImageViewTiltiShiftTouch.access$200(ImageViewTiltiShiftTouch.this).waveManager.lpha(1.0F);
            invalidate();
        }
    }

    ()
    {
        this$0 = ImageViewTiltiShiftTouch.this;
        super();
    }
}
