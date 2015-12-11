// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

// Referenced classes of package com.groupon.activity:
//            EditSepa, EditCreditCard, EditCreditCardEu, GrouponActivity

public class wBinder extends wBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCard editcreditcard, Object obj)
    {
        bind(ewbinder, (EditSepa)editcreditcard, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCardEu editcreditcardeu, Object obj)
    {
        bind(ewbinder, (EditSepa)editcreditcardeu, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, EditSepa editsepa, Object obj)
    {
        super.bind(ewbinder, editsepa, obj);
        editsepa.validFromContainer = (ViewGroup)ewbinder.stView((View)ewbinder.ndRequiredView(obj, 0x7f1000be, "field 'validFromContainer'"), 0x7f1000be, "field 'validFromContainer'");
        editsepa.monthFromSpinner = (Spinner)ewbinder.stView((View)ewbinder.ndRequiredView(obj, 0x7f1000bc, "field 'monthFromSpinner'"), 0x7f1000bc, "field 'monthFromSpinner'");
        editsepa.yearFromSpinner = (Spinner)ewbinder.stView((View)ewbinder.ndRequiredView(obj, 0x7f1000bf, "field 'yearFromSpinner'"), 0x7f1000bf, "field 'yearFromSpinner'");
        editsepa.issuerNumberView = (EditText)ewbinder.stView((View)ewbinder.ndRequiredView(obj, 0x7f1000bd, "field 'issuerNumberView'"), 0x7f1000bd, "field 'issuerNumberView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (EditSepa)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EditSepa)obj, obj1);
    }

    public volatile void unbind(EditCreditCard editcreditcard)
    {
        unbind((EditSepa)editcreditcard);
    }

    public volatile void unbind(EditCreditCardEu editcreditcardeu)
    {
        unbind((EditSepa)editcreditcardeu);
    }

    public void unbind(EditSepa editsepa)
    {
        super.unbind(editsepa);
        editsepa.validFromContainer = null;
        editsepa.monthFromSpinner = null;
        editsepa.yearFromSpinner = null;
        editsepa.issuerNumberView = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((EditSepa)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EditSepa)obj);
    }

    public wBinder()
    {
    }
}
