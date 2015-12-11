// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.groupon.service.OnBoardingService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.operations.ClearCountryForMxUsers;
import com.groupon.util.ArraySharedPreferences;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretOnboardingFragment extends BaseSecretSettingsFragment
{
    private class ClearCountryForMxPreferenceClickListener
        implements android.preference.Preference.OnPreferenceClickListener
    {

        final SecretOnboardingFragment this$0;

        public boolean onPreferenceClick(Preference preference)
        {
            preference = new ClearCountryForMxUsers();
            RoboGuice.getInjector(getActivity()).injectMembers(preference);
            preference.run();
            return true;
        }

        private ClearCountryForMxPreferenceClickListener()
        {
            this$0 = SecretOnboardingFragment.this;
            super();
        }

    }

    private class ClearDivisionPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final CheckBoxPreference division;
        final SecretOnboardingFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (obj != null && ((Boolean)obj).booleanValue())
            {
                ((CurrentDivisionManager)currentDivisionManager.get()).clearCurrentDivision();
                division.setChecked(true);
                Toast.makeText(getActivity(), "Division info cleared.", 0).show();
            }
            return true;
        }

        public ClearDivisionPreferenceChangeListener(CheckBoxPreference checkboxpreference)
        {
            this$0 = SecretOnboardingFragment.this;
            super();
            division = checkboxpreference;
        }
    }

    private class CompletedOnboardingPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
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
            ((OnBoardingService)onBoardingService.get()).setShowForcedOnBoarding(flag);
            completedOnboarding.setChecked(flag);
            if (!flag)
            {
                loginPrefs.edit().remove("email").remove("prefilledZipcode").remove("zip_code").apply();
            }
            return true;
        }

        public CompletedOnboardingPreferenceChangeListener(CheckBoxPreference checkboxpreference)
        {
            this$0 = SecretOnboardingFragment.this;
            super();
            completedOnboarding = checkboxpreference;
        }
    }


    public static final String TAG = com/groupon/fragment/SecretOnboardingFragment.getName();
    private Lazy currentDivisionManager;
    protected ArraySharedPreferences loginPrefs;
    private Lazy onBoardingService;

    public SecretOnboardingFragment()
    {
    }

    public void init()
    {
        super.init();
        onBoardingService = new Lazy(getActivity()) {

            final SecretOnboardingFragment this$0;

            
            {
                this$0 = SecretOnboardingFragment.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(getActivity()) {

            final SecretOnboardingFragment this$0;

            
            {
                this$0 = SecretOnboardingFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Force Show Onboarding");
        bundle.setChecked(((OnBoardingService)onBoardingService.get()).shouldShowForcedOnBoarding());
        bundle.setOnPreferenceChangeListener(new CompletedOnboardingPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Facebook Login Enabled");
        bundle.setSummary("Allow logging in via facebook");
        bundle.setDefaultValue(Boolean.valueOf(true));
        bundle.setKey("facebookLoginEnabled");
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        bundle.setTitle("Check to clear current division");
        bundle.setChecked(false);
        bundle.setOnPreferenceChangeListener(new ClearDivisionPreferenceChangeListener(bundle));
        getPreferenceScreen().addPreference(bundle);
        bundle = new Preference(getActivity());
        bundle.setTitle("Clear country for MX users.");
        bundle.setSummary("Force stop app to simulate upgrade.");
        bundle.setOnPreferenceClickListener(new ClearCountryForMxPreferenceClickListener());
        getPreferenceScreen().addPreference(bundle);
    }



}
