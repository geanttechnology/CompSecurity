// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class it> extends AnimatorListenerAdapter
{

    final OnBoardingMultiStepA1 this$0;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        if (currentCountryManager.getCurrentCountry().shouldHideEmailSubscriptionInOnBoarding())
        {
            OnBoardingMultiStepA1.access$500(OnBoardingMultiStepA1.this);
            return;
        } else
        {
            OnBoardingMultiStepA1.access$800(OnBoardingMultiStepA1.this);
            return;
        }
    }

    tCountryManager()
    {
        this$0 = OnBoardingMultiStepA1.this;
        super();
    }
}
