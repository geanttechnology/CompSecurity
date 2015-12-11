// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.checkout:
//            DeliveryView, EmailRecipientDetailsView, PickUpDetailsView, ShippingAddressView, 
//            SmsRecipientDetailsView

static class View extends a
{

    View addressSpacer;
    EmailRecipientDetailsView emailRecipientDetailsView;
    View emailSpacer;
    PickUpDetailsView pickUpDetailsView;
    View pickupSpacer;
    ShippingAddressView shippingAddressView;
    SmsRecipientDetailsView smsRecipientDetailsView;
    View smsSpacer;

    View(View view)
    {
        super(view);
    }
}
