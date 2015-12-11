// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;

public class RtmInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RtmInfo createFromParcel(Parcel parcel)
        {
            return new RtmInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RtmInfo[] newArray(int i)
        {
            return new RtmInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int DEALS_CHANNEL_PLACEMENT_ID = 19794;
    public static final int DEPARTMENT_CHANNEL_PLACEMENT_ID = 19795;
    public static final int TODAY_CHANNEL_PLACEMENT_ID = 19793;
    public final String cguid;
    public final int placementId;
    public final int siteId;

    RtmInfo(Parcel parcel)
    {
        cguid = parcel.readString();
        siteId = parcel.readInt();
        placementId = parcel.readInt();
    }

    public RtmInfo(String s, int i, int j)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("cguid must not be null");
        } else
        {
            cguid = s;
            siteId = i;
            placementId = j;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("RtmInfo(").append(cguid).append(",").append(siteId).append(",").append(placementId).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(cguid);
        parcel.writeInt(siteId);
        parcel.writeInt(placementId);
    }

}
