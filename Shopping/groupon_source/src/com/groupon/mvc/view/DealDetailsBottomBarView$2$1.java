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

class this._cls1 extends AnimatorListenerAdapter
{

    final is._cls0 this$1;

    public void onAnimationEnd(Animator animator)
    {
        if (animationFinishedCallback != null)
        {
            animationFinishedCallback.onBottomBarAnimationFinished(_fld0);
        }
    }

    Listener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/mvc/view/DealDetailsBottomBarView$2

/* anonymous class */
    class DealDetailsBottomBarView._cls2
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final DealDetailsBottomBarView this$0;
        final OnBottomBarAnimationFinishedListener val$animationFinishedCallback;

        public void onGlobalLayout()
        {
            float f = getY();
            setY(getBottom());
            setVisibility(0);
            animate().setListener(new DealDetailsBottomBarView._cls2._cls1()).y(f).setDuration(200L).setInterpolator(new DecelerateInterpolator());
            bottomBarAnimationShown = true;
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                viewtreeobserver.removeOnGlobalLayoutListener(this);
            }
        }

            
            {
                this$0 = final_dealdetailsbottombarview;
                animationFinishedCallback = OnBottomBarAnimationFinishedListener.this;
                super();
            }
    }

}
