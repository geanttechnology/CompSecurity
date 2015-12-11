// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .ctView = (View)viewbinder.dView(obj, 0x7f1003bf, "field 'paymentCompactView'");
        .etailsView = (LinearLayout)viewbinder.paymentCardDetailsView((View)viewbinder.dView(obj, 0x7f1003c2, "field 'paymentCardDetailsView'"), 0x7f1003c2, "field 'paymentCardDetailsView'");
        .tText = (TextView)viewbinder.selectPaymentText((View)viewbinder.dView(obj, 0x7f1003c5, "field 'selectPaymentText'"), 0x7f1003c5, "field 'selectPaymentText'");
        .mage = (ImageView)viewbinder.paymentCardImage((View)viewbinder.dView(obj, 0x7f1003c0, "field 'paymentCardImage'"), 0x7f1003c0, "field 'paymentCardImage'");
        .tsText = (TextView)viewbinder.cardLastDigitsText((View)viewbinder.dView(obj, 0x7f1003c3, "field 'cardLastDigitsText'"), 0x7f1003c3, "field 'cardLastDigitsText'");
        .ssText = (TextView)viewbinder.billingAddressText((View)viewbinder.dView(obj, 0x7f1003c4, "field 'billingAddressText'"), 0x7f1003c4, "field 'billingAddressText'");
        .ssText = (View)viewbinder.dView(obj, 0x7f1003c1, "field 'editButton'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ctView = null;
        bind1.etailsView = null;
        bind1.tText = null;
        bind1.mage = null;
        bind1.tsText = null;
        bind1.ssText = null;
        bind1.ssText = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
