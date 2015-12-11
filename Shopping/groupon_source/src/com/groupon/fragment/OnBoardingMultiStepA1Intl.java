// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.events.EmailSetEvent;
import com.groupon.models.country.Country;
import com.groupon.models.emailsubscription.EmailSubscriptionContainer;
import com.groupon.service.EmailSubscriptionsService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ThanksUIUtil;
import com.groupon.view.SpinnerButton;
import com.squareup.otto.Bus;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

public class OnBoardingMultiStepA1Intl extends OnBoardingMultiStepA1
{

    private CurrentDivisionManager currentDivisionManager;
    private EmailSubscriptionsService emailSubscriptionsService;

    public OnBoardingMultiStepA1Intl()
    {
    }

    private boolean emailIsValid()
    {
        return com.groupon.Constants.RegularExpressions.EMAIL_ADDRESS.matcher(getEmailAddress()).matches();
    }

    private void fireEvents()
    {
        String s = Strings.toString(getEmailAddress());
        if (Strings.notEmpty(s) && !currentCountryManager.getCurrentCountry().shouldHideEmailSubscriptionInOnBoarding())
        {
            bus.post(new EmailSetEvent(s));
        }
        bus.post(new com.groupon.activity.OnboardingMultiStep.NextStepEvent());
    }

    private CharSequence getEmailAddress()
    {
        if (inputField != null)
        {
            return inputField.getText();
        } else
        {
            return null;
        }
    }

    private void goToNextStep()
    {
        if (!currentCountryManager.getCurrentCountry().shouldHideEmailSubscriptionInOnBoarding())
        {
            if (emailIsValid())
            {
                subscribeToDivision();
                return;
            } else
            {
                inputField.setError(getString(0x7f08015f));
                return;
            }
        } else
        {
            fireEvents();
            return;
        }
    }

    private void onContinueClicked()
    {
        if (categoriesContainer != null && categoriesContainer.getVisibility() == 0)
        {
            exitAnimationDelay = 0;
            stopCategoriesAnimation();
        } else
        {
            goToNextStep();
            if (inputField != null)
            {
                imm.hideSoftInputFromWindow(inputField.getWindowToken(), 0);
                return;
            }
        }
    }

    private void subscribeToDivision()
    {
        continueButton.startSpinning();
        continueButton.setEnabled(false);
        emailSubscriptionsService.addEmailSubscription(Strings.toString(getEmailAddress()), currentDivisionManager.getCurrentDivision(), new Function1() {

            final OnBoardingMultiStepA1Intl this$0;

            public void execute(EmailSubscriptionContainer emailsubscriptioncontainer)
            {
                (new ThanksUIUtil(continueButton.getContext())).showThanksForSubscriptionDialog(currentCountryManager.getCurrentCountry(), getEmailAddress().toString(), new android.content.DialogInterface.OnCancelListener() {

                    final _cls4 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        fireEvents();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((EmailSubscriptionContainer)obj);
            }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
        }, null, new Function0() {

            final OnBoardingMultiStepA1Intl this$0;

            public void execute()
            {
                continueButton.stopSpinning();
                continueButton.setEnabled(true);
            }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
        }, new Function0() {

            final OnBoardingMultiStepA1Intl this$0;

            public void execute()
            {
                logger.logGeneralEvent("onboarding", "", "email_subscription_failed", 0, Logger.NULL_NST_FIELD);
                fireEvents();
            }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
        });
    }

    protected android.view.View.OnClickListener getOnContinueClickListener()
    {
        return new android.view.View.OnClickListener() {

            final OnBoardingMultiStepA1Intl this$0;

            public void onClick(View view)
            {
                onContinueClicked();
            }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
        };
    }

    protected void inflateUserInputComponent()
    {
        View view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f030186, userInputContainer);
        inputField = (EditText)view.findViewById(0x7f100006);
        skipOnboarding = view.findViewById(0x7f100475);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    protected void setListeners()
    {
        if (inputField != null)
        {
            inputField.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final OnBoardingMultiStepA1Intl this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 6)
                    {
                        onContinueClicked();
                    }
                    return false;
                }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
            });
            inputField.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final OnBoardingMultiStepA1Intl this$0;

                public void onFocusChange(View view, boolean flag)
                {
                    if (flag)
                    {
                        imm.showSoftInput(inputField, 0);
                    }
                }

            
            {
                this$0 = OnBoardingMultiStepA1Intl.this;
                super();
            }
            });
        }
    }



}
