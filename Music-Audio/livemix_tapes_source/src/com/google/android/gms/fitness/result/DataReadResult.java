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
    private final Status zzQA;
    private final List zzanI;
    private final List zzany;
    private final List zzaqG;
    private int zzaqH;
    private final List zzaqI;

    DataReadResult(int i, List list, Status status, List list1, int j, List list2, List list3)
    {
        mVersionCode = i;
        zzQA = status;
        zzaqH = j;
        zzanI = list2;
        zzaqI = list3;
        zzany = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); zzany.add(new DataSet(status, list2)))
        {
            status = (RawDataSet)list.next();
        }

        zzaqG = new ArrayList(list1.size());
        for (list = list1.iterator(); list.hasNext(); zzaqG.add(new Bucket(status, list2)))
        {
            status = (RawBucket)list.next();
        }

    }

    public DataReadResult(List list, List list1, Status status)
    {
        mVersionCode = 5;
        zzany = list;
        zzQA = status;
        zzaqG = list1;
        zzaqH = 1;
        zzanI = new ArrayList();
        zzaqI = new ArrayList();
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

            zzaqG.add(bucket);
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
        return zzQA.equals(datareadresult.zzQA) && zzw.equal(zzany, datareadresult.zzany) && zzw.equal(zzaqG, datareadresult.zzaqG);
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
        return zzaqG;
    }

    public DataSet getDataSet(DataSource datasource)
    {
        for (Iterator iterator = zzany.iterator(); iterator.hasNext();)
        {
            DataSet dataset = (DataSet)iterator.next();
            if (datasource.equals(dataset.getDataSource()))
            {
                return dataset;
            }
        }

        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[] {
            datasource.getStreamIdentifier()
        }));
    }

    public DataSet getDataSet(DataType datatype)
    {
        for (Iterator iterator = zzany.iterator(); iterator.hasNext();)
        {
            DataSet dataset = (DataSet)iterator.next();
            if (datatype.equals(dataset.getDataType()))
            {
                return dataset;
            }
        }

        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[] {
            datatype.getName()
        }));
    }

    public List getDataSets()
    {
        return zzany;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, zzany, zzaqG
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzu(this).zzg("status", zzQA);
        Object obj;
        if (zzany.size() > 5)
        {
            obj = (new StringBuilder()).append(zzany.size()).append(" data sets").toString();
        } else
        {
            obj = zzany;
        }
        zza1 = zza1.zzg("dataSets", obj);
        if (zzaqG.size() > 5)
        {
            obj = (new StringBuilder()).append(zzaqG.size()).append(" buckets").toString();
        } else
        {
            obj = zzaqG;
        }
        return zza1.zzg("buckets", obj).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.result.zzc.zza(this, parcel, i);
    }

    public void zzb(DataReadResult datareadresult)
    {
        for (Iterator iterator = datareadresult.getDataSets().iterator(); iterator.hasNext(); zza((DataSet)iterator.next(), zzany)) { }
        for (datareadresult = datareadresult.getBuckets().iterator(); datareadresult.hasNext(); zza((Bucket)datareadresult.next(), zzaqG)) { }
    }

    List zzrE()
    {
        return zzanI;
    }

    public int zzsB()
    {
        return zzaqH;
    }

    List zzsC()
    {
        ArrayList arraylist = new ArrayList(zzaqG.size());
        for (Iterator iterator = zzaqG.iterator(); iterator.hasNext(); arraylist.add(new RawBucket((Bucket)iterator.next(), zzanI, zzaqI))) { }
        return arraylist;
    }

    List zzsD()
    {
        ArrayList arraylist = new ArrayList(zzany.size());
        for (Iterator iterator = zzany.iterator(); iterator.hasNext(); arraylist.add(new RawDataSet((DataSet)iterator.next(), zzanI, zzaqI))) { }
        return arraylist;
    }

    List zzsE()
    {
        return zzaqI;
    }

}
