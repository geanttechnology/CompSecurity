// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.haarman.listviewanimations.itemmanipulation.contextualundo:
//            ContextualUndoListViewTouchListener

class val.downPosition extends AnimatorListenerAdapter
{

    final ContextualUndoListViewTouchListener this$0;
    private final int val$downPosition;
    private final View val$downView;

    public void onAnimationEnd(Animator animator)
    {
        ContextualUndoListViewTouchListener.access$1(ContextualUndoListViewTouchListener.this).onViewSwiped(val$downView, val$downPosition);
    }

    llback()
    {
        this$0 = final_contextualundolistviewtouchlistener;
        val$downView = view;
        val$downPosition = I.this;
        super();
    }
}
