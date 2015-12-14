// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

class this._cls0
    implements com.nineoldandroids.animation.rListener
{

    final AviaryOverlay this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        AviaryOverlay.access$002(AviaryOverlay.this, true);
        inAnimationCompleted();
        AviaryOverlay.access$100(AviaryOverlay.this);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        setVisibility(0);
    }

    ()
    {
        this$0 = AviaryOverlay.this;
        super();
    }
}
