// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity.transition;

import android.transition.Transition;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.groupon.util.transitions.TransitionListenerAdapter;

// Referenced classes of package com.groupon.activity.transition:
//            HotelDetailsTransitionController

class this._cls0 extends TransitionListenerAdapter
{

    final HotelDetailsTransitionController this$0;

    public void onTransitionStart(Transition transition)
    {
        getViewByViewId(0x7f100394).animate().alpha(0.0F).setDuration(200L);
    }

    ()
    {
        this$0 = HotelDetailsTransitionController.this;
        super();
    }
}
