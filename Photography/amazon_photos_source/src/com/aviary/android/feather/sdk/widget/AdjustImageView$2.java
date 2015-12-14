// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class val.destRotation
    implements com.nineoldandroids.animation.istener
{

    final AdjustImageView this$0;
    final double val$destRotation;
    final int val$newx;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        mStraightenDrawable.setBounds(val$newx - handleWidth, (int)(imageCaptureRegion.bottom - (float)handleHeight), val$newx + handleWidth, (int)(imageCaptureRegion.bottom + (float)handleHeight));
        AdjustImageView.access$000(AdjustImageView.this, val$destRotation);
        mRunning = false;
        invalidate();
        if (isReset)
        {
            straightenStarted = false;
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
        val$newx = i;
        val$destRotation = D.this;
        super();
    }
}
