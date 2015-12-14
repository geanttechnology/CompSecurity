// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.PointF;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewWithIntensity

class this._cls0
    implements com.nineoldandroids.animation.ateListener
{

    final ImageViewWithIntensity this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (ImageViewWithIntensity.access$100(ImageViewWithIntensity.this) == null)
        {
            return;
        } else
        {
            valueanimator = (Integer)valueanimator.getAnimatedValue();
            ImageViewWithIntensity.access$200(ImageViewWithIntensity.this, ImageViewWithIntensity.access$100(ImageViewWithIntensity.this).x, ImageViewWithIntensity.access$100(ImageViewWithIntensity.this).y + (float)valueanimator.intValue(), 0.0F, valueanimator.intValue(), false);
            return;
        }
    }

    ner()
    {
        this$0 = ImageViewWithIntensity.this;
        super();
    }
}
