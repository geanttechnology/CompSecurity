// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.animation.ValueAnimator;
import android.graphics.Rect;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            FeaturePointGuideView

class a
    implements android.animation.dateListener
{

    final FeaturePointGuideView a;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = valueanimator.getAnimatedFraction();
        FeaturePointGuideView.a(a).left = (int)((float)(FeaturePointGuideView.b(a).left - FeaturePointGuideView.c(a).left) * f + (float)FeaturePointGuideView.c(a).left);
        FeaturePointGuideView.a(a).top = (int)((float)(FeaturePointGuideView.b(a).top - FeaturePointGuideView.c(a).top) * f + (float)FeaturePointGuideView.c(a).top);
        FeaturePointGuideView.a(a).right = (int)((float)(FeaturePointGuideView.b(a).right - FeaturePointGuideView.c(a).right) * f + (float)FeaturePointGuideView.c(a).right);
        FeaturePointGuideView.a(a).bottom = (int)(f * (float)(FeaturePointGuideView.b(a).bottom - FeaturePointGuideView.c(a).bottom) + (float)FeaturePointGuideView.c(a).bottom);
        if (FeaturePointGuideView.a(a).left < 0)
        {
            FeaturePointGuideView.a(a).right = FeaturePointGuideView.a(a).right - FeaturePointGuideView.a(a).left;
            FeaturePointGuideView.a(a).left = 0;
        } else
        if (FeaturePointGuideView.a(a).right > FeaturePointGuideView.d(a).right)
        {
            FeaturePointGuideView.a(a).left = FeaturePointGuideView.a(a).left - (FeaturePointGuideView.a(a).right - FeaturePointGuideView.d(a).right);
            FeaturePointGuideView.a(a).right = FeaturePointGuideView.d(a).right;
        }
        if (FeaturePointGuideView.a(a).top < 0)
        {
            FeaturePointGuideView.a(a).bottom = FeaturePointGuideView.a(a).bottom - FeaturePointGuideView.a(a).top;
            FeaturePointGuideView.a(a).top = 0;
        } else
        if (FeaturePointGuideView.a(a).bottom > FeaturePointGuideView.d(a).bottom)
        {
            FeaturePointGuideView.a(a).top = FeaturePointGuideView.a(a).top - (FeaturePointGuideView.a(a).bottom - FeaturePointGuideView.d(a).bottom);
            FeaturePointGuideView.a(a).bottom = FeaturePointGuideView.d(a).bottom;
        }
        a.invalidate();
    }

    (FeaturePointGuideView featurepointguideview)
    {
        a = featurepointguideview;
        super();
    }
}
