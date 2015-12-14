// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.graphics.RectF;
import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            FeaturePointGuideView

class b extends android.view.GestureDetector.SimpleOnGestureListener
{

    final FeaturePointGuideView a;

    b(FeaturePointGuideView featurepointguideview)
    {
        a = featurepointguideview;
        super();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        return FeaturePointGuideView.e(a).contains(f, f1);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        if (FeaturePointGuideView.e(a).contains(f, f1))
        {
            a.startAnimation(FeaturePointGuideView.f(a));
            return true;
        } else
        {
            return false;
        }
    }
}
