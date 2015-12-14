// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import com.aviary.android.feather.library.graphics.Point2D;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

class this._cls0
    implements com.nineoldandroids.animation.atorUpdateListener
{

    final AdjustImageView this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        mRotation = Point2D.angle360(f);
        AdjustImageView.access$200(AdjustImageView.this, mRotation, false);
        initStraighten = true;
        invalidate();
    }

    teListener()
    {
        this$0 = AdjustImageView.this;
        super();
    }
}
