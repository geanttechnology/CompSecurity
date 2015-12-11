// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CardInfo
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CardInfo a(Parcel parcel)
        {
            return new CardInfo(parcel);
        }

        public CardInfo[] a(int i)
        {
            return new CardInfo[i];
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
    public String backgroundUrl16x9;
    public String backgroundUrl4x3;
    public String backgroundUrlIphone;
    public String backgroundUrlSquare;
    public boolean enabled;
    public int frameId;
    public String name;

    public CardInfo()
    {
    }

    public CardInfo(Parcel parcel)
    {
        boolean flag = true;
        super();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        enabled = flag;
        frameId = parcel.readInt();
        name = parcel.readString();
        backgroundUrlIphone = parcel.readString();
        backgroundUrlSquare = parcel.readString();
        backgroundUrl16x9 = parcel.readString();
        backgroundUrl4x3 = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("CardInfo [enabled=").append(enabled).append(", frameId=").append(frameId).append(", name=").append(name).append(", frameId=").append(frameId).append(", backgroundUrlIphone=").append(backgroundUrlIphone).append(", backgroundUrlSquare=").append(backgroundUrlSquare).append(", backgroundUrl16x9=").append(backgroundUrl16x9).append(", backgroundUrl4x3=").append(backgroundUrl4x3).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (enabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(frameId);
        parcel.writeString(name);
        parcel.writeString(backgroundUrlIphone);
        parcel.writeString(backgroundUrlSquare);
        parcel.writeString(backgroundUrl16x9);
        parcel.writeString(backgroundUrl4x3);
    }

}
