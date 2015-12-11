// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;

// Referenced classes of package com.target.ui.view.checkout:
//            ShippingAddressView, PickUpDetailsView, EmailRecipientDetailsView, SmsRecipientDetailsView

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .essView = (ShippingAddressView)viewbinder.View((View)viewbinder.View(obj, 0x7f100396, "field 'shippingAddressView'"), 0x7f100396, "field 'shippingAddressView'");
        .sView = (PickUpDetailsView)viewbinder.ew((View)viewbinder.View(obj, 0x7f100398, "field 'pickUpDetailsView'"), 0x7f100398, "field 'pickUpDetailsView'");
        .ntDetailsView = (EmailRecipientDetailsView)viewbinder.etailsView((View)viewbinder.View(obj, 0x7f10039a, "field 'emailRecipientDetailsView'"), 0x7f10039a, "field 'emailRecipientDetailsView'");
        .DetailsView = (SmsRecipientDetailsView)viewbinder.ailsView((View)viewbinder.View(obj, 0x7f10039c, "field 'smsRecipientDetailsView'"), 0x7f10039c, "field 'smsRecipientDetailsView'");
        .r = (View)viewbinder.View(obj, 0x7f100397, "field 'addressSpacer'");
        . = (View)viewbinder.View(obj, 0x7f100399, "field 'pickupSpacer'");
        . = (View)viewbinder.View(obj, 0x7f10039b, "field 'emailSpacer'");
        . = (View)viewbinder.View(obj, 0x7f10039d, "field 'smsSpacer'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.essView = null;
        bind1.sView = null;
        bind1.ntDetailsView = null;
        bind1.DetailsView = null;
        bind1.r = null;
        bind1. = null;
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
