// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import org.altbeacon.beacon.Region;

public class MonitoringData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean a;
    private Region b;

    private MonitoringData(Parcel parcel)
    {
        boolean flag = true;
        super();
        if (parcel.readByte() != 1)
        {
            flag = false;
        }
        a = flag;
        b = (Region)parcel.readParcelable(getClass().getClassLoader());
    }

    MonitoringData(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public MonitoringData(boolean flag, Region region)
    {
        a = flag;
        b = region;
    }

    public boolean a()
    {
        return a;
    }

    public Region b()
    {
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j;
        if (a)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeParcelable(b, i);
    }


    /* member class not found */
    class _cls1 {}

}
