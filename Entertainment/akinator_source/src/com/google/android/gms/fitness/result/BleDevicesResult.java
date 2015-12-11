// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zza

public class BleDevicesResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private final Status zzSC;
    private final List zzatc;

    BleDevicesResult(int i, List list, Status status)
    {
        mVersionCode = i;
        zzatc = Collections.unmodifiableList(list);
        zzSC = status;
    }

    public BleDevicesResult(List list, Status status)
    {
        mVersionCode = 3;
        zzatc = Collections.unmodifiableList(list);
        zzSC = status;
    }

    public static BleDevicesResult zzP(Status status)
    {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bledevicesresult)
    {
        return zzSC.equals(bledevicesresult.zzSC) && zzw.equal(zzatc, bledevicesresult.zzatc);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof BleDevicesResult) && zzb((BleDevicesResult)obj);
    }

    public List getClaimedBleDevices()
    {
        return zzatc;
    }

    public List getClaimedBleDevices(DataType datatype)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzatc.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BleDevice bledevice = (BleDevice)iterator.next();
            if (bledevice.getDataTypes().contains(datatype))
            {
                arraylist.add(bledevice);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
    }

    public Status getStatus()
    {
        return zzSC;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzatc
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("bleDevices", zzatc).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
