// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;

public final class OTAInstallWaitReason extends Enum
    implements Parcelable
{

    private static final OTAInstallWaitReason $VALUES[];
    public static final OTAInstallWaitReason A2DPOn;
    public static final OTAInstallWaitReason AppNotIdle;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OTAInstallWaitReason createFromParcel(Parcel parcel)
        {
            return OTAInstallWaitReason.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OTAInstallWaitReason[] newArray(int i)
        {
            return new OTAInstallWaitReason[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final OTAInstallWaitReason CallOrRing;
    public static final OTAInstallWaitReason LowBatt;
    public static final OTAInstallWaitReason MTPIsNotIdleLongEnough;
    public static final OTAInstallWaitReason MusicOn;
    public static final OTAInstallWaitReason NotEnoughDiskSpace;
    public static final OTAInstallWaitReason NotEnoughIdleTime;
    public static final OTAInstallWaitReason NotEnoughScreenOffTime;
    public static final OTAInstallWaitReason ScreenOn;
    public static final OTAInstallWaitReason UMSOn;
    public static final OTAInstallWaitReason Unknown;
    private int mId;

    private OTAInstallWaitReason(String s, int i, int j)
    {
        super(s, i);
        mId = j;
    }

    public static OTAInstallWaitReason fromValue(int i)
    {
        OTAInstallWaitReason aotainstallwaitreason[] = values();
        int k = aotainstallwaitreason.length;
        for (int j = 0; j < k; j++)
        {
            OTAInstallWaitReason otainstallwaitreason = aotainstallwaitreason[j];
            if (otainstallwaitreason.mId == i)
            {
                return otainstallwaitreason;
            }
        }

        return Unknown;
    }

    public static OTAInstallWaitReason valueOf(String s)
    {
        return (OTAInstallWaitReason)Enum.valueOf(com/amazon/dcp/ota/OTAInstallWaitReason, s);
    }

    public static OTAInstallWaitReason[] values()
    {
        return (OTAInstallWaitReason[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mId);
    }

    static 
    {
        LowBatt = new OTAInstallWaitReason("LowBatt", 0, 0);
        NotEnoughDiskSpace = new OTAInstallWaitReason("NotEnoughDiskSpace", 1, 1);
        MusicOn = new OTAInstallWaitReason("MusicOn", 2, 2);
        A2DPOn = new OTAInstallWaitReason("A2DPOn", 3, 3);
        CallOrRing = new OTAInstallWaitReason("CallOrRing", 4, 4);
        ScreenOn = new OTAInstallWaitReason("ScreenOn", 5, 5);
        UMSOn = new OTAInstallWaitReason("UMSOn", 6, 6);
        MTPIsNotIdleLongEnough = new OTAInstallWaitReason("MTPIsNotIdleLongEnough", 7, 7);
        AppNotIdle = new OTAInstallWaitReason("AppNotIdle", 8, 8);
        NotEnoughScreenOffTime = new OTAInstallWaitReason("NotEnoughScreenOffTime", 9, 9);
        NotEnoughIdleTime = new OTAInstallWaitReason("NotEnoughIdleTime", 10, 10);
        Unknown = new OTAInstallWaitReason("Unknown", 11, 0x7fffffff);
        $VALUES = (new OTAInstallWaitReason[] {
            LowBatt, NotEnoughDiskSpace, MusicOn, A2DPOn, CallOrRing, ScreenOn, UMSOn, MTPIsNotIdleLongEnough, AppNotIdle, NotEnoughScreenOffTime, 
            NotEnoughIdleTime, Unknown
        });
    }
}
