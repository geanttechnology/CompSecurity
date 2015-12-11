// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            ConfirmCreditCard, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, ConfirmCreditCard confirmcreditcard, Object obj)
    {
        super.nd(ewbinder, confirmcreditcard, obj);
        confirmcreditcard.cardNumberInputDigits = (EditText)ewbinder.dNumberInputDigits((View)ewbinder.dView(obj, 0x7f1001af, "field 'cardNumberInputDigits'"), 0x7f1001af, "field 'cardNumberInputDigits'");
        confirmcreditcard.cardNumberLastFourDigits = (TextView)ewbinder.dNumberLastFourDigits((View)ewbinder.dView(obj, 0x7f1001b0, "field 'cardNumberLastFourDigits'"), 0x7f1001b0, "field 'cardNumberLastFourDigits'");
        confirmcreditcard.cardIcon = (ImageView)ewbinder.dIcon((View)ewbinder.dView(obj, 0x7f1001ad, "field 'cardIcon'"), 0x7f1001ad, "field 'cardIcon'");
        confirmcreditcard.creditCardError = (TextView)ewbinder.ditCardError((View)ewbinder.dView(obj, 0x7f1001b1, "field 'creditCardError'"), 0x7f1001b1, "field 'creditCardError'");
        confirmcreditcard.creditCardInstructions = (TextView)ewbinder.ditCardInstructions((View)ewbinder.dView(obj, 0x7f1001ac, "field 'creditCardInstructions'"), 0x7f1001ac, "field 'creditCardInstructions'");
        ewbinder = ewbinder.dView(obj).getResources();
        confirmcreditcard.invalidInputLengthError = ewbinder.getString(0x7f0800a5);
        confirmcreditcard.cardValidationFailedError = ewbinder.getString(0x7f0800aa);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ConfirmCreditCard)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ConfirmCreditCard)obj, obj1);
    }

    public void unbind(ConfirmCreditCard confirmcreditcard)
    {
        super.bind(confirmcreditcard);
        confirmcreditcard.cardNumberInputDigits = null;
        confirmcreditcard.cardNumberLastFourDigits = null;
        confirmcreditcard.cardIcon = null;
        confirmcreditcard.creditCardError = null;
        confirmcreditcard.creditCardInstructions = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ConfirmCreditCard)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((ConfirmCreditCard)obj);
    }

    public ()
    {
    }
}
