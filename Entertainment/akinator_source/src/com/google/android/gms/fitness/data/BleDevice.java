// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzni;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzb

public class BleDevice
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final String mName;
    private final int mVersionCode;
    private final String zzapU;
    private final List zzapV;
    private final List zzapW;

    BleDevice(int i, String s, String s1, List list, List list1)
    {
        mVersionCode = i;
        zzapU = s;
        mName = s1;
        zzapV = Collections.unmodifiableList(list);
        zzapW = Collections.unmodifiableList(list1);
    }

    private boolean zza(BleDevice bledevice)
    {
        return mName.equals(bledevice.mName) && zzapU.equals(bledevice.zzapU) && zzni.zza(bledevice.zzapV, zzapV) && zzni.zza(zzapW, bledevice.zzapW);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof BleDevice) && zza((BleDevice)obj);
    }

    public String getAddress()
    {
        return zzapU;
    }

    public List getDataTypes()
    {
        return zzapW;
    }

    public String getName()
    {
        return mName;
    }

    public List getSupportedProfiles()
    {
        return zzapV;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mName, zzapU, zzapV, zzapW
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("name", mName).zzg("address", zzapU).zzg("dataTypes", zzapW).zzg("supportedProfiles", zzapV).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
