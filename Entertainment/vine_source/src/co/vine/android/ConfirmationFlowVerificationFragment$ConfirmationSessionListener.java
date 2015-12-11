// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            ConfirmationFlowVerificationFragment

private class <init> extends AppSessionListener
{

    final ConfirmationFlowVerificationFragment this$0;

    public void onRequestPhoneVerificationComplete(String s, int i, String s1, String s2)
    {
        s = getActivity();
        ConfirmationFlowVerificationFragment.access$700(ConfirmationFlowVerificationFragment.this).postDelayed(ConfirmationFlowVerificationFragment.access$600(ConfirmationFlowVerificationFragment.this), 10000L);
        if (i == 200 && ConfirmationFlowVerificationFragment.access$800(ConfirmationFlowVerificationFragment.this))
        {
            Util.showCenteredToast(s, getString(0x7f0e0085, new Object[] {
                s2
            }));
        } else
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        }
    }

    public void onVerifyPhoneNumberComplete(String s, int i, String s1)
    {
        s = getActivity();
        ConfirmationFlowVerificationFragment.access$900(ConfirmationFlowVerificationFragment.this, false);
        ConfirmationFlowVerificationFragment.access$100(ConfirmationFlowVerificationFragment.this, true);
        if (i == 200)
        {
            Util.showCenteredToast(s, 0x7f0e008b);
            getActivity().setResult(1527);
            getActivity().finish();
            return;
        }
        ConfirmationFlowVerificationFragment.access$200(ConfirmationFlowVerificationFragment.this, true);
        if (!TextUtils.isEmpty(s1))
        {
            ConfirmationFlowVerificationFragment.access$1000(ConfirmationFlowVerificationFragment.this).setText(s1);
            return;
        } else
        {
            ConfirmationFlowVerificationFragment.access$1000(ConfirmationFlowVerificationFragment.this).setText(0x7f0e0087);
            return;
        }
    }

    private ()
    {
        this$0 = ConfirmationFlowVerificationFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
