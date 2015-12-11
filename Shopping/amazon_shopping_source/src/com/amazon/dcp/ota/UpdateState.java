// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;

public final class UpdateState extends Enum
    implements Parcelable
{

    private static final UpdateState $VALUES[];
    static final boolean $assertionsDisabled;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UpdateState createFromParcel(Parcel parcel)
        {
            return UpdateState.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UpdateState[] newArray(int i)
        {
            return new UpdateState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final UpdateState Complete;
    public static final UpdateState Deduped;
    public static final UpdateState DownloadPaused;
    public static final UpdateState Downloaded;
    public static final UpdateState Downloading;
    public static final UpdateState Failed;
    public static final UpdateState Installed;
    public static final UpdateState Installing;
    public static final UpdateState Pending;
    public static final String TAG = com/amazon/dcp/ota/UpdateState.getName();
    public static final UpdateState Unknown;
    private final int mValue;

    private UpdateState(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static UpdateState fromValue(int i)
    {
        UpdateState aupdatestate[] = values();
        int k = aupdatestate.length;
        for (int j = 0; j < k; j++)
        {
            UpdateState updatestate = aupdatestate[j];
            if (updatestate.value() == i)
            {
                return updatestate;
            }
        }

        return Unknown;
    }

    public static UpdateState valueOf(String s)
    {
        return (UpdateState)Enum.valueOf(com/amazon/dcp/ota/UpdateState, s);
    }

    public static UpdateState[] values()
    {
        return (UpdateState[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public int value()
    {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mValue);
    }

    static 
    {
        boolean flag;
        if (!com/amazon/dcp/ota/UpdateState.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        Pending = new UpdateState("Pending", 0, 0);
        Downloading = new UpdateState("Downloading", 1, 1);
        Downloaded = new UpdateState("Downloaded", 2, 2);
        Installing = new UpdateState("Installing", 3, 3);
        Installed = new UpdateState("Installed", 4, 4);
        Complete = new UpdateState("Complete", 5, 5);
        Failed = new UpdateState("Failed", 6, 6);
        Deduped = new UpdateState("Deduped", 7, 7);
        DownloadPaused = new UpdateState("DownloadPaused", 8, 8);
        Unknown = new UpdateState("Unknown", 9, 0x7fffffff);
        $VALUES = (new UpdateState[] {
            Pending, Downloading, Downloaded, Installing, Installed, Complete, Failed, Deduped, DownloadPaused, Unknown
        });
    }
}
