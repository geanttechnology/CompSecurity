// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.common.product.d;
import com.target.mothership.common.store.InStoreLocation;
import com.target.mothership.common.store.StoreIdentifier;

class TGTProductInStoreLocation
    implements InStoreLocation
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductInStoreLocation a(Parcel parcel)
        {
            return new TGTProductInStoreLocation(parcel);
        }

        public TGTProductInStoreLocation[] a(int i)
        {
            return new TGTProductInStoreLocation[i];
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
    private String mAisle;
    private String mDepartment;
    private StoreIdentifier mStoreIdentifier;

    TGTProductInStoreLocation()
    {
    }

    TGTProductInStoreLocation(Parcel parcel)
    {
        a(parcel);
    }

    public d a()
    {
        return d.a(mDepartment);
    }

    public void a(Parcel parcel)
    {
        mDepartment = parcel.readString();
        mAisle = parcel.readString();
    }

    public void a(StoreIdentifier storeidentifier)
    {
        mStoreIdentifier = storeidentifier;
    }

    public void a(String s)
    {
        mDepartment = s;
    }

    public e b()
    {
        return e.c(mAisle);
    }

    public void b(String s)
    {
        mAisle = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mDepartment);
        parcel.writeString(mAisle);
    }

}
