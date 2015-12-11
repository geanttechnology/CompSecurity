// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import android.os.Parcel;
import android.os.Parcelable;
import com.digimarc.dms.DMSCpmBase;

public class Payload
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Payload createFromParcel(Parcel parcel)
        {
            String s = parcel.readString();
            parcel = null;
            if (s != null)
            {
                parcel = new Payload(s);
            }
            return parcel;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Payload[] newArray(int i)
        {
            return null;
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String mCpmPath;
    private String mPayloadString;
    private int mPayloadType;

    public Payload(int i, long l)
    {
        mPayloadType = i;
        mPayloadString = Long.toHexString(l);
        mCpmPath = (new StringBuilder("GC41.KE.WOM1.v")).append(String.valueOf(i)).append(".").append(mPayloadString).toString();
    }

    public Payload(String s)
    {
        DMSCpmBase dmscpmbase = new DMSCpmBase(s);
        mCpmPath = s;
        mPayloadType = dmscpmbase.getType();
        mPayloadString = dmscpmbase.getId();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Payload payload)
    {
        return mCpmPath == null && payload.mCpmPath == null || mCpmPath != null && payload.mCpmPath != null && mCpmPath.equals(payload.mCpmPath);
    }

    public String getCpmPath()
    {
        return mCpmPath;
    }

    public String getPayloadDataAsString()
    {
        if (mPayloadType == 5 || mPayloadType == 6 || mPayloadType == 254 || mPayloadType == 255)
        {
            return String.valueOf(Long.parseLong(mPayloadString, 16));
        } else
        {
            return mPayloadString;
        }
    }

    public int getPayloadType()
    {
        return mPayloadType;
    }

    public String toString()
    {
        return mCpmPath;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPayloadString);
    }

}
