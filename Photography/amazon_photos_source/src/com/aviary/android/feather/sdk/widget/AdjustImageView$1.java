// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class val.newPosition
    implements com.nineoldandroids.animation.atorUpdateListener
{

    final AdjustImageView this$0;
    final float val$deltax;
    final double val$newPosition;
    final double val$srcRotation;
    final int val$srcx;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        mStraightenDrawable.setBounds((int)(((float)val$srcx + val$deltax * f) - (float)handleWidth), (int)(imageCaptureRegion.bottom - (float)handleHeight), (int)((float)val$srcx + val$deltax * f + (float)handleWidth), (int)(imageCaptureRegion.bottom + (float)handleHeight));
        AdjustImageView.access$000(AdjustImageView.this, val$srcRotation + val$newPosition * (double)f);
        invalidate();
    }

    teListener()
    {
        this$0 = final_adjustimageview;
        val$srcx = i;
        val$deltax = f;
        val$srcRotation = d;
        val$newPosition = D.this;
        super();
    }
}
