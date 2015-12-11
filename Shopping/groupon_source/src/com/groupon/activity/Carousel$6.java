// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Carousel

class erAdapter extends AnimatorListenerAdapter
{

    final Carousel this$0;
    final float val$initialVisibility;
    final View val$messagesIndicator;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        if (val$initialVisibility == 0.0F)
        {
            val$messagesIndicator.setVisibility(8);
        }
    }

    erAdapter()
    {
        this$0 = final_carousel;
        val$initialVisibility = f;
        val$messagesIndicator = View.this;
        super();
    }
}
