// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ScrollView;
import com.braintreepayments.api.Braintree;
import com.braintreepayments.api.dropin.view.LoadingHeader;
import com.braintreepayments.api.dropin.view.PaymentButton;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.cardform.a;
import com.braintreepayments.cardform.b;
import com.braintreepayments.cardform.c;
import com.braintreepayments.cardform.view.CardForm;

// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreeViewController, BraintreePaymentActivity, Customization

public class AddPaymentMethodViewController extends BraintreeViewController
    implements android.view.View.OnClickListener, a, b, c
{

    private static final String EXTRA_FORM_IS_SUBMITTING = "com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING";
    private static final String EXTRA_SUBMIT_BUTTON_ENABLED = "com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED";
    private static final String INTEGRATION_METHOD = "dropin";
    private CardForm mCardForm;
    private View mDescription;
    private boolean mIsSubmitting;
    private LoadingHeader mLoadingHeader;
    private PaymentButton mPaymentButton;
    private ScrollView mScrollView;
    private Button mSubmitButton;

    public AddPaymentMethodViewController(BraintreePaymentActivity braintreepaymentactivity, Bundle bundle, View view, Braintree braintree, Customization customization)
    {
        super(braintreepaymentactivity, view, braintree, customization);
        mIsSubmitting = false;
        initViews();
        restoreState(bundle);
    }

    private CardBuilder getCardBuilder()
    {
        CardBuilder cardbuilder = (new CardBuilder()).cardNumber(mCardForm.getCardNumber()).expirationMonth(mCardForm.getExpirationMonth()).expirationYear(mCardForm.getExpirationYear()).integration("dropin");
        if (mBraintree.isCvvChallenegePresent())
        {
            cardbuilder.cvv(mCardForm.getCvv());
        }
        if (mBraintree.isPostalCodeChallengePresent())
        {
            cardbuilder.postalCode(mCardForm.getPostalCode());
        }
        return cardbuilder;
    }

    private void initViews()
    {
        mLoadingHeader = (LoadingHeader)findView(R.id.bt_header_container);
        mScrollView = (ScrollView)findView(R.id.bt_form_scroll_container);
        mDescription = findView(R.id.bt_description_container);
        mPaymentButton = (PaymentButton)findView(R.id.bt_payment_button);
        mCardForm = (CardForm)findView(R.id.bt_card_form);
        mSubmitButton = (Button)findView(R.id.bt_card_form_submit_button);
        mPaymentButton.setOnClickListener(this);
        try
        {
            mPaymentButton.setAndroidPayOptions(mActivity.getAndroidPayCart(), mActivity.getAndroidPayIsBillingAgreement(), false, false);
        }
        catch (NoClassDefFoundError noclassdeffounderror) { }
        mPaymentButton.initialize(mActivity, mBraintree);
        mCardForm.a(mActivity, true, true, mBraintree.isCvvChallenegePresent(), mBraintree.isPostalCodeChallengePresent(), getCustomizedCallToAction());
        mCardForm.setOnCardFormValidListener(this);
        mCardForm.setOnCardFormSubmitListener(this);
        mCardForm.setOnFormFieldFocusedListener(this);
        mSubmitButton.setOnClickListener(this);
        mSubmitButton.setText(getSubmitButtonText());
    }

    private void restoreState(Bundle bundle)
    {
        if (bundle.containsKey("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING"))
        {
            mIsSubmitting = bundle.getBoolean("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING");
            if (mIsSubmitting)
            {
                setUIForSubmit();
            }
        }
        if (bundle.containsKey("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED"))
        {
            mSubmitButton.setEnabled(bundle.getBoolean("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED"));
        }
        if (mCardForm.a())
        {
            setEnabledSubmitButtonStyle();
        }
    }

    private void setDisabledSubmitButtonStyle()
    {
        mSubmitButton.setBackgroundResource(R.color.bt_button_disabled_color);
    }

    private void setEnabledSubmitButtonStyle()
    {
        mSubmitButton.setBackgroundResource(R.drawable.bt_submit_button_background);
    }

    private void setUIForSubmit()
    {
        mCardForm.setEnabled(false);
        mSubmitButton.setEnabled(false);
        mDescription.setVisibility(8);
        mLoadingHeader.setLoading();
    }

    private void showErrorUI()
    {
        mLoadingHeader.setError(mActivity.getString(R.string.bt_invalid_card));
    }

    private void startSubmit()
    {
        CardForm cardform = mCardForm;
        ((InputMethodManager)cardform.getContext().getSystemService("input_method")).hideSoftInputFromWindow(cardform.getWindowToken(), 0);
        mIsSubmitting = true;
        setUIForSubmit();
    }

    protected void endSubmit()
    {
        setDisabledSubmitButtonStyle();
        mCardForm.setEnabled(true);
        mSubmitButton.setEnabled(true);
        mIsSubmitting = false;
    }

    protected boolean isSubmitting()
    {
        return mIsSubmitting;
    }

    public void onCardFormFieldFocused(final View field)
    {
        mScrollView.postDelayed(new _cls1(), 100L);
    }

    public void onCardFormSubmit()
    {
        mSubmitButton.performClick();
    }

    public void onCardFormValid(boolean flag)
    {
        if (flag)
        {
            setEnabledSubmitButtonStyle();
            return;
        } else
        {
            setDisabledSubmitButtonStyle();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view == mPaymentButton)
        {
            mActivity.showLoadingView();
        } else
        if (view == mSubmitButton)
        {
            if (mCardForm.a())
            {
                startSubmit();
                mBraintree.create(getCardBuilder());
                return;
            } else
            {
                mCardForm.b();
                setDisabledSubmitButtonStyle();
                return;
            }
        }
    }

    public void onPaymentResult(int i, int j, Intent intent)
    {
        mIsSubmitting = true;
        mBraintree.onActivityResult(mActivity, i, j, intent);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("com.braintreepayments.api.dropin.EXTRA_FORM_IS_SUBMITTING", mIsSubmitting);
        bundle.putBoolean("com.braintreepayments.api.dropin.EXTRA_SUBMIT_BUTTON_ENABLED", mSubmitButton.isEnabled());
    }

    public void setErrors(ErrorWithResponse errorwithresponse)
    {
        endSubmit();
        com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeError braintreeerror = errorwithresponse.errorFor("creditCard");
        if (braintreeerror != null)
        {
            mBraintree.sendAnalyticsEvent("add-card.failed");
            if (braintreeerror.errorFor("number") != null)
            {
                mCardForm.c();
            }
            if (braintreeerror.errorFor("expirationYear") != null || braintreeerror.errorFor("expirationMonth") != null || braintreeerror.errorFor("expirationDate") != null)
            {
                mCardForm.d();
            }
            if (braintreeerror.errorFor("cvv") != null)
            {
                mCardForm.e();
            }
            if (braintreeerror.errorFor("billingAddress") != null)
            {
                mCardForm.f();
            }
            showErrorUI();
            return;
        } else
        {
            mActivity.onUnrecoverableError(new UnexpectedException(errorwithresponse.getMessage()));
            return;
        }
    }

    protected void showSuccess()
    {
        mLoadingHeader.setSuccessful();
    }


    private class _cls1
        implements Runnable
    {

        final AddPaymentMethodViewController this$0;
        final View val$field;

        public void run()
        {
            mScrollView.smoothScrollTo(0, field.getTop());
        }

        _cls1()
        {
            this$0 = AddPaymentMethodViewController.this;
            field = view;
            super();
        }
    }

}
