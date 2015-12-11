// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package com.comcast.cim.android.view.common:
//            Fade

class init> extends AnimatorListenerAdapter
{

    final Fade this$0;
    final View val$view;
    final int val$visibility;

    public void onAnimationEnd(Animator animator)
    {
        val$view.setAlpha(1.0F);
        val$view.setVisibility(val$visibility);
        val$view.animate().setListener(null);
    }

    ()
    {
        this$0 = final_fade;
        val$view = view1;
        val$visibility = I.this;
        super();
    }
}
