// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.ebay.mobile.activities.ModalActivity;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PayPalIdentityFragment

public class PayPalIdentityActivity extends ModalActivity
{

    public static final String EXTRA_PAYPAL_LINK_ID = "payPalLinkId";
    public static final int RESULT_EBAY_USER_LOGOUT = 1;
    public static final int RESULT_GENERAL_IDL_ERROR = 2;
    public static final int RESULT_RESET_PAYMENT_METHOD = 5;
    public static final int RESULT_SELECT_PAYMENT_METHOD = 4;
    public static final int RESULT_SESSION_EXPIRED_RETRY = 3;

    public PayPalIdentityActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030196);
        hideCloseButton();
        showBackButton();
        if ((PayPalIdentityFragment)getFragmentManager().findFragmentByTag(com/ebay/mobile/checkout/prox/PayPalIdentityFragment.getName()) == null)
        {
            bundle = getFragmentManager().beginTransaction();
            PayPalIdentityFragment paypalidentityfragment = new PayPalIdentityFragment();
            bundle.add(0x7f1004ab, paypalidentityfragment, paypalidentityfragment.getClass().getName());
            bundle.commit();
        }
    }
}
