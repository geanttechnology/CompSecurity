// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeDismissListViewTouchListener

class this._cls0 extends AnimatorListenerAdapter
{

    final SwipeDismissListViewTouchListener this$0;

    public void onAnimationEnd(Animator animator)
    {
        finalizeDismiss();
    }

    ()
    {
        this$0 = SwipeDismissListViewTouchListener.this;
        super();
    }
}
