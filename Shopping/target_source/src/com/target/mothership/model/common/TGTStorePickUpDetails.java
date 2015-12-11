// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common;

import android.os.Parcel;
import com.target.mothership.common.store.StoreIdentifier;

// Referenced classes of package com.target.mothership.model.common:
//            StorePickUpDetails, PickUpPersonDetails, PickUpStoreAddress

public class TGTStorePickUpDetails
    implements StorePickUpDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStorePickUpDetails a(Parcel parcel)
        {
            return new TGTStorePickUpDetails(parcel);
        }

        public TGTStorePickUpDetails[] a(int i)
        {
            return new TGTStorePickUpDetails[i];
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
    private PickUpPersonDetails mPickUpPersonDetails;
    private PickUpStoreAddress mPickUpStoreAddress;
    private StoreIdentifier mStoreId;
    private String mStoreName;

    public TGTStorePickUpDetails()
    {
    }

    private TGTStorePickUpDetails(Parcel parcel)
    {
        mStoreId = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        mStoreName = parcel.readString();
        mPickUpPersonDetails = (PickUpPersonDetails)parcel.readParcelable(com/target/mothership/model/common/PickUpPersonDetails.getClassLoader());
        mPickUpStoreAddress = (PickUpStoreAddress)parcel.readParcelable(com/target/mothership/model/common/PickUpStoreAddress.getClassLoader());
    }


    public StoreIdentifier a()
    {
        return mStoreId;
    }

    public void a(StoreIdentifier storeidentifier)
    {
        mStoreId = storeidentifier;
    }

    public void a(PickUpPersonDetails pickuppersondetails)
    {
        mPickUpPersonDetails = pickuppersondetails;
    }

    public void a(PickUpStoreAddress pickupstoreaddress)
    {
        mPickUpStoreAddress = pickupstoreaddress;
    }

    public void a(String s)
    {
        mStoreName = s;
    }

    public String b()
    {
        return mStoreName;
    }

    public PickUpPersonDetails c()
    {
        return mPickUpPersonDetails;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mStoreId, 0);
        parcel.writeString(mStoreName);
        parcel.writeParcelable(mPickUpPersonDetails, 0);
        parcel.writeParcelable(mPickUpStoreAddress, i);
    }

}
