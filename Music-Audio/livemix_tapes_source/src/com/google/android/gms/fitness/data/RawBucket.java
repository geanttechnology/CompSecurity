// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzm, Bucket, DataSet, RawDataSet, 
//            Session

public final class RawBucket
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    public final long zzMS;
    public final boolean zzanA;
    public final long zzann;
    public final Session zzanp;
    public final List zzany;
    public final int zzanz;
    public final int zzaov;

    public RawBucket(int i, long l, long l1, Session session, int j, 
            List list, int k, boolean flag)
    {
        mVersionCode = i;
        zzMS = l;
        zzann = l1;
        zzanp = session;
        zzaov = j;
        zzany = list;
        zzanz = k;
        zzanA = flag;
    }

    public RawBucket(Bucket bucket, List list, List list1)
    {
        mVersionCode = 2;
        zzMS = bucket.getStartTime(TimeUnit.MILLISECONDS);
        zzann = bucket.getEndTime(TimeUnit.MILLISECONDS);
        zzanp = bucket.getSession();
        zzaov = bucket.zzru();
        zzanz = bucket.getBucketType();
        zzanA = bucket.zzrv();
        bucket = bucket.getDataSets();
        zzany = new ArrayList(bucket.size());
        DataSet dataset;
        for (bucket = bucket.iterator(); bucket.hasNext(); zzany.add(new RawDataSet(dataset, list, list1)))
        {
            dataset = (DataSet)bucket.next();
        }

    }

    private boolean zza(RawBucket rawbucket)
    {
        return zzMS == rawbucket.zzMS && zzann == rawbucket.zzann && zzaov == rawbucket.zzaov && zzw.equal(zzany, rawbucket.zzany) && zzanz == rawbucket.zzanz && zzanA == rawbucket.zzanA;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof RawBucket) && zza((RawBucket)obj);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzMS), Long.valueOf(zzann), Integer.valueOf(zzanz)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(zzMS)).zzg("endTime", Long.valueOf(zzann)).zzg("activity", Integer.valueOf(zzaov)).zzg("dataSets", zzany).zzg("bucketType", Integer.valueOf(zzanz)).zzg("serverHasMoreData", Boolean.valueOf(zzanA)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

}
