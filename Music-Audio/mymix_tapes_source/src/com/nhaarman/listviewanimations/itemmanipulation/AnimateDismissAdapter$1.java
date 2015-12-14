// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import java.util.List;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            AnimateDismissAdapter

class val.positionsCopy extends AnimatorListenerAdapter
{

    final AnimateDismissAdapter this$0;
    final List val$positionsCopy;

    public void onAnimationEnd(Animator animator)
    {
        AnimateDismissAdapter.access$000(AnimateDismissAdapter.this, val$positionsCopy);
    }

    ()
    {
        this$0 = final_animatedismissadapter;
        val$positionsCopy = List.this;
        super();
    }
}
