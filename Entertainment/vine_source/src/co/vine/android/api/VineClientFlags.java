// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineClientFlags
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineClientFlags createFromParcel(Parcel parcel)
        {
            return new VineClientFlags(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineClientFlags[] newArray(int i)
        {
            return new VineClientFlags[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String apiHost;
    public String exploreHost;
    public String mediaHost;
    public String messageText;
    public String messageTitle;
    public String rtcHost;
    public long ttlSeconds;

    public VineClientFlags(Parcel parcel)
    {
        messageTitle = null;
        messageText = null;
        apiHost = null;
        rtcHost = null;
        mediaHost = null;
        exploreHost = null;
        ttlSeconds = 0L;
        messageTitle = parcel.readString();
        messageText = parcel.readString();
        apiHost = parcel.readString();
        rtcHost = parcel.readString();
        mediaHost = parcel.readString();
        exploreHost = parcel.readString();
        ttlSeconds = parcel.readLong();
    }

    public VineClientFlags(String s, String s1, String s2, String s3, String s4, String s5, long l)
    {
        messageTitle = null;
        messageText = null;
        apiHost = null;
        rtcHost = null;
        mediaHost = null;
        exploreHost = null;
        ttlSeconds = 0L;
        messageTitle = s;
        messageText = s1;
        apiHost = s2;
        rtcHost = s3;
        mediaHost = s4;
        exploreHost = s5;
        ttlSeconds = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(messageTitle);
        parcel.writeString(messageText);
        parcel.writeString(apiHost);
        parcel.writeString(rtcHost);
        parcel.writeString(mediaHost);
        parcel.writeString(exploreHost);
        parcel.writeLong(ttlSeconds);
    }

}
