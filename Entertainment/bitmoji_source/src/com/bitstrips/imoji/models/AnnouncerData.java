// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.os.Parcel;
import android.os.Parcelable;

public class AnnouncerData
    implements Parcelable
{

    private static final String ANNOUNCER_SHOWN_PREFIX = "announcer_shown_";
    public static final int ANNOUNCER_TYPE_FASHION = 0;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AnnouncerData createFromParcel(Parcel parcel)
        {
            return new AnnouncerData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AnnouncerData[] newArray(int i)
        {
            return new AnnouncerData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    int announcerId;
    int announcerType;
    boolean enabled;
    String link;

    public AnnouncerData(int i, int j, boolean flag, String s)
    {
        announcerType = i;
        announcerId = j;
        enabled = flag;
        link = s;
    }

    public AnnouncerData(Parcel parcel)
    {
        announcerId = parcel.readInt();
        announcerType = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        enabled = flag;
        link = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getAnnouncerId()
    {
        return announcerId;
    }

    public int getAnnouncerType()
    {
        return announcerType;
    }

    public boolean getEnabled()
    {
        return enabled;
    }

    public String getLink()
    {
        return link;
    }

    public String getPreferenceString()
    {
        return (new StringBuilder()).append("announcer_shown_").append(announcerId).toString();
    }

    public int getViewId()
    {
        switch (announcerType)
        {
        default:
            return -1;

        case 0: // '\0'
            return 0x7f0b0090;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(announcerId);
        parcel.writeInt(announcerType);
        if (enabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(link);
    }

}
