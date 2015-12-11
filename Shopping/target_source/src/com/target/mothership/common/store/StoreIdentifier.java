// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.store;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.util.o;

public class StoreIdentifier
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StoreIdentifier a(Parcel parcel)
        {
            return new StoreIdentifier(parcel);
        }

        public StoreIdentifier[] a(int i)
        {
            return new StoreIdentifier[i];
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
    private final String mRawId;

    private StoreIdentifier(Parcel parcel)
    {
        this(parcel.readString());
    }


    public StoreIdentifier(String s)
    {
        if (o.c(s))
        {
            throw new IllegalArgumentException("store id may not be blank or null");
        } else
        {
            mRawId = s;
            return;
        }
    }

    public String a()
    {
        return mRawId;
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
            obj = (StoreIdentifier)obj;
            if (mRawId == null ? ((StoreIdentifier) (obj)).mRawId != null : !mRawId.equals(((StoreIdentifier) (obj)).mRawId))
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

    public String toString()
    {
        return (new StringBuilder()).append("StoreIdentifier{mRawId='").append(mRawId).append('\'').append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mRawId);
    }

}
