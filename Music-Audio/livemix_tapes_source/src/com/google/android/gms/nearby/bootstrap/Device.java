// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.nearby.bootstrap:
//            zzb

public class Device
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzaIZ;
    private final byte zzaJa;

    Device(int i, String s, String s1, String s2, byte byte0)
    {
        versionCode = i;
        name = zzx.zzcs(s);
        description = (String)zzx.zzv(s1);
        zzaIZ = (String)zzx.zzv(s2);
        boolean flag;
        if (byte0 <= 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Unknown device type");
        zzaJa = byte0;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDeviceId()
    {
        return zzaIZ;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append(": ").append(description).append("[").append(zzaJa).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public byte zzyc()
    {
        return zzaJa;
    }

}
