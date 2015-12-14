// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.PointF;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewWithIntensity

class val.downPoint
    implements com.nineoldandroids.animation.
{

    final ImageViewWithIntensity this$0;
    final PointF val$downPoint;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        onUp(null);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        ImageViewWithIntensity.access$300(ImageViewWithIntensity.this, val$downPoint.x, val$downPoint.y, false);
    }

    ()
    {
        this$0 = final_imageviewwithintensity;
        val$downPoint = PointF.this;
        super();
    }
}
