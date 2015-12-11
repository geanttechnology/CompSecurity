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
import com.target.ui.util.validation.a.c;
import com.target.ui.util.validation.d;
import com.target.ui.util.validation.g;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.checkout:
//            PaymentCardEntryView

private final class <init> extends b
{

    String before;
    final PaymentCardEntryView this$0;

    public void a(Editable editable)
    {
        editable = editable.toString();
        if (!o.c(editable))
        {
            editable = com.target.ui.util.d.b.b(before, editable);
            c c1 = d.b(((com.target.ui.util.d.a.b) (editable)).noFormattingString);
            boolean flag = PaymentCardEntryView.a(PaymentCardEntryView.this, c1.cardTypeGuess);
            com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).a(((com.target.ui.util.d.a.b) (editable)).noFormattingString);
            com.target.ui.view.checkout.PaymentCardEntryView.e(PaymentCardEntryView.this).b(com.target.ui.util.d.b.a(((com.target.ui.util.d.a.b) (editable)).noFormattingString));
            if (flag)
            {
                e.a(c1.cardTypeGuess, PaymentCardEntryView.a(PaymentCardEntryView.this).cardImg);
            }
            PaymentCardEntryView.a(PaymentCardEntryView.this, c1.isValid);
            if (c1.isValid)
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this, ((com.target.ui.util.d.a.b) (editable)).noFormattingString);
                com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this, c1.cardTypeGuess);
                PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.b();
                return;
            }
            if (g.a(c1, PaymentCardEntryView.a(PaymentCardEntryView.this).cardText, PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper))
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).cardTextWrapper.setErrorState(getContext().getString(0x7f090212));
            }
            if (((com.target.ui.util.d.a.b) (editable)).wasFormattingNeeded)
            {
                PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.setText(((com.target.ui.util.d.a.b) (editable)).formattingAppliedString);
                PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.setSelection(PaymentCardEntryView.a(PaymentCardEntryView.this).cardText.length());
                return;
            }
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
