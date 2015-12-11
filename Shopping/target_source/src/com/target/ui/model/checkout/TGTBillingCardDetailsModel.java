// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.checkout;

import android.os.Parcel;
import com.target.mothership.common.params.AddressParams;

// Referenced classes of package com.target.ui.model.checkout:
//            BillingCardDetailsModel, CardDataModel

public class TGTBillingCardDetailsModel
    implements BillingCardDetailsModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTBillingCardDetailsModel a(Parcel parcel)
        {
            return new TGTBillingCardDetailsModel(parcel);
        }

        public TGTBillingCardDetailsModel[] a(int i)
        {
            return new TGTBillingCardDetailsModel[i];
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
    private AddressParams mAddressParams;
    private CardDataModel mCardData;

    public TGTBillingCardDetailsModel()
    {
    }

    private TGTBillingCardDetailsModel(Parcel parcel)
    {
        mCardData = (CardDataModel)parcel.readParcelable(com/target/ui/model/checkout/CardDataModel.getClassLoader());
        mAddressParams = (AddressParams)parcel.readParcelable(com/target/ui/model/checkout/CardDataModel.getClassLoader());
    }


    public CardDataModel a()
    {
        return mCardData;
    }

    public void a(AddressParams addressparams)
    {
        mAddressParams = addressparams;
    }

    public void a(CardDataModel carddatamodel)
    {
        mCardData = carddatamodel;
    }

    public AddressParams b()
    {
        return mAddressParams;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mCardData, i);
        parcel.writeParcelable(mAddressParams, i);
    }

}
