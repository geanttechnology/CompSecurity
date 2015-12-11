// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

public class ScanCreditCardFragment extends BaseNavigationFragment
{
    public static interface a
    {

        public abstract void c(String s);
    }


    private static final int CARD_SCAN_REQUEST_CODE = 0;
    private a mListener;

    public ScanCreditCardFragment()
    {
    }

    public static ScanCreditCardFragment b(Fragment fragment)
    {
        ScanCreditCardFragment scancreditcardfragment = new ScanCreditCardFragment();
        scancreditcardfragment.setTargetFragment(fragment, 0);
        return scancreditcardfragment;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            bundle = new Intent(getActivity(), io/card/payment/CardIOActivity);
            bundle.putExtra("io.card.payment.hideLogo", true);
            bundle.putExtra("io.card.payment.intentSenderIsPayPal", false);
            bundle.putExtra("io.card.payment.suppressManual", true);
            bundle.putExtra("io.card.payment.keepApplicationTheme", true);
            bundle.putExtra("io.card.payment.guideColor", -1);
            bundle.putExtra("io.card.payment.scanOverlayLayoutId", 0x7f0300d0);
            startActivityForResult(bundle, 0);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 0)
        {
            if (intent != null && intent.hasExtra("io.card.payment.scanResult"))
            {
                intent = (CreditCard)intent.getParcelableExtra("io.card.payment.scanResult");
                mListener.c(intent.getFormattedCardNumber());
            }
            m().h(this);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }
}
