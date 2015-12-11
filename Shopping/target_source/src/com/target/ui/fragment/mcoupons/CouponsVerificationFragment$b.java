// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.target.ui.view.mcoupons.CouponsPinView;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponsVerificationFragment

private class couponsPinView
{

    TextView agreementTextView;
    CouponsPinView couponsPinView;
    TextView enterPinText;
    TextView phoneNumberTextView;
    Button pinSubmitButton;
    final CouponsVerificationFragment this$0;

    (View view)
    {
        this$0 = CouponsVerificationFragment.this;
        super();
        agreementTextView = (TextView)view.findViewById(0x7f10019a);
        phoneNumberTextView = (TextView)view.findViewById(0x7f100196);
        enterPinText = (TextView)view.findViewById(0x7f100197);
        pinSubmitButton = (Button)view.findViewById(0x7f100199);
        couponsPinView = (CouponsPinView)view.findViewById(0x7f100198);
    }
}
