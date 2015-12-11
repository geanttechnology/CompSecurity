// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.app.Activity;
import android.content.res.Resources;
import android.transition.Transition;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.groupon.util.Function0;
import com.groupon.util.LayoutUtil;
import com.groupon.util.transitions.TransitionListenerAdapter;

// Referenced classes of package com.groupon.activity.transition:
//            HotelDetailsTransitionController

class val.onTransitionEnded extends TransitionListenerAdapter
{

    final HotelDetailsTransitionController this$0;
    final View val$contentView;
    final Function0 val$onTransitionEnded;
    final View val$toolbar;

    public void onTransitionEnd(Transition transition)
    {
        if (!isReturning)
        {
            val$contentView.setBackgroundColor(activity.getResources().getColor(0x7f0e0013));
            if (!layoutUtil.isLandscape())
            {
                val$toolbar.animate().alpha(1.0F).setDuration(400L).setStartDelay(600L);
            }
            if (val$onTransitionEnded != null)
            {
                val$onTransitionEnded.execute();
            }
        }
    }

    ()
    {
        this$0 = final_hoteldetailstransitioncontroller;
        val$contentView = view;
        val$toolbar = view1;
        val$onTransitionEnded = Function0.this;
        super();
    }
}
