// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.models.country.CreditCard;
import com.groupon.util.CreditCardStorageOptInHandler;
import com.groupon.view.CreditCardOneLine;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

class val.creditCardList
    implements android.widget.electedListener
{

    final EditCreditCardEu this$0;
    final List val$creditCardList;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        boolean flag = false;
        if (val$creditCardList != null)
        {
            adapterview = (CreditCard)val$creditCardList.get(i);
            boolean flag1;
            if (isUSACompatible)
            {
                creditCardOneLine.setCvvVisibility(((CreditCard) (adapterview)).requireCVV);
                ((TextView)view).setTextColor(getResources().getColor(0x7f0e00a8));
            } else
            {
                view = cvvView;
                if (((CreditCard)val$creditCardList.get(i)).requireCVV)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view.setVisibility(i);
            }
            flag1 = EditCreditCardEu.access$000(EditCreditCardEu.this);
            view = streetNumberView;
            if (flag1)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            view.setVisibility(i);
            view = addressView;
            if (flag1)
            {
                i = postalCodeView.getId();
            } else
            {
                i = streetNumberView.getId();
            }
            view.setNextFocusDownId(i);
            if (EditCreditCardEu.access$100(EditCreditCardEu.this).updateConsentForPaymentMethod(((CreditCard) (adapterview)).name))
            {
                adapterview = storageChoice;
                if (EditCreditCardEu.access$100(EditCreditCardEu.this).isConsentRequested())
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                adapterview.setVisibility(i);
                storageChoice.setChecked(EditCreditCardEu.access$100(EditCreditCardEu.this).hasStorageConsent());
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    andler()
    {
        this$0 = final_editcreditcardeu;
        val$creditCardList = List.this;
        super();
    }
}
