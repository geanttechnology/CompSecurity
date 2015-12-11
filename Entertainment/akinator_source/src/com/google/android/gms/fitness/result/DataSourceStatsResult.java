// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzd

public class DataSourceStatsResult
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    public final long zzRr;
    public final DataSource zzapM;
    public final boolean zzatg;
    public final long zzath;
    public final long zzati;

    DataSourceStatsResult(int i, DataSource datasource, long l, boolean flag, long l1, 
            long l2)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzRr = l;
        zzatg = flag;
        zzath = l1;
        zzati = l2;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
