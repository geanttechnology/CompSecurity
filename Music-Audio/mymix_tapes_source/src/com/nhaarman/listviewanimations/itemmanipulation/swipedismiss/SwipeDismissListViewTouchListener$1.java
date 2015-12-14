// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeDismissListViewTouchListener

class ndingDismissData extends AnimatorListenerAdapter
{

    final SwipeDismissListViewTouchListener this$0;
    final ndingDismissData val$pendingDismissData;

    public void onAnimationEnd(Animator animator)
    {
        onDismiss(val$pendingDismissData);
    }

    ndingDismissData()
    {
        this$0 = final_swipedismisslistviewtouchlistener;
        val$pendingDismissData = ndingDismissData.this;
        super();
    }
}
