// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            FeaturePointGuideView, FPSampleController

class a
    implements android.view.animation.ner
{

    final FeaturePointGuideView a;

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(4);
        FeaturePointGuideView.g(a).b();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (FeaturePointGuideView featurepointguideview)
    {
        a = featurepointguideview;
        super();
    }
}
