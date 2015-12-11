// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;

// Referenced classes of package com.groupon.mvc.view:
//            DealDetailsBottomBarView

class  extends AnimatorListenerAdapter
{

    final DealDetailsBottomBarView this$0;
    final OnBottomBarAnimationFinishedListener val$animationFinishedCallback;

    public void onAnimationEnd(Animator animator)
    {
        if (val$animationFinishedCallback != null)
        {
            val$animationFinishedCallback.onBottomBarAnimationFinished(DealDetailsBottomBarView.this);
        }
    }

    edListener()
    {
        this$0 = final_dealdetailsbottombarview;
        val$animationFinishedCallback = OnBottomBarAnimationFinishedListener.this;
        super();
    }
}
