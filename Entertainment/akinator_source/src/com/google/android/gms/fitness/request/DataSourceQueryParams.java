// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzg

public class DataSourceQueryParams
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    final int mVersionCode;
    public final long zzRr;
    public final DataSource zzapM;
    public final long zzaqc;
    public final int zzasm;
    public final long zzasr;
    public final int zzass;

    DataSourceQueryParams(int i, DataSource datasource, long l, long l1, long l2, int j, int k)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzRr = l;
        zzaqc = l1;
        zzasr = l2;
        zzasm = j;
        zzass = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
