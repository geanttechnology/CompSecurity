// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            AnimateAdditionAdapter, InsertQueue

class val.position extends AnimatorListenerAdapter
{

    final AnimateAdditionAdapter this$0;
    final int val$position;

    public void onAnimationEnd(Animator animator)
    {
        AnimateAdditionAdapter.access$000(AnimateAdditionAdapter.this).removeActiveIndex(val$position);
    }

    ()
    {
        this$0 = final_animateadditionadapter;
        val$position = I.this;
        super();
    }
}
