// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.view.View;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

private final class <init>
    implements android.view.ner
{

    final PaymentCardEntryView this$0;

    public void onFocusChange(View view, boolean flag)
    {
_L2:
        return;
        if (view == null || PaymentCardEntryView.a(PaymentCardEntryView.this) == null || flag) goto _L2; else goto _L1
_L1:
        view.getId();
        JVM INSTR tableswitch 2131755959 2131755964: default 60
    //                   2131755959 98
    //                   2131755960 60
    //                   2131755961 60
    //                   2131755962 137
    //                   2131755963 176
    //                   2131755964 215;
           goto _L3 _L4 _L3 _L3 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_215;
_L9:
        if (PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.b(PaymentCardEntryView.this)))
        {
            PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.b();
            PaymentCardEntryView.d(PaymentCardEntryView.this);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (PaymentCardEntryView.b(PaymentCardEntryView.this).cardValid) goto _L9; else goto _L8
_L8:
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L10
_L10:
        PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.setErrorState(getContext().getString(0x7f090212));
        return;
_L5:
        if (!PaymentCardEntryView.b(PaymentCardEntryView.this).cardValid)
        {
            PaymentCardEntryView.c(PaymentCardEntryView.this).hasCardError = true;
            PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
            return;
        }
          goto _L9
_L6:
        if (!PaymentCardEntryView.b(PaymentCardEntryView.this).expiryValid)
        {
            PaymentCardEntryView.c(PaymentCardEntryView.this).hasExpiryError = true;
            PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
            return;
        }
          goto _L9
        if (!PaymentCardEntryView.b(PaymentCardEntryView.this).securityValid)
        {
            PaymentCardEntryView.c(PaymentCardEntryView.this).hasSecurityError = true;
            PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
            return;
        }
          goto _L9
    }

    private ews()
    {
        this$0 = PaymentCardEntryView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
