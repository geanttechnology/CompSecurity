// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import com.target.mothership.util.o;
import com.target.ui.k.b;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.e;
import com.target.ui.util.validation.a.c;
import com.target.ui.util.validation.d;
import com.target.ui.view.BackSpaceDetectorEditText;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

private final class <init> extends b
{

    String before;
    final PaymentCardEntryView this$0;

    public void a(Editable editable)
    {
        editable = editable.toString();
        if (o.g(PaymentCardEntryView.f(PaymentCardEntryView.this)) && PaymentCardEntryView.f(PaymentCardEntryView.this).length() >= 4)
        {
            Object obj = new StringBuilder(PaymentCardEntryView.f(PaymentCardEntryView.this));
            ((StringBuilder) (obj)).replace(PaymentCardEntryView.f(PaymentCardEntryView.this).length() - 4, PaymentCardEntryView.f(PaymentCardEntryView.this).length(), editable);
            Object obj1 = com.target.ui.util.d.b.b(PaymentCardEntryView.f(PaymentCardEntryView.this), ((StringBuilder) (obj)).toString());
            obj = d.b(((com.target.ui.util.d.a.b) (obj1)).noFormattingString);
            boolean flag = PaymentCardEntryView.a(PaymentCardEntryView.this, ((c) (obj)).cardTypeGuess);
            com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(((com.target.ui.util.d.a.b) (obj1)).noFormattingString);
            com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).b(com.target.ui.util.d.b.a(((com.target.ui.util.d.a.b) (obj1)).noFormattingString));
            if (flag)
            {
                e.a(((c) (obj)).cardTypeGuess, PaymentCardEntryView.a(PaymentCardEntryView.this).cardImg);
            }
            obj1 = com.target.ui.view.checkout.PaymentCardEntryView.c(PaymentCardEntryView.this);
            if (!((c) (obj)).isValid)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1.hasCardError = flag;
            PaymentCardEntryView.a(PaymentCardEntryView.this, ((c) (obj)).isValid);
            PaymentCardEntryView.a(PaymentCardEntryView.this, com.target.ui.view.checkout.PaymentCardEntryView.c(PaymentCardEntryView.this));
        }
        if (editable.length() == 4)
        {
            if (e.a(com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a()))
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.requestFocus();
            } else
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).securityCodeText.requestFocus();
            }
        }
        if (o.f(before) && o.c(editable))
        {
            PaymentCardEntryView.a(PaymentCardEntryView.this, null);
            PaymentCardEntryView.g(PaymentCardEntryView.this);
        }
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
        before = charsequence.toString();
    }

    public void b(CharSequence charsequence, int i, int j, int k)
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
