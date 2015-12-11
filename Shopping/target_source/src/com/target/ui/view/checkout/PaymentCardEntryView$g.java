// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.text.Editable;
import android.widget.EditText;
import com.target.mothership.util.o;
import com.target.ui.k.b;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.d.a.a;
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
        Object obj = null;
        editable = editable.toString();
        if (o.c(editable))
        {
            com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.length());
            com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).lastCardText.requestFocus();
        } else
        {
            a a1 = com.target.ui.util.d.b.c(before, editable);
            TGTCardDataModel tgtcarddatamodel = PaymentCardEntryView.e(PaymentCardEntryView.this);
            boolean flag;
            boolean flag1;
            if (a1.expirationMonth == null)
            {
                editable = null;
            } else
            {
                editable = a1.expirationMonth.toString();
            }
            tgtcarddatamodel.d(editable);
            tgtcarddatamodel = PaymentCardEntryView.e(PaymentCardEntryView.this);
            if (a1.expirationYear == null)
            {
                editable = obj;
            } else
            {
                editable = String.valueOf(a1.expirationYear);
            }
            tgtcarddatamodel.c(editable);
            flag1 = d.a(a1.expirationMonth, a1.expirationYear);
            editable = PaymentCardEntryView.c(PaymentCardEntryView.this);
            if (!flag1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            editable.hasExpiryError = flag;
            com.target.ui.view.checkout.PaymentCardEntryView.b(PaymentCardEntryView.this, flag1);
            if (flag1)
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this, PaymentCardEntryView.c(PaymentCardEntryView.this));
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).securityCodeText.requestFocus();
            }
            if (a1.wasFormattingNeeded)
            {
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setText(a1.withFormatting);
                com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.setSelection(com.target.ui.view.checkout.PaymentCardEntryView.a(PaymentCardEntryView.this).expiryText.length());
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
