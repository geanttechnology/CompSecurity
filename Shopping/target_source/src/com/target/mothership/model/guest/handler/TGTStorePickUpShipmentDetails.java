// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.model.guest.interfaces.StorePickUpShipmentDetails;
import java.util.ArrayList;
import java.util.List;

public class TGTStorePickUpShipmentDetails
    implements StorePickUpShipmentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStorePickUpShipmentDetails a(Parcel parcel)
        {
            return new TGTStorePickUpShipmentDetails(parcel);
        }

        public TGTStorePickUpShipmentDetails[] a(int i)
        {
            return new TGTStorePickUpShipmentDetails[i];
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
    private boolean mIsEligibleToChangePickupInfo;
    private boolean mIsPickUpExtended;
    private List mProductList;
    private StorePickUpDetails mStorePickUpDetails;

    TGTStorePickUpShipmentDetails()
    {
    }

    private TGTStorePickUpShipmentDetails(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        mProductList = new ArrayList();
        parcel.readList(mProductList, com/target/mothership/model/guest/interfaces/OrderDetailsProduct.getClassLoader());
        mStorePickUpDetails = (StorePickUpDetails)parcel.readParcelable(com/target/mothership/model/common/StorePickUpDetails.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsEligibleToChangePickupInfo = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        mIsPickUpExtended = flag;
    }


    public List a()
    {
        return mProductList;
    }

    public void a(StorePickUpDetails storepickupdetails)
    {
        mStorePickUpDetails = storepickupdetails;
    }

    public void a(List list)
    {
        mProductList = list;
    }

    public void a(boolean flag)
    {
        mIsPickUpExtended = flag;
    }

    public StorePickUpDetails b()
    {
        return mStorePickUpDetails;
    }

    public void b(boolean flag)
    {
        mIsEligibleToChangePickupInfo = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeList(mProductList);
        parcel.writeParcelable(mStorePickUpDetails, i);
        byte byte0;
        if (mIsEligibleToChangePickupInfo)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mIsPickUpExtended)
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
