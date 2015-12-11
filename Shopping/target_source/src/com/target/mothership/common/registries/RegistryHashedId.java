// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class RegistryHashedId
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RegistryHashedId a(Parcel parcel)
        {
            return new RegistryHashedId(parcel);
        }

        public RegistryHashedId[] a(int i)
        {
            return new RegistryHashedId[i];
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
    private String mRawId;

    public RegistryHashedId(Parcel parcel)
    {
        a(parcel);
    }

    public RegistryHashedId(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("Registry hashed id may not be empty or null");
        } else
        {
            mRawId = s;
            return;
        }
    }

    public void a(Parcel parcel)
    {
        mRawId = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (RegistryHashedId)obj;
            if (mRawId == null ? ((RegistryHashedId) (obj)).mRawId != null : !mRawId.equals(((RegistryHashedId) (obj)).mRawId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return mRawId.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
