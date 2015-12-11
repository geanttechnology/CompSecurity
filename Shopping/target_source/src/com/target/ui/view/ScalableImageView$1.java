// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.view:
//            ScalableImageView

class this._cls0
    implements android.animation.orUpdateListener
{

    PointF lastTranslation;
    final ScalableImageView this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (ScalableImageView.b(ScalableImageView.this).isIdentity())
        {
            q.a(ScalableImageView.TAG, "Identity matrix while animating");
            return;
        } else
        {
            ScalableImageView.b(ScalableImageView.this).set(ScalableImageView.a(ScalableImageView.this));
            float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
            float f1 = getX();
            float f2 = getWidth();
            float f3 = getY();
            float f4 = getHeight();
            ScalableImageView.b(ScalableImageView.this).postScale(f, f, f1 + f2 * 0.5F, f3 + f4 * 0.5F);
            f = valueanimator.getAnimatedFraction();
            valueanimator = lastTranslation;
            valueanimator.x = ((PointF) (valueanimator)).x * (1.0F - f);
            valueanimator = lastTranslation;
            valueanimator.y = (1.0F - f) * ((PointF) (valueanimator)).y;
            ScalableImageView.b(ScalableImageView.this).postTranslate(lastTranslation.x, lastTranslation.y);
            setImageMatrix(ScalableImageView.b(ScalableImageView.this));
            return;
        }
    }

    rUpdateListener()
    {
        this$0 = ScalableImageView.this;
        super();
        lastTranslation = new PointF(ScalableImageView.a(ScalableImageView.this).x, ScalableImageView.a(ScalableImageView.this).y);
    }
}
