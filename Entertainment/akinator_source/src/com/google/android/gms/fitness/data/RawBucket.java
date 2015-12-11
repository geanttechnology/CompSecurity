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
    public final long zzNY;
    public final long zzapN;
    public final Session zzapP;
    public final List zzapY;
    public final int zzapZ;
    public final int zzaqT;
    public final boolean zzaqa;

    public RawBucket(int i, long l, long l1, Session session, int j, 
            List list, int k, boolean flag)
    {
        mVersionCode = i;
        zzNY = l;
        zzapN = l1;
        zzapP = session;
        zzaqT = j;
        zzapY = list;
        zzapZ = k;
        zzaqa = flag;
    }

    public RawBucket(Bucket bucket, List list, List list1)
    {
        mVersionCode = 2;
        zzNY = bucket.getStartTime(TimeUnit.MILLISECONDS);
        zzapN = bucket.getEndTime(TimeUnit.MILLISECONDS);
        zzapP = bucket.getSession();
        zzaqT = bucket.zzsg();
        zzapZ = bucket.getBucketType();
        zzaqa = bucket.zzsh();
        bucket = bucket.getDataSets();
        zzapY = new ArrayList(bucket.size());
        DataSet dataset;
        for (bucket = bucket.iterator(); bucket.hasNext(); zzapY.add(new RawDataSet(dataset, list, list1)))
        {
            dataset = (DataSet)bucket.next();
        }

    }

    private boolean zza(RawBucket rawbucket)
    {
        return zzNY == rawbucket.zzNY && zzapN == rawbucket.zzapN && zzaqT == rawbucket.zzaqT && zzw.equal(zzapY, rawbucket.zzapY) && zzapZ == rawbucket.zzapZ && zzaqa == rawbucket.zzaqa;
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
            Long.valueOf(zzNY), Long.valueOf(zzapN), Integer.valueOf(zzapZ)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("startTime", Long.valueOf(zzNY)).zzg("endTime", Long.valueOf(zzapN)).zzg("activity", Integer.valueOf(zzaqT)).zzg("dataSets", zzapY).zzg("bucketType", Integer.valueOf(zzapZ)).zzg("serverHasMoreData", Boolean.valueOf(zzaqa)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

}
