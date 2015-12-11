// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;

// Referenced classes of package com.target.ui.model.checkout:
//            DeliveryDetailsModel, DeliveryTypedProducts, ShippingAddressDetailsModel, PickUpPersonDetailsModel, 
//            EmailRecipientDetailsModel, SmsRecipientDetailsModel

public class TGTDeliveryDetailsModel
    implements DeliveryDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTDeliveryDetailsModel a(Parcel parcel)
        {
            return new TGTDeliveryDetailsModel(parcel);
        }

        public TGTDeliveryDetailsModel[] a(int i)
        {
            return new TGTDeliveryDetailsModel[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private DeliveryTypedProducts mDeliveryTypedProducts;
    private EmailRecipientDetailsModel mEmailRecipientDetails;
    private PickUpPersonDetailsModel mPickUpPersonDetails;
    private ShippingAddressDetailsModel mShippingAddressDetails;
    private SmsRecipientDetailsModel mSmsRecipientDetails;

    public TGTDeliveryDetailsModel()
    {
    }

    private TGTDeliveryDetailsModel(Parcel parcel)
    {
        mDeliveryTypedProducts = (DeliveryTypedProducts)parcel.readParcelable(com/target/ui/model/checkout/DeliveryTypedProducts.getClassLoader());
        mShippingAddressDetails = (ShippingAddressDetailsModel)parcel.readParcelable(com/target/ui/model/checkout/ShippingAddressDetailsModel.getClassLoader());
        mPickUpPersonDetails = (PickUpPersonDetailsModel)parcel.readParcelable(com/target/ui/model/checkout/PickUpPersonDetailsModel.getClassLoader());
        mEmailRecipientDetails = (EmailRecipientDetailsModel)parcel.readParcelable(com/target/ui/model/checkout/EmailRecipientDetailsModel.getClassLoader());
        mSmsRecipientDetails = (SmsRecipientDetailsModel)parcel.readParcelable(com/target/ui/model/checkout/SmsRecipientDetailsModel.getClassLoader());
    }


    public DeliveryTypedProducts a()
    {
        return mDeliveryTypedProducts;
    }

    public void a(DeliveryTypedProducts deliverytypedproducts)
    {
        mDeliveryTypedProducts = deliverytypedproducts;
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        mEmailRecipientDetails = emailrecipientdetailsmodel;
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        mPickUpPersonDetails = pickuppersondetailsmodel;
    }

    public void a(ShippingAddressDetailsModel shippingaddressdetailsmodel)
    {
        mShippingAddressDetails = shippingaddressdetailsmodel;
    }

    public void a(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        mSmsRecipientDetails = smsrecipientdetailsmodel;
    }

    public ShippingAddressDetailsModel b()
    {
        return mShippingAddressDetails;
    }

    public PickUpPersonDetailsModel c()
    {
        return mPickUpPersonDetails;
    }

    public EmailRecipientDetailsModel d()
    {
        return mEmailRecipientDetails;
    }

    public int describeContents()
    {
        return 0;
    }

    public SmsRecipientDetailsModel e()
    {
        return mSmsRecipientDetails;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mDeliveryTypedProducts, 0);
        parcel.writeParcelable(mShippingAddressDetails, 0);
        parcel.writeParcelable(mPickUpPersonDetails, 0);
        parcel.writeParcelable(mEmailRecipientDetails, 0);
        parcel.writeParcelable(mSmsRecipientDetails, 0);
    }

}
