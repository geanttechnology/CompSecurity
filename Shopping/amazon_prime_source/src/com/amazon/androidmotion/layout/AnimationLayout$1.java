// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.amazon.androidmotion.layout:
//            AnimationLayout

class val.view extends AnimatorListenerAdapter
{

    final AnimationLayout this$0;
    final View val$view;

    public void onAnimationEnd(Animator animator)
    {
        if (hasView(val$view))
        {
            removeView(val$view);
        }
    }

    ()
    {
        this$0 = final_animationlayout;
        val$view = View.this;
        super();
    }
}
