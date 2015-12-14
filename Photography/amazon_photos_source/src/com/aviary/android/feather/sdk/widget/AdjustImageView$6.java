// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.Matrix;
import com.aviary.android.feather.library.graphics.Point2D;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class val.centery
    implements com.nineoldandroids.animation.istener
{

    final AdjustImageView this$0;
    final float val$centerx;
    final float val$centery;
    final boolean val$horizontal;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (val$horizontal)
        {
            animator = AdjustImageView.this;
            animator.mFlipType = ((AdjustImageView) (animator)).mFlipType ^ ipType.FLIP_HORIZONTAL.nativeInt;
            AdjustImageView.access$500(AdjustImageView.this).postScale(-1F, 1.0F, val$centerx, val$centery);
        } else
        {
            animator = AdjustImageView.this;
            animator.mFlipType = ((AdjustImageView) (animator)).mFlipType ^ ipType.FLIP_VERTICAL.nativeInt;
            AdjustImageView.access$500(AdjustImageView.this).postScale(1.0F, -1F, val$centerx, val$centery);
        }
        AdjustImageView.access$600(AdjustImageView.this).postRotate((float)(-mRotation * 2D), val$centerx, val$centery);
        mRotation = Point2D.angle360(AdjustImageView.access$700(AdjustImageView.this, AdjustImageView.access$600(AdjustImageView.this)));
        AdjustImageView.access$400(AdjustImageView.this).reset();
        invalidate();
        printDetails();
        mRunning = false;
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

    ipType()
    {
        this$0 = final_adjustimageview;
        val$horizontal = flag;
        val$centerx = f;
        val$centery = F.this;
        super();
    }
}
