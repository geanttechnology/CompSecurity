// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.c.c;

public class RangingData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private Collection a;
    private Region b;

    private RangingData(Parcel parcel)
    {
        c.a("RangingData", "parsing RangingData", new Object[0]);
        Parcelable aparcelable[] = parcel.readParcelableArray(getClass().getClassLoader());
        a = new ArrayList(aparcelable.length);
        for (int i = 0; i < aparcelable.length; i++)
        {
            a.add((Beacon)aparcelable[i]);
        }

        b = (Region)parcel.readParcelable(getClass().getClassLoader());
    }

    RangingData(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public RangingData(Collection collection, Region region)
    {
        collection;
        JVM INSTR monitorenter ;
        a = collection;
        collection;
        JVM INSTR monitorexit ;
        b = region;
        return;
        region;
        collection;
        JVM INSTR monitorexit ;
        throw region;
    }

    public Collection a()
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
        c.a("RangingData", "writing RangingData", new Object[0]);
        parcel.writeParcelableArray((Parcelable[])a.toArray(new Parcelable[0]), i);
        parcel.writeParcelable(b, i);
        c.a("RangingData", "done writing RangingData", new Object[0]);
    }


    /* member class not found */
    class _cls1 {}

}
