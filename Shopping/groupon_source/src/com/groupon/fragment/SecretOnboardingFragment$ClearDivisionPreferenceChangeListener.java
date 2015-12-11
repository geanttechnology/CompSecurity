// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.widget.Toast;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretOnboardingFragment

private class division
    implements android.preference.r
{

    private final CheckBoxPreference division;
    final SecretOnboardingFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (obj != null && ((Boolean)obj).booleanValue())
        {
            ((CurrentDivisionManager)SecretOnboardingFragment.access$200(SecretOnboardingFragment.this).get()).clearCurrentDivision();
            division.setChecked(true);
            Toast.makeText(getActivity(), "Division info cleared.", 0).show();
        }
        return true;
    }

    public Y(CheckBoxPreference checkboxpreference)
    {
        this$0 = SecretOnboardingFragment.this;
        super();
        division = checkboxpreference;
    }
}
