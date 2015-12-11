// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.e;
import com.target.ui.view.BackSpaceDetectorEditText;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

private final class <init>
    implements com.target.ui.view.xt.a
{

    final PaymentCardEntryView this$0;

    public void a(BackSpaceDetectorEditText backspacedetectoredittext)
    {
        if (backspacedetectoredittext != null && PaymentCardEntryView.a(PaymentCardEntryView.this) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        backspacedetectoredittext.getId();
        JVM INSTR tableswitch 2131755963 2131755964: default 40
    //                   2131755963 41
    //                   2131755964 95;
           goto _L3 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        if (!o.e(backspacedetectoredittext.getText().toString())) goto _L1; else goto _L6
_L6:
        PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
        PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
        return;
        if (!o.e(backspacedetectoredittext.getText().toString())) goto _L1; else goto _L7
_L7:
        if (e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
        {
            PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
            PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
            return;
        } else
        {
            PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
            PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
            return;
        }
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
