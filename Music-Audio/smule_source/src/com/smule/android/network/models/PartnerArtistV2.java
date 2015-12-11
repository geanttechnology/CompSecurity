// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PartnerArtistV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PartnerArtistV2 a(Parcel parcel)
        {
            return new PartnerArtistV2(parcel);
        }

        public PartnerArtistV2[] a(int i)
        {
            return new PartnerArtistV2[i];
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
    public long accountId;
    public String facebookUrl;
    public String imageUrl;
    public String messageBody;
    public String messageTitle;
    public String name;
    public String partnerArtistId;
    public long ts;
    public String twitterUrl;
    public String videoUrl;

    public PartnerArtistV2()
    {
    }

    public PartnerArtistV2(Parcel parcel)
    {
        partnerArtistId = parcel.readString();
        ts = parcel.readLong();
        name = parcel.readString();
        imageUrl = parcel.readString();
        videoUrl = parcel.readString();
        messageTitle = parcel.readString();
        messageBody = parcel.readString();
        facebookUrl = parcel.readString();
        twitterUrl = parcel.readString();
        accountId = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(partnerArtistId);
        parcel.writeLong(ts);
        String s;
        if (name == null)
        {
            s = "";
        } else
        {
            s = name;
        }
        parcel.writeString(s);
        if (imageUrl == null)
        {
            s = "";
        } else
        {
            s = imageUrl;
        }
        parcel.writeString(s);
        if (videoUrl == null)
        {
            s = "";
        } else
        {
            s = videoUrl;
        }
        parcel.writeString(s);
        if (messageTitle == null)
        {
            s = "";
        } else
        {
            s = messageTitle;
        }
        parcel.writeString(s);
        if (messageBody == null)
        {
            s = "";
        } else
        {
            s = messageBody;
        }
        parcel.writeString(s);
        if (facebookUrl == null)
        {
            s = "";
        } else
        {
            s = facebookUrl;
        }
        parcel.writeString(s);
        if (twitterUrl == null)
        {
            s = "";
        } else
        {
            s = twitterUrl;
        }
        parcel.writeString(s);
        parcel.writeLong(accountId);
    }

}
