// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzc

public class DataReadResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private final Status zzSC;
    private final List zzapY;
    private final List zzaqi;
    private final List zzatd;
    private int zzate;
    private final List zzatf;

    DataReadResult(int i, List list, Status status, List list1, int j, List list2, List list3)
    {
        mVersionCode = i;
        zzSC = status;
        zzate = j;
        zzaqi = list2;
        zzatf = list3;
        zzapY = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); zzapY.add(new DataSet(status, list2)))
        {
            status = (RawDataSet)list.next();
        }

        zzatd = new ArrayList(list1.size());
        for (list = list1.iterator(); list.hasNext(); zzatd.add(new Bucket(status, list2)))
        {
            status = (RawBucket)list.next();
        }

    }

    public DataReadResult(List list, List list1, Status status)
    {
        mVersionCode = 5;
        zzapY = list;
        zzSC = status;
        zzatd = list1;
        zzate = 1;
        zzaqi = new ArrayList();
        zzatf = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest datareadrequest)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = datareadrequest.getDataSources().iterator(); iterator.hasNext(); arraylist.add(DataSet.create((DataSource)iterator.next()))) { }
        DataType datatype;
        for (datareadrequest = datareadrequest.getDataTypes().iterator(); datareadrequest.hasNext(); arraylist.add(DataSet.create((new com.google.android.gms.fitness.data.DataSource.Builder()).setDataType(datatype).setType(1).setName("Default").build())))
        {
            datatype = (DataType)datareadrequest.next();
        }

        return new DataReadResult(arraylist, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List list)
    {
label0:
        {
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                list = (Bucket)iterator.next();
                if (list.zzb(bucket))
                {
                    for (bucket = bucket.getDataSets().iterator(); bucket.hasNext(); zza((DataSet)bucket.next(), list.getDataSets())) { }
                    break label0;
                }
            }

            zzatd.add(bucket);
        }
    }

    private void zza(DataSet dataset, List list)
    {
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            DataSet dataset1 = (DataSet)iterator.next();
            if (dataset1.getDataSource().equals(dataset.getDataSource()))
            {
                dataset1.zzb(dataset.getDataPoints());
                return;
            }
        }

        list.add(dataset);
    }

    private boolean zzc(DataReadResult datareadresult)
    {
        return zzSC.equals(datareadresult.zzSC) && zzw.equal(zzapY, datareadresult.zzapY) && zzw.equal(zzatd, datareadresult.zzatd);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataReadResult) && zzc((DataReadResult)obj);
    }

    public List getBuckets()
    {
        return zzatd;
    }

    public DataSet getDataSet(DataSource datasource)
    {
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext();)
        {
            DataSet dataset = (DataSet)iterator.next();
            if (datasource.equals(dataset.getDataSource()))
            {
                return dataset;
            }
        }

        return DataSet.create(datasource);
    }

    public DataSet getDataSet(DataType datatype)
    {
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext();)
        {
            DataSet dataset = (DataSet)iterator.next();
            if (datatype.equals(dataset.getDataType()))
            {
                return dataset;
            }
        }

        return DataSet.create((new com.google.android.gms.fitness.data.DataSource.Builder()).setDataType(datatype).setType(1).build());
    }

    public List getDataSets()
    {
        return zzapY;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzapY, zzatd
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(this).zzg("status", zzSC);
        Object obj;
        if (zzapY.size() > 5)
        {
            obj = (new StringBuilder()).append(zzapY.size()).append(" data sets").toString();
        } else
        {
            obj = zzapY;
        }
        zza1 = zza1.zzg("dataSets", obj);
        if (zzatd.size() > 5)
        {
            obj = (new StringBuilder()).append(zzatd.size()).append(" buckets").toString();
        } else
        {
            obj = zzatd;
        }
        return zza1.zzg("buckets", obj).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.result.zzc.zza(this, parcel, i);
    }

    public void zzb(DataReadResult datareadresult)
    {
        for (Iterator iterator = datareadresult.getDataSets().iterator(); iterator.hasNext(); zza((DataSet)iterator.next(), zzapY)) { }
        for (datareadresult = datareadresult.getBuckets().iterator(); datareadresult.hasNext(); zza((Bucket)datareadresult.next(), zzatd)) { }
    }

    List zzsq()
    {
        return zzaqi;
    }

    public int zztn()
    {
        return zzate;
    }

    List zzto()
    {
        ArrayList arraylist = new ArrayList(zzatd.size());
        for (Iterator iterator = zzatd.iterator(); iterator.hasNext(); arraylist.add(new RawBucket((Bucket)iterator.next(), zzaqi, zzatf))) { }
        return arraylist;
    }

    List zztp()
    {
        ArrayList arraylist = new ArrayList(zzapY.size());
        for (Iterator iterator = zzapY.iterator(); iterator.hasNext(); arraylist.add(new RawDataSet((DataSet)iterator.next(), zzaqi, zzatf))) { }
        return arraylist;
    }

    List zztq()
    {
        return zzatf;
    }

}
