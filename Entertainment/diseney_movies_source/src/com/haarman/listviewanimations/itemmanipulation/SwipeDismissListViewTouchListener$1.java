// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation:
//            SwipeDismissListViewTouchListener

class val.downPosition extends AnimatorListenerAdapter
{

    final SwipeDismissListViewTouchListener this$0;
    private final int val$downPosition;
    private final View val$downView;

    public void onAnimationEnd(Animator animator)
    {
        SwipeDismissListViewTouchListener.access$0(SwipeDismissListViewTouchListener.this, val$downView, val$downPosition);
    }

    Y()
    {
        this$0 = final_swipedismisslistviewtouchlistener;
        val$downView = view;
        val$downPosition = I.this;
        super();
    }
}
