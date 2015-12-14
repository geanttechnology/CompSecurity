// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;

import android.animation.ValueAnimator;

// Referenced classes of package com.github.rahatarmanahmed.cpv:
//            CircularProgressView

class val.start
    implements android.animation.pdateListener
{

    final CircularProgressView this$0;
    final float val$maxSweep;
    final float val$start;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        CircularProgressView.access$202(CircularProgressView.this, ((Float)valueanimator.getAnimatedValue()).floatValue());
        CircularProgressView.access$302(CircularProgressView.this, (val$maxSweep - CircularProgressView.access$200(CircularProgressView.this)) + val$start);
        invalidate();
    }

    ()
    {
        this$0 = final_circularprogressview;
        val$maxSweep = f;
        val$start = F.this;
        super();
    }
}
