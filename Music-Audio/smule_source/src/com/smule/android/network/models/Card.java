// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, PerformanceV2

public class Card
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Card a(Parcel parcel)
        {
            return new Card(parcel);
        }

        public Card[] a(int i)
        {
            return new Card[i];
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
    public AccountIcon accountIcon;
    public String cardKey;
    public long expireAt;
    public int frameId;
    public String message;
    public PerformanceV2 performanceIcon;
    public String url;

    public Card()
    {
    }

    public Card(Parcel parcel)
    {
        cardKey = parcel.readString();
        accountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        performanceIcon = (PerformanceV2)parcel.readParcelable(com/smule/android/network/models/PerformanceV2.getClassLoader());
        url = parcel.readString();
        message = parcel.readString();
        frameId = parcel.readInt();
        expireAt = parcel.readLong();
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Card [cardKey=").append(cardKey).append(", url=").append(url).append(", message=").append(message).append(", frameId=").append(frameId).append(", expireAt=").append(expireAt).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (cardKey == null)
        {
            s = "";
        } else
        {
            s = cardKey;
        }
        parcel.writeString(s);
        parcel.writeParcelable(accountIcon, 0);
        parcel.writeParcelable(performanceIcon, 0);
        if (url == null)
        {
            s = "";
        } else
        {
            s = url;
        }
        parcel.writeString(s);
        if (message == null)
        {
            s = "";
        } else
        {
            s = message;
        }
        parcel.writeString(s);
        parcel.writeInt(frameId);
        parcel.writeLong(expireAt);
    }

}
