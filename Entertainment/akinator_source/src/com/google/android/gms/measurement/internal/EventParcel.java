// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzj, EventParams

public final class EventParcel
    implements SafeParcelable
{

    public static final zzj CREATOR = new zzj();
    public final String name;
    public final int versionCode;
    public final EventParams zzaMk;
    public final String zzaMl;
    public final long zzaMm;

    EventParcel(int i, String s, EventParams eventparams, String s1, long l)
    {
        versionCode = i;
        name = s;
        zzaMk = eventparams;
        zzaMl = s1;
        zzaMm = l;
    }

    public EventParcel(String s, EventParams eventparams, String s1, long l)
    {
        versionCode = 1;
        name = s;
        zzaMk = eventparams;
        zzaMl = s1;
        zzaMm = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("origin=").append(zzaMl).append(",name=").append(name).append(",params=").append(zzaMk).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

}
