// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzc, RawBucket, DataSet, RawDataSet, 
//            DataType, Session

public class Bucket
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final long zzNY;
    private final long zzapN;
    private final Session zzapP;
    private final int zzapX;
    private final List zzapY;
    private final int zzapZ;
    private boolean zzaqa;

    Bucket(int i, long l, long l1, Session session, int j, 
            List list, int k, boolean flag)
    {
        zzaqa = false;
        mVersionCode = i;
        zzNY = l;
        zzapN = l1;
        zzapP = session;
        zzapX = j;
        zzapY = list;
        zzapZ = k;
        zzaqa = flag;
    }

    public Bucket(RawBucket rawbucket, List list)
    {
        this(2, rawbucket.zzNY, rawbucket.zzapN, rawbucket.zzapP, rawbucket.zzaqT, zza(rawbucket.zzapY, list), rawbucket.zzapZ, rawbucket.zzaqa);
    }

    private static List zza(Collection collection, List list)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new DataSet((RawDataSet)collection.next(), list))) { }
        return arraylist;
    }

    private boolean zza(Bucket bucket)
    {
        return zzNY == bucket.zzNY && zzapN == bucket.zzapN && zzapX == bucket.zzapX && zzw.equal(zzapY, bucket.zzapY) && zzapZ == bucket.zzapZ && zzaqa == bucket.zzaqa;
    }

    public static String zzeu(int i)
    {
        switch (i)
        {
        default:
            return "bug";

        case 1: // '\001'
            return "time";

        case 3: // '\003'
            return "type";

        case 4: // '\004'
            return "segment";

        case 2: // '\002'
            return "session";

        case 0: // '\0'
            return "unknown";
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof Bucket) && zza((Bucket)obj);
    }

    public String getActivity()
    {
        return FitnessActivities.getName(zzapX);
    }

    public int getBucketType()
    {
        return zzapZ;
    }

    public DataSet getDataSet(DataType datatype)
    {
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext();)
        {
            DataSet dataset = (DataSet)iterator.next();
            if (dataset.getDataType().equals(datatype))
            {
                return dataset;
            }
        }

        return null;
    }

    public List getDataSets()
    {
        return zzapY;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzapN, TimeUnit.MILLISECONDS);
    }

    public Session getSession()
    {
        return zzapP;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzNY, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzNY), Long.valueOf(zzapN), Integer.valueOf(zzapX), Integer.valueOf(zzapZ)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("startTime", Long.valueOf(zzNY)).zzg("endTime", Long.valueOf(zzapN)).zzg("activity", Integer.valueOf(zzapX)).zzg("dataSets", zzapY).zzg("bucketType", zzeu(zzapZ)).zzg("serverHasMoreData", Boolean.valueOf(zzaqa)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public boolean zzb(Bucket bucket)
    {
        return zzNY == bucket.zzNY && zzapN == bucket.zzapN && zzapX == bucket.zzapX && zzapZ == bucket.zzapZ;
    }

    public long zzkX()
    {
        return zzNY;
    }

    public int zzsg()
    {
        return zzapX;
    }

    public boolean zzsh()
    {
        if (zzaqa)
        {
            return true;
        }
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext();)
        {
            if (((DataSet)iterator.next()).zzsh())
            {
                return true;
            }
        }

        return false;
    }

    public long zzsi()
    {
        return zzapN;
    }

}
