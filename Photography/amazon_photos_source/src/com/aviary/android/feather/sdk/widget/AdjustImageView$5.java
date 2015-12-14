// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class val.centery
    implements com.nineoldandroids.animation.atorUpdateListener
{

    final AdjustImageView this$0;
    final Camera val$camera;
    final float val$centerx;
    final float val$centery;
    final boolean val$horizontal;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        if (AdjustImageView.access$300(AdjustImageView.this))
        {
            val$camera.save();
            if (val$horizontal)
            {
                val$camera.rotateY(f);
            } else
            {
                val$camera.rotateX(f);
            }
            val$camera.getMatrix(AdjustImageView.access$400(AdjustImageView.this));
            val$camera.restore();
            AdjustImageView.access$400(AdjustImageView.this).preTranslate(-val$centerx, -val$centery);
            AdjustImageView.access$400(AdjustImageView.this).postTranslate(val$centerx, val$centery);
        } else
        if (val$horizontal)
        {
            AdjustImageView.access$400(AdjustImageView.this).setScale(f, 1.0F, val$centerx, val$centery);
        } else
        {
            AdjustImageView.access$400(AdjustImageView.this).setScale(1.0F, f, val$centerx, val$centery);
        }
        invalidate();
    }

    teListener()
    {
        this$0 = final_adjustimageview;
        val$camera = camera1;
        val$horizontal = flag;
        val$centerx = f;
        val$centery = F.this;
        super();
    }
}
