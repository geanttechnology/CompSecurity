// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class t> extends AnimatorListenerAdapter
{

    final OnBoardingMultiStepA1 this$0;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        if (categoriesContainer != null)
        {
            categoriesContainer.setVisibility(8);
        }
        if (inputField != null)
        {
            inputField.setFocusable(true);
            inputField.setFocusableInTouchMode(true);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        if (inputField != null)
        {
            inputField.setFocusable(false);
        }
    }

    ()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
