// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu, EditCreditCard, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, EditCreditCard editcreditcard, Object obj)
    {
        bind(ewbinder, (EditCreditCardEu)editcreditcard, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, EditCreditCardEu editcreditcardeu, Object obj)
    {
        super.nd(ewbinder, editcreditcardeu, obj);
        editcreditcardeu.paymentMethodLayout = (LinearLayout)ewbinder.mentMethodLayout((View)ewbinder.edView(obj, 0x7f1000b6, "field 'paymentMethodLayout'"), 0x7f1000b6, "field 'paymentMethodLayout'");
        editcreditcardeu.paymentMethod = (Spinner)ewbinder.mentMethod((View)ewbinder.edView(obj, 0x7f1000b7, "field 'paymentMethod'"), 0x7f1000b7, "field 'paymentMethod'");
        editcreditcardeu.storageChoice = (CheckBox)ewbinder.rageChoice((View)ewbinder.edView(obj, 0x7f1000c5, "field 'storageChoice'"), 0x7f1000c5, "field 'storageChoice'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (EditCreditCardEu)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (EditCreditCardEu)obj, obj1);
    }

    public volatile void unbind(EditCreditCard editcreditcard)
    {
        unbind((EditCreditCardEu)editcreditcard);
    }

    public void unbind(EditCreditCardEu editcreditcardeu)
    {
        super.bind(editcreditcardeu);
        editcreditcardeu.paymentMethodLayout = null;
        editcreditcardeu.paymentMethod = null;
        editcreditcardeu.storageChoice = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((EditCreditCardEu)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((EditCreditCardEu)obj);
    }

    public ()
    {
    }
}
