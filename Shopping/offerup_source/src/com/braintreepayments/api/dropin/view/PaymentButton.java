// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.braintreepayments.api.Braintree;
import com.google.android.gms.wallet.Cart;
import java.util.List;

public class PaymentButton extends RelativeLayout
    implements android.view.View.OnClickListener
{

    public static final int REQUEST_CODE = 11876;
    private Activity mActivity;
    private List mAdditionalScopes;
    private Braintree mBraintree;
    private Cart mCart;
    private boolean mIsBillingAgreement;
    private boolean mPhoneNumberRequired;
    private int mRequestCode;
    private boolean mShippingAddressRequired;

    public PaymentButton(Context context)
    {
        super(context);
    }

    public PaymentButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PaymentButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private void enableButton(View view, int i)
    {
        view.setVisibility(0);
        view.setOnClickListener(this);
        view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1, 3F / (float)i));
    }

    public void initialize(Activity activity, Braintree braintree)
    {
        initialize(activity, braintree, 11876);
    }

    public void initialize(Activity activity, Braintree braintree, int i)
    {
        mActivity = activity;
        mBraintree = braintree;
        mRequestCode = i;
        inflate(getContext(), com.braintreepayments.api.dropin.R.layout.bt_payment_button, this);
        boolean flag1 = mBraintree.isPayPalEnabled();
        boolean flag2 = mBraintree.isVenmoEnabled();
        boolean flag;
        if (mBraintree.isAndroidPayEnabled() && (mCart != null || mIsBillingAgreement))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag1 && !flag2 && !flag)
        {
            setVisibility(8);
        } else
        {
            int j;
            if (flag1)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            i = j;
            if (flag2)
            {
                i = j + 1;
            }
            j = i;
            if (flag)
            {
                j = i + 1;
            }
            if (flag1)
            {
                enableButton(findViewById(com.braintreepayments.api.dropin.R.id.bt_paypal_button), j);
            }
            if (flag2)
            {
                enableButton(findViewById(com.braintreepayments.api.dropin.R.id.bt_venmo_button), j);
            }
            if (flag)
            {
                enableButton(findViewById(com.braintreepayments.api.dropin.R.id.bt_android_pay_button), j);
            }
            if (flag1 && j > 1)
            {
                findViewById(com.braintreepayments.api.dropin.R.id.bt_payment_button_divider).setVisibility(0);
            } else
            if (flag2 && j > 1)
            {
                findViewById(com.braintreepayments.api.dropin.R.id.bt_payment_button_divider_2).setVisibility(0);
            }
            if (j > 2)
            {
                findViewById(com.braintreepayments.api.dropin.R.id.bt_payment_button_divider_2).setVisibility(0);
                return;
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == mRequestCode)
        {
            mBraintree.onActivityResult(mActivity, i, j, intent);
        }
    }

    public void onClick(View view)
    {
        if (view.getId() != com.braintreepayments.api.dropin.R.id.bt_paypal_button) goto _L2; else goto _L1
_L1:
        mBraintree.startPayWithPayPal(mActivity, mRequestCode, mAdditionalScopes);
_L4:
        performClick();
        return;
_L2:
        if (view.getId() == com.braintreepayments.api.dropin.R.id.bt_venmo_button)
        {
            mBraintree.startPayWithVenmo(mActivity, mRequestCode);
        } else
        if (view.getId() == com.braintreepayments.api.dropin.R.id.bt_android_pay_button)
        {
            mBraintree.performAndroidPayMaskedWalletRequest(mActivity, mRequestCode, mCart, mIsBillingAgreement, mShippingAddressRequired, mPhoneNumberRequired);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAdditionalPayPalScopes(List list)
    {
        mAdditionalScopes = list;
    }

    public void setAndroidPayOptions(Cart cart)
    {
        setAndroidPayOptions(cart, false, false, false);
    }

    public void setAndroidPayOptions(Cart cart, boolean flag, boolean flag1, boolean flag2)
    {
        mCart = cart;
        mIsBillingAgreement = flag;
        mShippingAddressRequired = flag1;
        mPhoneNumberRequired = flag2;
    }
}
