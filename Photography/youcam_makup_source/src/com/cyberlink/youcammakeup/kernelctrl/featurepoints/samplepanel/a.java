// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel:
//            FPSampleController, FeaturePointGuideView

class a extends android.view.GestureDetector.SimpleOnGestureListener
{

    final FPSampleController a;

    a(FPSampleController fpsamplecontroller)
    {
        a = fpsamplecontroller;
        super();
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        FPSampleController.a(a).c();
        return true;
    }
}
