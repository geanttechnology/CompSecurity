// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.content.res.Resources;
import android.transition.Transition;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.groupon.callbacks.OnActivityTransitionFinishedListener;
import com.groupon.util.LayoutUtil;
import com.groupon.util.transitions.TransitionListenerAdapter;

// Referenced classes of package com.groupon.activity.transition:
//            DealDetailsRecyclerTransitionController

class val.transitionFinishedListener extends TransitionListenerAdapter
{

    final DealDetailsRecyclerTransitionController this$0;
    final View val$imageGradientOverlay;
    final View val$rootView;
    final View val$titleValuePriceSection;
    final View val$toolbar;
    final OnActivityTransitionFinishedListener val$transitionFinishedListener;

    public void onTransitionEnd(Transition transition)
    {
        transitionFinished = true;
        if (!isReturning)
        {
            val$rootView.setBackgroundColor(activity.getResources().getColor(0x7f0e0013));
            if (!layoutUtil.isLandscape())
            {
                val$toolbar.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
                if (val$imageGradientOverlay != null)
                {
                    val$imageGradientOverlay.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
                }
            }
            val$titleValuePriceSection.animate().alpha(1.0F).setDuration(400L);
            if (val$transitionFinishedListener != null)
            {
                val$transitionFinishedListener.onTransitionFinished();
            }
        }
    }

    ()
    {
        this$0 = final_dealdetailsrecyclertransitioncontroller;
        val$rootView = view;
        val$toolbar = view1;
        val$imageGradientOverlay = view2;
        val$titleValuePriceSection = view3;
        val$transitionFinishedListener = OnActivityTransitionFinishedListener.this;
        super();
    }
}
