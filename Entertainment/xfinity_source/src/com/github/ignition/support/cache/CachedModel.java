// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

public abstract class CachedModel
    implements Parcelable
{

    private String id;
    private long transactionId;

    public CachedModel()
    {
        transactionId = 0x8000000000000000L;
    }

    public CachedModel(Parcel parcel)
        throws IOException
    {
        transactionId = 0x8000000000000000L;
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void readFromParcel(Parcel parcel)
        throws IOException
    {
        id = parcel.readString();
        transactionId = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeLong(transactionId);
    }
}
