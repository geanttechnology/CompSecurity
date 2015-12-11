// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.groupon.view.TypewriterTextView;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class it> extends AnimatorListenerAdapter
{

    final OnBoardingMultiStepA1 this$0;

    public void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        containerText.setCharacterDelay(50L);
        containerText.animateInText(lunch);
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
