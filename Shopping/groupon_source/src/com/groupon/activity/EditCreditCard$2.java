// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import com.groupon.view.CreditCardOneLine;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

class this._cls0
    implements android.view.ner
{

    final EditCreditCard this$0;

    public void onClick(View view)
    {
        if (!valid())
        {
            return;
        }
        if (EditCreditCard.access$400(EditCreditCard.this))
        {
            if (isUSACompatible)
            {
                view = creditCardOneLine.getCardNumber();
            } else
            {
                view = cardNumberView.getText();
            }
            if (!Strings.equals(view, EditCreditCard.access$500(EditCreditCard.this)))
            {
                EditCreditCard.access$600(EditCreditCard.this);
            }
        }
        if (creditCard == null && !isBillingRecord)
        {
            saveBillingRecord();
        } else
        {
            updateBillingRecord();
        }
        logCreditCardVariantEvent();
    }

    ()
    {
        this$0 = EditCreditCard.this;
        super();
    }
}
