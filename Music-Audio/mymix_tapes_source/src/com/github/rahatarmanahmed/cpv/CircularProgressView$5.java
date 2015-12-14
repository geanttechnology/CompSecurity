// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.github.rahatarmanahmed.cpv:
//            CircularProgressView

class wasCancelled extends AnimatorListenerAdapter
{

    final CircularProgressView this$0;
    boolean wasCancelled;

    public void onAnimationCancel(Animator animator)
    {
        wasCancelled = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!wasCancelled)
        {
            resetAnimation();
        }
    }

    ()
    {
        this$0 = CircularProgressView.this;
        super();
        wasCancelled = false;
    }
}
