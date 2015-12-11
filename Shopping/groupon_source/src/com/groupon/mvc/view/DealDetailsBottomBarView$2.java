// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;

// Referenced classes of package com.groupon.mvc.view:
//            DealDetailsBottomBarView

class edListener
    implements android.view.youtListener
{

    final DealDetailsBottomBarView this$0;
    final OnBottomBarAnimationFinishedListener val$animationFinishedCallback;

    public void onGlobalLayout()
    {
        float f = getY();
        setY(getBottom());
        setVisibility(0);
        animate().setListener(new AnimatorListenerAdapter() {

            final DealDetailsBottomBarView._cls2 this$1;

            public void onAnimationEnd(Animator animator)
            {
                if (animationFinishedCallback != null)
                {
                    animationFinishedCallback.onBottomBarAnimationFinished(this$0);
                }
            }

            
            {
                this$1 = DealDetailsBottomBarView._cls2.this;
                super();
            }
        }).y(f).setDuration(200L).setInterpolator(new DecelerateInterpolator());
        bottomBarAnimationShown = true;
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.removeOnGlobalLayoutListener(this);
        }
    }

    edListener()
    {
        this$0 = final_dealdetailsbottombarview;
        val$animationFinishedCallback = OnBottomBarAnimationFinishedListener.this;
        super();
    }
}
