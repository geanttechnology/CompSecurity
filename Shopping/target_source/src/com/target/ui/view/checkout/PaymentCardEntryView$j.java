// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.k.b;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.e;
import com.target.ui.util.validation.d;
import com.target.ui.view.BackSpaceDetectorEditText;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

private final class <init> extends b
{

    String before;
    final PaymentCardEntryView this$0;

    public void a(Editable editable)
    {
        boolean flag = true;
        if (o.f(before) && o.c(editable.toString()))
        {
            if (e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
                PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
            } else
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
                PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
            }
            PaymentCardEntryView.c(PaymentCardEntryView.this).hasSecurityError = true;
            PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.setErrorState(getContext().getString(0x7f090215));
        } else
        {
            com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).e(editable.toString());
            boolean flag1 = d.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(), editable.toString());
            PaymentCardEntryView.c(PaymentCardEntryView.this, flag1);
            editable = PaymentCardEntryView.c(PaymentCardEntryView.this);
            if (flag1)
            {
                flag = false;
            }
            editable.hasSecurityError = flag;
            if (PaymentCardEntryView.a(PaymentCardEntryView.this, com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this)))
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).pinAndCvvWrapper.b();
                return;
            }
        }
    }

    public void a(CharSequence charsequence, int i, int k, int l)
    {
        before = charsequence.toString();
    }

    public void b(CharSequence charsequence, int i, int k, int l)
    {
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
