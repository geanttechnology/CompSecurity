// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.aviary.android.feather.library.graphics.Point2D;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class val.destRotation
    implements com.nineoldandroids.animation.istener
{

    final AdjustImageView this$0;
    final double val$destRotation;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        mRotation = Point2D.angle360(val$destRotation);
        AdjustImageView.access$200(AdjustImageView.this, mRotation, true);
        initStraighten = true;
        mRunning = false;
        invalidate();
        printDetails();
        if (isReset)
        {
            AdjustImageView.access$100(AdjustImageView.this);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = final_adjustimageview;
        val$destRotation = D.this;
        super();
    }
}
