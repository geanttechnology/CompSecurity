// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA2

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, OnBoardingMultiStepA2 onboardingmultistepa2, Object obj)
    {
        onboardingmultistepa2.done = (SpinnerButton)ewbinder.e((View)ewbinder.w(obj, 0x7f100478, "field 'done'"), 0x7f100478, "field 'done'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (OnBoardingMultiStepA2)obj, obj1);
    }

    public void unbind(OnBoardingMultiStepA2 onboardingmultistepa2)
    {
        onboardingmultistepa2.done = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((OnBoardingMultiStepA2)obj);
    }

    public ()
    {
    }
}
