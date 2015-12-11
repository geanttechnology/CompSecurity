// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

// Referenced classes of package com.groupon.activity:
//            EditElv, EditCreditCard, EditCreditCardEu, GrouponActivity

public class ewBinder extends ewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCard editcreditcard, Object obj)
    {
        bind(ewbinder, (EditElv)editcreditcard, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCardEu editcreditcardeu, Object obj)
    {
        bind(ewbinder, (EditElv)editcreditcardeu, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, EditElv editelv, Object obj)
    {
        super.bind(ewbinder, editelv, obj);
        editelv.validFromContainer = (ViewGroup)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1000be, "field 'validFromContainer'"), 0x7f1000be, "field 'validFromContainer'");
        editelv.monthFromSpinner = (Spinner)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1000bc, "field 'monthFromSpinner'"), 0x7f1000bc, "field 'monthFromSpinner'");
        editelv.yearFromSpinner = (Spinner)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1000bf, "field 'yearFromSpinner'"), 0x7f1000bf, "field 'yearFromSpinner'");
        editelv.issuerNumberView = (EditText)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1000bd, "field 'issuerNumberView'"), 0x7f1000bd, "field 'issuerNumberView'");
        editelv.bankCodeView = (EditText)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f1000b8, "field 'bankCodeView'"), 0x7f1000b8, "field 'bankCodeView'");
        editelv.accountNumberView = (EditText)ewbinder.astView((View)ewbinder.indOptionalView(obj, 0x7f1000c9, null), 0x7f1000c9, "field 'accountNumberView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (EditElv)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EditElv)obj, obj1);
    }

    public volatile void unbind(EditCreditCard editcreditcard)
    {
        unbind((EditElv)editcreditcard);
    }

    public volatile void unbind(EditCreditCardEu editcreditcardeu)
    {
        unbind((EditElv)editcreditcardeu);
    }

    public void unbind(EditElv editelv)
    {
        super.unbind(editelv);
        editelv.validFromContainer = null;
        editelv.monthFromSpinner = null;
        editelv.yearFromSpinner = null;
        editelv.issuerNumberView = null;
        editelv.bankCodeView = null;
        editelv.accountNumberView = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((EditElv)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EditElv)obj);
    }

    public ewBinder()
    {
    }
}
