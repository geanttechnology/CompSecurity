// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import android.os.Parcel;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;

public class TGTStore
    implements Store
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTStore a(Parcel parcel)
        {
            return new TGTStore(parcel);
        }

        public TGTStore[] a(int i)
        {
            return new TGTStore[i];
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
    private StoreIdentifier mStoreId;

    protected TGTStore(Parcel parcel)
    {
        mStoreId = (StoreIdentifier)parcel.readParcelable(com/target/mothership/common/store/StoreIdentifier.getClassLoader());
    }

    public TGTStore(StoreIdentifier storeidentifier)
    {
        mStoreId = storeidentifier;
    }

    public int describeContents()
    {
        return 0;
    }

    public StoreIdentifier getStoreId()
    {
        return mStoreId;
    }

    public String toString()
    {
        return (new StringBuilder()).append("TGTStore{mStoreId=").append(mStoreId).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mStoreId, 0);
    }

}
