// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzo, DataSet, zzs

public final class RawDataSet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzo();
    final int mVersionCode;
    public final boolean zzanA;
    public final int zzaow;
    public final int zzaoy;
    public final List zzaoz;

    public RawDataSet(int i, int j, int k, List list, boolean flag)
    {
        mVersionCode = i;
        zzaow = j;
        zzaoy = k;
        zzaoz = list;
        zzanA = flag;
    }

    public RawDataSet(DataSet dataset, List list, List list1)
    {
        mVersionCode = 3;
        zzaoz = dataset.zzk(list);
        zzanA = dataset.zzrv();
        zzaow = zzs.zza(dataset.getDataSource(), list);
        zzaoy = zzs.zza(dataset.getDataType(), list1);
    }

    private boolean zza(RawDataSet rawdataset)
    {
        return zzaow == rawdataset.zzaow && zzanA == rawdataset.zzanA && zzw.equal(zzaoz, rawdataset.zzaoz);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof RawDataSet) && zza((RawDataSet)obj);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzaow)
        });
    }

    public String toString()
    {
        return String.format("RawDataSet{%s@[%s]}", new Object[] {
            Integer.valueOf(zzaow), zzaoz
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

}
