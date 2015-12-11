// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.os.Bundle;
import android.os.Parcel;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;

public class VirtuosoDownloadEngineStatus
    implements IVirtuosoDownloadEngineStatus
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VirtuosoDownloadEngineStatus createFromParcel(Parcel parcel)
        {
            return new VirtuosoDownloadEngineStatus(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VirtuosoDownloadEngineStatus[] newArray(int i)
        {
            return new VirtuosoDownloadEngineStatus[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Bundle iExtras;
    public com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus iStatus;

    public VirtuosoDownloadEngineStatus()
    {
        iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
        iExtras = new Bundle();
    }

    public VirtuosoDownloadEngineStatus(Parcel parcel)
    {
        iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle;
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public Bundle extras()
    {
        return iExtras;
    }

    protected void readFromParcel(Parcel parcel)
    {
        iStatus = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.values()[parcel.readInt()];
        iExtras = parcel.readBundle(getClass().getClassLoader());
    }

    public com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus status()
    {
        return iStatus;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(iStatus.ordinal());
        parcel.writeBundle(iExtras);
    }

}
