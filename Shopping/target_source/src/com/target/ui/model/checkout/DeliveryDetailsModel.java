// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcelable;

// Referenced classes of package com.target.ui.model.checkout:
//            DeliveryTypedProducts, EmailRecipientDetailsModel, PickUpPersonDetailsModel, ShippingAddressDetailsModel, 
//            SmsRecipientDetailsModel

public interface DeliveryDetailsModel
    extends Parcelable
{

    public abstract DeliveryTypedProducts a();

    public abstract void a(DeliveryTypedProducts deliverytypedproducts);

    public abstract void a(EmailRecipientDetailsModel emailrecipientdetailsmodel);

    public abstract void a(PickUpPersonDetailsModel pickuppersondetailsmodel);

    public abstract void a(ShippingAddressDetailsModel shippingaddressdetailsmodel);

    public abstract void a(SmsRecipientDetailsModel smsrecipientdetailsmodel);

    public abstract ShippingAddressDetailsModel b();

    public abstract PickUpPersonDetailsModel c();

    public abstract EmailRecipientDetailsModel d();

    public abstract SmsRecipientDetailsModel e();
}
