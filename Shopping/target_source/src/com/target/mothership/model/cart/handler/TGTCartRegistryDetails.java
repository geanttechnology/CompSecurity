// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.a.j;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;

public class TGTCartRegistryDetails
    implements CartRegistryDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTCartRegistryDetails a(Parcel parcel)
        {
            return new TGTCartRegistryDetails(parcel);
        }

        public TGTCartRegistryDetails[] a(int i)
        {
            return new TGTCartRegistryDetails[i];
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
    private RegistryId mRegistryId;
    private String mRegistryName;
    private j mRegistryType;

    TGTCartRegistryDetails()
    {
    }

    private TGTCartRegistryDetails(Parcel parcel)
    {
        mRegistryId = (RegistryId)parcel.readParcelable(com/target/mothership/common/registries/RegistryId.getClassLoader());
        mRegistryName = parcel.readString();
        int i = parcel.readInt();
        if (i == -1)
        {
            parcel = null;
        } else
        {
            parcel = j.values()[i];
        }
        mRegistryType = parcel;
    }


    public RegistryId a()
    {
        return mRegistryId;
    }

    public void a(j j1)
    {
        mRegistryType = j1;
    }

    public void a(RegistryId registryid)
    {
        mRegistryId = registryid;
    }

    public void a(String s)
    {
        mRegistryName = s;
    }

    public String b()
    {
        return mRegistryName;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mRegistryId, 0);
        parcel.writeString(mRegistryName);
        if (mRegistryType == null)
        {
            i = -1;
        } else
        {
            i = mRegistryType.ordinal();
        }
        parcel.writeInt(i);
    }

}
