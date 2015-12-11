// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.lifecycle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.amazon.androidmotion.lifecycle:
//            AnimatorTracker

class val.animator extends AnimatorListenerAdapter
{

    final AnimatorTracker this$0;
    final Animator val$animator;

    public void onAnimationEnd(Animator animator1)
    {
        remove(val$animator);
    }

    ()
    {
        this$0 = final_animatortracker;
        val$animator = Animator.this;
        super();
    }
}
