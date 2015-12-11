// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.adapter:
//            FilterAdapter

class apter extends AnimatorListenerAdapter
{

    final FilterAdapter this$0;
    final cetHeaderViewHolder val$holder;

    public void onAnimationCancel(Animator animator)
    {
        val$holder.isAnimating.set(false);
    }

    public void onAnimationEnd(Animator animator)
    {
        val$holder.isAnimating.set(false);
    }

    public void onAnimationStart(Animator animator)
    {
        val$holder.isAnimating.set(true);
    }

    cetHeaderViewHolder()
    {
        this$0 = final_filteradapter;
        val$holder = cetHeaderViewHolder.this;
        super();
    }
}
