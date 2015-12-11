// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

// Referenced classes of package com.groupon.activity:
//            EditMaestro, EditCreditCard, EditCreditCardEu, GrouponActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCard editcreditcard, Object obj)
    {
        bind(ewbinder, (EditMaestro)editcreditcard, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCardEu editcreditcardeu, Object obj)
    {
        bind(ewbinder, (EditMaestro)editcreditcardeu, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, EditMaestro editmaestro, Object obj)
    {
        super.bind(ewbinder, editmaestro, obj);
        editmaestro.validFromContainer = (ViewGroup)ewbinder.iew((View)ewbinder.equiredView(obj, 0x7f1000be, "field 'validFromContainer'"), 0x7f1000be, "field 'validFromContainer'");
        editmaestro.monthFromSpinner = (Spinner)ewbinder.iew((View)ewbinder.equiredView(obj, 0x7f1000bc, "field 'monthFromSpinner'"), 0x7f1000bc, "field 'monthFromSpinner'");
        editmaestro.yearFromSpinner = (Spinner)ewbinder.iew((View)ewbinder.equiredView(obj, 0x7f1000bf, "field 'yearFromSpinner'"), 0x7f1000bf, "field 'yearFromSpinner'");
        editmaestro.issuerNumberView = (EditText)ewbinder.iew((View)ewbinder.equiredView(obj, 0x7f1000bd, "field 'issuerNumberView'"), 0x7f1000bd, "field 'issuerNumberView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (EditMaestro)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EditMaestro)obj, obj1);
    }

    public volatile void unbind(EditCreditCard editcreditcard)
    {
        unbind((EditMaestro)editcreditcard);
    }

    public volatile void unbind(EditCreditCardEu editcreditcardeu)
    {
        unbind((EditMaestro)editcreditcardeu);
    }

    public void unbind(EditMaestro editmaestro)
    {
        super.unbind(editmaestro);
        editmaestro.validFromContainer = null;
        editmaestro.monthFromSpinner = null;
        editmaestro.yearFromSpinner = null;
        editmaestro.issuerNumberView = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((EditMaestro)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EditMaestro)obj);
    }

    public nder()
    {
    }
}
