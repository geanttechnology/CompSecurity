// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation;

import com.nineoldandroids.animation.Animator;
import java.util.List;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation:
//            AnimateDismissAdapter

class val.positionsCopy
    implements com.nineoldandroids.animation.r
{

    final AnimateDismissAdapter this$0;
    private final List val$positionsCopy;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        AnimateDismissAdapter.access$0(AnimateDismissAdapter.this, val$positionsCopy);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = final_animatedismissadapter;
        val$positionsCopy = List.this;
        super();
    }
}
