// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package com.ebay.mobile.widget:
//            SwipeDismissListViewTouchListener

class val.position extends AnimatorListenerAdapter
{

    final SwipeDismissListViewTouchListener this$0;
    final int val$position;
    final View val$swipeableView;

    public void onAnimationEnd(Animator animator)
    {
        val$swipeableView.animate().setListener(null);
        SwipeDismissListViewTouchListener.access$100(SwipeDismissListViewTouchListener.this).onDismiss(SwipeDismissListViewTouchListener.access$000(SwipeDismissListViewTouchListener.this), val$position);
    }

    smissCallbacks()
    {
        this$0 = final_swipedismisslistviewtouchlistener;
        val$swipeableView = view;
        val$position = I.this;
        super();
    }
}
