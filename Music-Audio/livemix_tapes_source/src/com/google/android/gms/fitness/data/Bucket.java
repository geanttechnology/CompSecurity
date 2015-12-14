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
    private final long zzMS;
    private boolean zzanA;
    private final long zzann;
    private final Session zzanp;
    private final int zzanx;
    private final List zzany;
    private final int zzanz;

    Bucket(int i, long l, long l1, Session session, int j, 
            List list, int k, boolean flag)
    {
        zzanA = false;
        mVersionCode = i;
        zzMS = l;
        zzann = l1;
        zzanp = session;
        zzanx = j;
        zzany = list;
        zzanz = k;
        zzanA = flag;
    }

    public Bucket(RawBucket rawbucket, List list)
    {
        this(2, rawbucket.zzMS, rawbucket.zzann, rawbucket.zzanp, rawbucket.zzaov, zza(rawbucket.zzany, list), rawbucket.zzanz, rawbucket.zzanA);
    }

    private static List zza(Collection collection, List list)
    {
        ArrayList arraylist = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(new DataSet((RawDataSet)collection.next(), list))) { }
        return arraylist;
    }

    private boolean zza(Bucket bucket)
    {
        return zzMS == bucket.zzMS && zzann == bucket.zzann && zzanx == bucket.zzanx && zzw.equal(zzany, bucket.zzany) && zzanz == bucket.zzanz && zzanA == bucket.zzanA;
    }

    public static String zzel(int i)
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
        return FitnessActivities.getName(zzanx);
    }

    public int getBucketType()
    {
        return zzanz;
    }

    public DataSet getDataSet(DataType datatype)
    {
        for (Iterator iterator = zzany.iterator(); iterator.hasNext();)
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
        return zzany;
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzann, TimeUnit.MILLISECONDS);
    }

    public Session getSession()
    {
        return zzanp;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzMS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzMS), Long.valueOf(zzann), Integer.valueOf(zzanx), Integer.valueOf(zzanz)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(zzMS)).zzg("endTime", Long.valueOf(zzann)).zzg("activity", Integer.valueOf(zzanx)).zzg("dataSets", zzany).zzg("bucketType", zzel(zzanz)).zzg("serverHasMoreData", Boolean.valueOf(zzanA)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public boolean zzb(Bucket bucket)
    {
        return zzMS == bucket.zzMS && zzann == bucket.zzann && zzanx == bucket.zzanx && zzanz == bucket.zzanz;
    }

    public long zzkH()
    {
        return zzMS;
    }

    public int zzru()
    {
        return zzanx;
    }

    public boolean zzrv()
    {
        if (zzanA)
        {
            return true;
        }
        for (Iterator iterator = zzany.iterator(); iterator.hasNext();)
        {
            if (((DataSet)iterator.next()).zzrv())
            {
                return true;
            }
        }

        return false;
    }

    public long zzrw()
    {
        return zzann;
    }

}
