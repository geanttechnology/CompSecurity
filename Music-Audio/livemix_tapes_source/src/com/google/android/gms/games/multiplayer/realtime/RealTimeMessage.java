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
            return zzdW(parcel);
        }

        public Object[] newArray(int i)
        {
            return zzge(i);
        }

        public RealTimeMessage zzdW(Parcel parcel)
        {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzge(int i)
        {
            return new RealTimeMessage[i];
        }

    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzayl;
    private final byte zzaym[];
    private final int zzayn;

    private RealTimeMessage(Parcel parcel)
    {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }


    public RealTimeMessage(String s, byte abyte0[], int i)
    {
        zzayl = (String)zzx.zzv(s);
        zzaym = (byte[])((byte[])zzx.zzv(abyte0)).clone();
        zzayn = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public byte[] getMessageData()
    {
        return zzaym;
    }

    public String getSenderParticipantId()
    {
        return zzayl;
    }

    public boolean isReliable()
    {
        return zzayn == 1;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(zzayl);
        parcel.writeByteArray(zzaym);
        parcel.writeInt(zzayn);
    }

}
