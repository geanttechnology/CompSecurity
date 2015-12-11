// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.groupon.service.OnBoardingService;
import com.groupon.util.ArraySharedPreferences;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretOnboardingFragment

private class completedOnboarding
    implements android.preference.r
{

    private final CheckBoxPreference completedOnboarding;
    final SecretOnboardingFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        boolean flag;
        if (obj != null && ((Boolean)obj).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((OnBoardingService)SecretOnboardingFragment.access$100(SecretOnboardingFragment.this).get()).setShowForcedOnBoarding(flag);
        completedOnboarding.setChecked(flag);
        if (!flag)
        {
            loginPrefs.edit().completedOnboarding("email").completedOnboarding("prefilledZipcode").completedOnboarding("zip_code").completedOnboarding();
        }
        return true;
    }

    public (CheckBoxPreference checkboxpreference)
    {
        this$0 = SecretOnboardingFragment.this;
        super();
        completedOnboarding = checkboxpreference;
    }
}
