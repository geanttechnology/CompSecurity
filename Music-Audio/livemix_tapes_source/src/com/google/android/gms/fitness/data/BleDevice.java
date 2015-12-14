// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmg;
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
    private final String zzanu;
    private final List zzanv;
    private final List zzanw;

    BleDevice(int i, String s, String s1, List list, List list1)
    {
        mVersionCode = i;
        zzanu = s;
        mName = s1;
        zzanv = Collections.unmodifiableList(list);
        zzanw = Collections.unmodifiableList(list1);
    }

    private boolean zza(BleDevice bledevice)
    {
        return mName.equals(bledevice.mName) && zzanu.equals(bledevice.zzanu) && zzmg.zza(bledevice.zzanv, zzanv) && zzmg.zza(zzanw, bledevice.zzanw);
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
        return zzanu;
    }

    public List getDataTypes()
    {
        return zzanw;
    }

    public String getName()
    {
        return mName;
    }

    public List getSupportedProfiles()
    {
        return zzanv;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            mName, zzanu, zzanv, zzanw
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("name", mName).zzg("address", zzanu).zzg("dataTypes", zzanw).zzg("supportedProfiles", zzanv).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
