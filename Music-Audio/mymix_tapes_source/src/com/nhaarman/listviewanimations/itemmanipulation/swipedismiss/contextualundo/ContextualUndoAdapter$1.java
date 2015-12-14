// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.contextualundo:
//            ContextualUndoAdapter, ContextualUndoView

class val.dismissPosition extends AnimatorListenerAdapter
{

    final ContextualUndoAdapter this$0;
    final int val$dismissPosition;
    final View val$view;

    public void onAnimationEnd(Animator animator)
    {
        onViewSwiped(((ContextualUndoView)val$view).getItemId(), val$dismissPosition);
    }

    ()
    {
        this$0 = final_contextualundoadapter;
        val$view = view1;
        val$dismissPosition = I.this;
        super();
    }
}
