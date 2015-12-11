// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Object createFromParcel(Parcel parcel)
        {
            return zzeh(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzgn(i);
        }

        public RealTimeMessage zzeh(Parcel parcel)
        {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzgn(int i)
        {
            return new RealTimeMessage[i];
        }

    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaAL;
    private final byte zzaAM[];
    private final int zzaAN;

    private RealTimeMessage(Parcel parcel)
    {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }


    public RealTimeMessage(String s, byte abyte0[], int i)
    {
        zzaAL = (String)zzx.zzw(s);
        zzaAM = (byte[])((byte[])zzx.zzw(abyte0)).clone();
        zzaAN = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public byte[] getMessageData()
    {
        return zzaAM;
    }

    public String getSenderParticipantId()
    {
        return zzaAL;
    }

    public boolean isReliable()
    {
        return zzaAN == 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(zzaAL);
        parcel.writeByteArray(zzaAM);
        parcel.writeInt(zzaAN);
    }

}
