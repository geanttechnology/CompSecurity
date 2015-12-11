// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.o;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.product.interfaces.ProductAvailabilityStore;
import java.util.ArrayList;
import java.util.List;

public class TGTProductAvailabilityStore
    implements ProductAvailabilityStore
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductAvailabilityStore a(Parcel parcel)
        {
            return new TGTProductAvailabilityStore(parcel);
        }

        public TGTProductAvailabilityStore[] a(int j)
        {
            return new TGTProductAvailabilityStore[j];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int j)
        {
            return a(j);
        }

    };
    private i mInventoryStatus;
    private List mProductAvailabilityTypes;
    private int mSaleableQuantity;
    private StoreIdentifier mStoreId;

    TGTProductAvailabilityStore()
    {
    }

    private TGTProductAvailabilityStore(Parcel parcel)
    {
        mStoreId = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
        int k = parcel.readInt();
        i j;
        if (k == -1)
        {
            j = null;
        } else
        {
            j = i.values()[k];
        }
        mInventoryStatus = j;
        mSaleableQuantity = parcel.readInt();
        mProductAvailabilityTypes = new ArrayList();
        parcel.readList(mProductAvailabilityTypes, com/target/mothership/common/product/o.getClassLoader());
    }


    public StoreIdentifier a()
    {
        return mStoreId;
    }

    public void a(int j)
    {
        mSaleableQuantity = j;
    }

    public void a(i j)
    {
        mInventoryStatus = j;
    }

    public void a(StoreIdentifier storeidentifier)
    {
        mStoreId = storeidentifier;
    }

    public void a(List list)
    {
        mProductAvailabilityTypes = list;
    }

    public i b()
    {
        return mInventoryStatus;
    }

    public int c()
    {
        return mSaleableQuantity;
    }

    public List d()
    {
        return mProductAvailabilityTypes;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        parcel.writeParcelable(mStoreId, 0);
        if (mInventoryStatus == null)
        {
            j = -1;
        } else
        {
            j = mInventoryStatus.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeInt(mSaleableQuantity);
        parcel.writeList(mProductAvailabilityTypes);
    }

}
