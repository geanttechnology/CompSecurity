// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.github.rahatarmanahmed.cpv:
//            CircularProgressView, CircularProgressViewListener

class val.currentProgress extends AnimatorListenerAdapter
{

    final CircularProgressView this$0;
    final float val$currentProgress;

    public void onAnimationEnd(Animator animator)
    {
        for (animator = CircularProgressView.access$100(CircularProgressView.this).iterator(); animator.hasNext(); ((CircularProgressViewListener)animator.next()).onProgressUpdateEnd(val$currentProgress)) { }
    }

    tener()
    {
        this$0 = final_circularprogressview;
        val$currentProgress = F.this;
        super();
    }
}
