// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import com.nineoldandroids.animation.Animator;

// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

class val.from
    implements com.nineoldandroids.animation.rListener
{

    final AviaryOverlay this$0;
    final String val$from;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (val$from != null)
        {
            trackTutorialClosed(val$from);
        }
        dismiss();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = final_aviaryoverlay;
        val$from = String.this;
        super();
    }
}
