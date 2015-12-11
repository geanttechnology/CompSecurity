// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries.handler;

import android.os.Parcel;
import com.target.mothership.model.product.handler.TGTProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;

public class TGTRegistryProductDetails extends TGTProductDetails
    implements RegistryProductDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTRegistryProductDetails a(Parcel parcel)
        {
            return new TGTRegistryProductDetails(parcel);
        }

        public TGTRegistryProductDetails[] a(int i)
        {
            return new TGTRegistryProductDetails[i];
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
    private int mPurchasedQuantity;
    private int mRequestedQuantity;

    TGTRegistryProductDetails()
    {
    }

    TGTRegistryProductDetails(Parcel parcel)
    {
        super(parcel);
        mRequestedQuantity = parcel.readInt();
        mPurchasedQuantity = parcel.readInt();
    }

    public int K()
    {
        return mRequestedQuantity;
    }

    public int L()
    {
        return mPurchasedQuantity;
    }

    public void a(int i)
    {
        mRequestedQuantity = i;
    }

    public void b(int i)
    {
        mPurchasedQuantity = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(mRequestedQuantity);
        parcel.writeInt(mPurchasedQuantity);
    }

}
