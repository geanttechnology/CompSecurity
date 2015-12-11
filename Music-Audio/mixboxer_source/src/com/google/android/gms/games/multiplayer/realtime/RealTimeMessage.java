// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.eg;

public final class RealTimeMessage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RealTimeMessage[] aK(int i)
        {
            return new RealTimeMessage[i];
        }

        public RealTimeMessage ac(Parcel parcel)
        {
            return new RealTimeMessage(parcel);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return ac(parcel);
        }

        public Object[] newArray(int i)
        {
            return aK(i);
        }

    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String wA;
    private final byte wB[];
    private final int wC;

    private RealTimeMessage(Parcel parcel)
    {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }


    public RealTimeMessage(String s, byte abyte0[], int i)
    {
        wA = (String)eg.f(s);
        wB = (byte[])((byte[])eg.f(abyte0)).clone();
        wC = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public byte[] getMessageData()
    {
        return wB;
    }

    public String getSenderParticipantId()
    {
        return wA;
    }

    public boolean isReliable()
    {
        return wC == 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(wA);
        parcel.writeByteArray(wB);
        parcel.writeInt(wC);
    }

}
