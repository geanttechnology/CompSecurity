// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import org.altbeacon.beacon.Region;

public class StartRMData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private Region a;
    private long b;
    private long c;
    private boolean d;
    private String e;

    private StartRMData(Parcel parcel)
    {
        a = (Region)parcel.readParcelable(org/altbeacon/beacon/service/StartRMData.getClassLoader());
        e = parcel.readString();
        b = parcel.readLong();
        c = parcel.readLong();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }

    StartRMData(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public StartRMData(Region region, String s, long l, long l1, boolean flag)
    {
        b = l;
        c = l1;
        a = region;
        e = s;
        d = flag;
    }

    public long a()
    {
        return b;
    }

    public long b()
    {
        return c;
    }

    public Region c()
    {
        return a;
    }

    public String d()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return d;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, i);
        parcel.writeString(e);
        parcel.writeLong(b);
        parcel.writeLong(c);
        if (d)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }


    /* member class not found */
    class _cls1 {}

}
