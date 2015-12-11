// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import org.apmem.tools.layouts.FlowLayout;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, EditCreditCard editcreditcard, Object obj)
    {
        super.bind(ewbinder, editcreditcard, obj);
        editcreditcard.expirationDate = (TextView)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000c0, null), 0x7f1000c0, "field 'expirationDate'");
        editcreditcard.cardNumberView = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b9, "field 'cardNumberView'"), 0x7f1000b9, "field 'cardNumberView'");
        editcreditcard.accountNumber = (EditText)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000c9, null), 0x7f1000c9, "field 'accountNumber'");
        editcreditcard.cvvView = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000bb, "field 'cvvView'"), 0x7f1000bb, "field 'cvvView'");
        editcreditcard.submitView = (SpinnerButton)ewbinder.((View)ewbinder.iredView(obj, 0x7f100102, "field 'submitView'"), 0x7f100102, "field 'submitView'");
        editcreditcard.firstName = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b2, "field 'firstName'"), 0x7f1000b2, "field 'firstName'");
        editcreditcard.lastName = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b3, "field 'lastName'"), 0x7f1000b3, "field 'lastName'");
        editcreditcard.issuerNumber = (EditText)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000bd, null), 0x7f1000bd, "field 'issuerNumber'");
        editcreditcard.creditCardOneLine = (CreditCardOneLine)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000c6, null), 0x7f1000c6, "field 'creditCardOneLine'");
        editcreditcard.creditCardIconContainer = (FrameLayout)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000c7, null), 0x7f1000c7, "field 'creditCardIconContainer'");
        editcreditcard.creditCardDemographicsContainer = (LinearLayout)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000c2, null), 0x7f1000c2, "field 'creditCardDemographicsContainer'");
        editcreditcard.title = (TextView)ewbinder.((View)ewbinder.onalView(obj, 0x7f10007a, null), 0x7f10007a, "field 'title'");
        editcreditcard.scanCard = (RelativeLayout)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000af, "field 'scanCard'"), 0x7f1000af, "field 'scanCard'");
        editcreditcard.secureConnectionView = (TextView)ewbinder.((View)ewbinder.onalView(obj, 0x7f100111, null), 0x7f100111, "field 'secureConnectionView'");
        editcreditcard.paymentInfoHeaderTitle = (TextView)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b0, "field 'paymentInfoHeaderTitle'"), 0x7f1000b0, "field 'paymentInfoHeaderTitle'");
        editcreditcard.supportedPaymentIcons = (FlowLayout)ewbinder.((View)ewbinder.onalView(obj, 0x7f1000b1, null), 0x7f1000b1, "field 'supportedPaymentIcons'");
        editcreditcard.creditCardDemographics = (LinearLayout)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000c4, "field 'creditCardDemographics'"), 0x7f1000c4, "field 'creditCardDemographics'");
        editcreditcard.bankCode = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b8, "field 'bankCode'"), 0x7f1000b8, "field 'bankCode'");
        editcreditcard.iban = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b4, "field 'iban'"), 0x7f1000b4, "field 'iban'");
        editcreditcard.bic = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1000b5, "field 'bic'"), 0x7f1000b5, "field 'bic'");
        editcreditcard.EDIT = ewbinder.xt(obj).getResources().getString(0x7f08013f);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (EditCreditCard)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EditCreditCard)obj, obj1);
    }

    public void unbind(EditCreditCard editcreditcard)
    {
        super.unbind(editcreditcard);
        editcreditcard.expirationDate = null;
        editcreditcard.cardNumberView = null;
        editcreditcard.accountNumber = null;
        editcreditcard.cvvView = null;
        editcreditcard.submitView = null;
        editcreditcard.firstName = null;
        editcreditcard.lastName = null;
        editcreditcard.issuerNumber = null;
        editcreditcard.creditCardOneLine = null;
        editcreditcard.creditCardIconContainer = null;
        editcreditcard.creditCardDemographicsContainer = null;
        editcreditcard.title = null;
        editcreditcard.scanCard = null;
        editcreditcard.secureConnectionView = null;
        editcreditcard.paymentInfoHeaderTitle = null;
        editcreditcard.supportedPaymentIcons = null;
        editcreditcard.creditCardDemographics = null;
        editcreditcard.bankCode = null;
        editcreditcard.iban = null;
        editcreditcard.bic = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((EditCreditCard)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EditCreditCard)obj);
    }

    public ()
    {
    }
}
