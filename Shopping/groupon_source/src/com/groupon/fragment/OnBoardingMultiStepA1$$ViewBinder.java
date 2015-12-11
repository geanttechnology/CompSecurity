// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.groupon.view.SpinnerButton;
import com.groupon.view.TypewriterTextView;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, OnBoardingMultiStepA1 onboardingmultistepa1, Object obj)
    {
        onboardingmultistepa1.inputField = (EditText)ewbinder.utField((View)ewbinder.w(obj, 0x7f100006, null), 0x7f100006, "field 'inputField'");
        onboardingmultistepa1.continueButton = (SpinnerButton)ewbinder.tinueButton((View)ewbinder.w(obj, 0x7f100477, "field 'continueButton'"), 0x7f100477, "field 'continueButton'");
        onboardingmultistepa1.categoriesContainer = (View)ewbinder.w(obj, 0x7f100473, null);
        onboardingmultistepa1.skipOnboarding = (View)ewbinder.w(obj, 0x7f100475, null);
        onboardingmultistepa1.userInputContainer = (RelativeLayout)ewbinder.rInputContainer((View)ewbinder.w(obj, 0x7f10036d, null), 0x7f10036d, "field 'userInputContainer'");
        onboardingmultistepa1.containerText = (TypewriterTextView)ewbinder.tainerText((View)ewbinder.w(obj, 0x7f100474, null), 0x7f100474, "field 'containerText'");
        onboardingmultistepa1.categoryCircleIcon = (View)ewbinder.w(obj, 0x7f10046e, null);
        onboardingmultistepa1.forkIcon = (View)ewbinder.w(obj, 0x7f10046f, null);
        onboardingmultistepa1.knifeIcon = (View)ewbinder.w(obj, 0x7f100470, null);
        onboardingmultistepa1.shoppingIcon = (View)ewbinder.w(obj, 0x7f100471, null);
        onboardingmultistepa1.travelIcon = (View)ewbinder.w(obj, 0x7f100472, null);
        onboardingmultistepa1.bottomContainer = (View)ewbinder.w(obj, 0x7f100366, null);
        ewbinder = ewbinder.w(obj).getResources();
        onboardingmultistepa1.lunch = ewbinder.getString(0x7f08025f);
        onboardingmultistepa1.reservations = ewbinder.getString(0x7f08032f);
        onboardingmultistepa1.travel = ewbinder.getString(0x7f0803e7);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (OnBoardingMultiStepA1)obj, obj1);
    }

    public void unbind(OnBoardingMultiStepA1 onboardingmultistepa1)
    {
        onboardingmultistepa1.inputField = null;
        onboardingmultistepa1.continueButton = null;
        onboardingmultistepa1.categoriesContainer = null;
        onboardingmultistepa1.skipOnboarding = null;
        onboardingmultistepa1.userInputContainer = null;
        onboardingmultistepa1.containerText = null;
        onboardingmultistepa1.categoryCircleIcon = null;
        onboardingmultistepa1.forkIcon = null;
        onboardingmultistepa1.knifeIcon = null;
        onboardingmultistepa1.shoppingIcon = null;
        onboardingmultistepa1.travelIcon = null;
        onboardingmultistepa1.bottomContainer = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((OnBoardingMultiStepA1)obj);
    }

    public ()
    {
    }
}
