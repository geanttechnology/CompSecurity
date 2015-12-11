// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.groupon.events.EmailSetEvent;
import com.groupon.events.FacebookSetEvent;
import com.groupon.events.ZipCodeSelectedEvent;
import com.groupon.fragment.OnBoardingMultiStepA1;
import com.groupon.fragment.OnBoardingMultiStepA1Intl;
import com.groupon.fragment.OnBoardingMultiStepA2;
import com.groupon.models.country.Country;
import com.groupon.service.OnBoardingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.LoggingUtils;
import com.squareup.otto.Bus;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, DontRestartOnConfigurationChange, IntentFactory

public class OnboardingMultiStep extends GrouponFragmentActivity
    implements DontRestartOnConfigurationChange
{
    private class MultiStepEventListener
    {

        final OnboardingMultiStep this$0;

        public void onEmailSetEvent(EmailSetEvent emailsetevent)
        {
            loginPrefs.edit().putString("email", emailsetevent.getEmail()).apply();
        }

        public void onFacebookSetEvent(FacebookSetEvent facebooksetevent)
        {
            loginPrefs.edit().putBoolean("onboardFacebook", facebooksetevent.isUsingFacebook()).apply();
        }

        public void onNextStepEvent(NextStepEvent nextstepevent)
        {
            showNextStep();
        }

        public void onZipCodeSelectedEvent(ZipCodeSelectedEvent zipcodeselectedevent)
        {
            loginPrefs.edit().putString("zip_code", zipcodeselectedevent.getZipcode()).apply();
        }

        private MultiStepEventListener()
        {
            this$0 = OnboardingMultiStep.this;
            super();
        }

    }

    public static class NextStepEvent
    {

        public NextStepEvent()
        {
        }
    }


    private static final int LAST_STEP = 2;
    private static final int STEP_1 = 0;
    private static final int STEP_2 = 1;
    private static final int STEP_3 = 2;
    private Bus bus;
    private CurrentCountryManager currentCountryManager;
    private int currentStep;
    Boolean includeEmail;
    private IntentFactory intentFactory;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private ArraySharedPreferences loginPrefs;
    private MultiStepEventListener multiStepEventListener;
    private OnBoardingService onBoardingService;
    private boolean showIntlOnBoarding;

    public OnboardingMultiStep()
    {
        includeEmail = Boolean.valueOf(false);
        currentStep = 0;
        multiStepEventListener = new MultiStepEventListener();
    }

    private void clearOnboardingPrefs()
    {
        loginPrefs.edit().remove("prefilledZipcode").remove("zip_code").remove("onboardFacebook").remove("email").apply();
    }

    private void doLogging()
    {
        logger.logOnboard("", Boolean.toString(loginPrefs.getBoolean("prefilledZipcode", false)), getEmailTrackingCode(), getZipCodeTrackingCode(), "did_not_ask", Logger.NULL_NST_FIELD);
    }

    private void doLoggingWhenSkipped()
    {
        switch (currentStep)
        {
        default:
            return;

        case 0: // '\0'
            logger.logOnboard("", Boolean.toString(loginPrefs.getBoolean("prefilledZipcode", false)), "skipped", "skipped", "did_not_ask", Logger.NULL_NST_FIELD);
            logger.logClick("", "skipped", com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName(), "");
            loggingUtils.logOnBoardingFinished();
            return;

        case 1: // '\001'
            logger.logOnboard("", Boolean.toString(loginPrefs.getBoolean("prefilledZipcode", false)), "skipped", getZipCodeTrackingCode(), "did_not_ask", Logger.NULL_NST_FIELD);
            break;
        }
        logger.logClick("", "skipped", com/groupon/fragment/OnBoardingMultiStepA2.getSimpleName(), "");
        loggingUtils.logOnBoardingFinished();
    }

    private String getEmailTrackingCode()
    {
        if (loginPrefs.getBoolean("onboardFacebook", false))
        {
            return "fb";
        }
        if (Strings.notEmpty(loginPrefs.getString("email", "")))
        {
            return "user_input";
        }
        if (Boolean.TRUE.equals(includeEmail))
        {
            return "skipped";
        } else
        {
            return "did_not_ask";
        }
    }

    private String getZipCodeTrackingCode()
    {
        if (Strings.isEmpty(loginPrefs.getString("zip_code", "")))
        {
            return "skipped";
        } else
        {
            return "user_input";
        }
    }

    private void showFragmentForStep()
    {
        Object obj = getFragmentManager();
        FragmentTransaction fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
        Object obj1 = new Bundle();
        ((Bundle) (obj1)).putBoolean("includeEmail", Boolean.TRUE.equals(includeEmail));
        Ln.d((new StringBuilder()).append("Attempting to load step: ").append(currentStep).toString(), new Object[0]);
        int i = ((FragmentManager) (obj)).getBackStackEntryCount();
        if (i > 0)
        {
            obj = ((FragmentManager) (obj)).findFragmentByTag(((FragmentManager) (obj)).getBackStackEntryAt(i - 1).getName());
        } else
        {
            obj = null;
        }
        if (obj != null && i == currentStep + 1)
        {
            if (((Fragment) (obj)).isDetached())
            {
                fragmenttransaction.attach(((Fragment) (obj)));
            }
            return;
        }
        switch (currentStep)
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Oh nos! Should not have got here during onboarding, current step is: ").append(currentStep).toString());

        case 0: // '\0'
            if (showIntlOnBoarding)
            {
                ((Bundle) (obj1)).putString("zip_code", loginPrefs.getString("zip_code", ""));
            }
            Fragment fragment;
            if (showIntlOnBoarding)
            {
                fragment = OnBoardingMultiStepA1Intl.instantiate(this, com/groupon/fragment/OnBoardingMultiStepA1Intl.getName(), ((Bundle) (obj1)));
            } else
            {
                fragment = OnBoardingMultiStepA1.instantiate(this, com/groupon/fragment/OnBoardingMultiStepA1.getName(), ((Bundle) (obj1)));
            }
            obj1 = fragment.getClass().getName();
            fragmenttransaction.replace(0x7f100171, fragment, ((String) (obj1)));
            fragmenttransaction.addToBackStack(((String) (obj1)));
            fragmenttransaction.commitAllowingStateLoss();
            return;

        case 1: // '\001'
            if (Boolean.TRUE.equals(includeEmail))
            {
                Fragment fragment1 = OnBoardingMultiStepA2.instantiate(this, com/groupon/fragment/OnBoardingMultiStepA2.getName(), ((Bundle) (obj1)));
                fragmenttransaction.setCustomAnimations(0x10b0000, 0x10b0001);
                fragmenttransaction.replace(0x7f100171, fragment1, com/groupon/fragment/OnBoardingMultiStepA2.getName());
                fragmenttransaction.addToBackStack(com/groupon/fragment/OnBoardingMultiStepA2.getName());
                fragmenttransaction.commitAllowingStateLoss();
                return;
            } else
            {
                doLogging();
                showNextActivity();
                return;
            }

        case 2: // '\002'
            doLogging();
            showNextActivity();
            return;
        }
    }

    private void showNextActivity()
    {
        onBoardingService.setShowOnBoarding(false);
        startActivity(intentFactory.newSplashIntent(intentFactory.newCarouselIntent()));
        finish();
    }

    private void showNextStep()
    {
        if (currentStep < 2)
        {
            currentStep = currentStep + 1;
        }
        showFragmentForStep();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (loginPrefs.getBoolean("onboardFacebook", false))
        {
            currentStep = 1;
        }
    }

    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() == 1)
        {
            showNextActivity();
        } else
        {
            super.onBackPressed();
            if (currentStep > 0)
            {
                currentStep = currentStep - 1;
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030187);
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isUnitedStates())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showIntlOnBoarding = flag;
        bus.register(multiStepEventListener);
    }

    protected void onDestroy()
    {
        bus.unregister(multiStepEventListener);
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        currentStep = bundle.getInt("currentStep", 0);
    }

    protected void onResume()
    {
        super.onResume();
        showFragmentForStep();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("currentStep", currentStep);
    }

    public void onSkipClicked(View view)
    {
        doLoggingWhenSkipped();
        clearOnboardingPrefs();
        showNextActivity();
    }


}
