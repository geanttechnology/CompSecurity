// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.TextView;

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .essView = (View)viewbinder.shippingAddressView(obj, 0x7f1002da, "field 'shippingAddressView'");
        .ppingAddress = (TextView)viewbinder.formattedShippingAddress((View)viewbinder.formattedShippingAddress(obj, 0x7f1002db, "field 'formattedShippingAddress'"), 0x7f1002db, "field 'formattedShippingAddress'");
        .sView = (View)viewbinder.pickUpDetailsView(obj, 0x7f1002dc, "field 'pickUpDetailsView'");
        .Name = (TextView)viewbinder.pickupPersonName((View)viewbinder.pickupPersonName(obj, 0x7f1002dd, "field 'pickupPersonName'"), 0x7f1002dd, "field 'pickupPersonName'");
        .ntDetailsView = (View)viewbinder.emailRecipientDetailsView(obj, 0x7f1002de, "field 'emailRecipientDetailsView'");
        .il = (TextView)viewbinder.recipientEmail((View)viewbinder.recipientEmail(obj, 0x7f1002df, "field 'recipientEmail'"), 0x7f1002df, "field 'recipientEmail'");
        .entDetailsView = (View)viewbinder.mobileRecipientDetailsView(obj, 0x7f1002e0, "field 'mobileRecipientDetailsView'");
        .ile = (TextView)viewbinder.recipientMobile((View)viewbinder.recipientMobile(obj, 0x7f1002e1, "field 'recipientMobile'"), 0x7f1002e1, "field 'recipientMobile'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.essView = null;
        bind1.ppingAddress = null;
        bind1.sView = null;
        bind1.Name = null;
        bind1.ntDetailsView = null;
        bind1.il = null;
        bind1.entDetailsView = null;
        bind1.ile = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
