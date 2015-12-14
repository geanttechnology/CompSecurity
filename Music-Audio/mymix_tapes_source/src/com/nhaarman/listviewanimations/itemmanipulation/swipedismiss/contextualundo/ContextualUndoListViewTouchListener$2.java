// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoListViewTouchListener

class val.downPosition extends AnimatorListenerAdapter
{

    final ContextualUndoListViewTouchListener this$0;
    final int val$downPosition;
    final long val$itemId;

    public void onAnimationEnd(Animator animator)
    {
        ContextualUndoListViewTouchListener.access$100(ContextualUndoListViewTouchListener.this).onViewSwiped(val$itemId, val$downPosition);
    }

    llback()
    {
        this$0 = final_contextualundolistviewtouchlistener;
        val$itemId = l;
        val$downPosition = I.this;
        super();
    }
}
