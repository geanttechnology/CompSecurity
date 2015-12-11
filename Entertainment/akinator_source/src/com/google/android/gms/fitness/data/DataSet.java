// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zze, DataSource, RawDataPoint, DataPoint, 
//            RawDataSet, DataType

public final class DataSet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzapL;
    private final DataSource zzapM;
    private boolean zzaqa;
    private final List zzaqh;
    private final List zzaqi;

    DataSet(int i, DataSource datasource, DataType datatype, List list, List list1, boolean flag)
    {
        zzaqa = false;
        mVersionCode = i;
        zzapM = datasource;
        zzapL = datasource.getDataType();
        zzaqa = flag;
        zzaqh = new ArrayList(list.size());
        if (i < 2)
        {
            list1 = Collections.singletonList(datasource);
        }
        zzaqi = list1;
        for (datasource = list.iterator(); datasource.hasNext(); zzaqh.add(new DataPoint(zzaqi, datatype)))
        {
            datatype = (RawDataPoint)datasource.next();
        }

    }

    public DataSet(DataSource datasource)
    {
        zzaqa = false;
        mVersionCode = 3;
        zzapM = (DataSource)zzx.zzw(datasource);
        zzapL = datasource.getDataType();
        zzaqh = new ArrayList();
        zzaqi = new ArrayList();
        zzaqi.add(zzapM);
    }

    public DataSet(RawDataSet rawdataset, List list)
    {
        zzaqa = false;
        mVersionCode = 3;
        zzapM = (DataSource)zzb(list, rawdataset.zzaqU);
        zzapL = zzapM.getDataType();
        zzaqi = list;
        zzaqa = rawdataset.zzaqa;
        rawdataset = rawdataset.zzaqX;
        zzaqh = new ArrayList(rawdataset.size());
        for (rawdataset = rawdataset.iterator(); rawdataset.hasNext(); zzaqh.add(new DataPoint(zzaqi, list)))
        {
            list = (RawDataPoint)rawdataset.next();
        }

    }

    public static DataSet create(DataSource datasource)
    {
        zzx.zzb(datasource, "DataSource should be specified");
        return new DataSet(datasource);
    }

    private boolean zza(DataSet dataset)
    {
        return zzw.equal(getDataType(), dataset.getDataType()) && zzw.equal(zzapM, dataset.zzapM) && zzw.equal(zzaqh, dataset.zzaqh) && zzaqa == dataset.zzaqa;
    }

    private static Object zzb(List list, int i)
    {
        if (i >= 0 && i < list.size())
        {
            return list.get(i);
        } else
        {
            return null;
        }
    }

    public void add(DataPoint datapoint)
    {
        DataSource datasource = datapoint.getDataSource();
        zzx.zzb(datasource.getStreamIdentifier().equals(zzapM.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] {
            datasource, zzapM
        });
        datapoint.zzsn();
        zzb(datapoint);
    }

    public void addAll(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); add((DataPoint)iterable.next())) { }
    }

    public DataPoint createDataPoint()
    {
        return DataPoint.create(zzapM);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataSet) && zza((DataSet)obj);
    }

    public List getDataPoints()
    {
        return Collections.unmodifiableList(zzaqh);
    }

    public DataSource getDataSource()
    {
        return zzapM;
    }

    public DataType getDataType()
    {
        return zzapM.getDataType();
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapM
        });
    }

    public boolean isEmpty()
    {
        return zzaqh.isEmpty();
    }

    public String toString()
    {
        Object obj = zzsp();
        String s = zzapM.toDebugString();
        if (zzaqh.size() >= 10)
        {
            obj = String.format("%d data points, first 5: %s", new Object[] {
                Integer.valueOf(zzaqh.size()), ((List) (obj)).subList(0, 5)
            });
        }
        return String.format("DataSet{%s %s}", new Object[] {
            s, obj
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public void zzb(DataPoint datapoint)
    {
        zzaqh.add(datapoint);
        datapoint = datapoint.getOriginalDataSource();
        if (datapoint != null && !zzaqi.contains(datapoint))
        {
            zzaqi.add(datapoint);
        }
    }

    public void zzb(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); zzb((DataPoint)iterable.next())) { }
    }

    List zzr(List list)
    {
        ArrayList arraylist = new ArrayList(zzaqh.size());
        for (Iterator iterator = zzaqh.iterator(); iterator.hasNext(); arraylist.add(new RawDataPoint((DataPoint)iterator.next(), list))) { }
        return arraylist;
    }

    public boolean zzsh()
    {
        return zzaqa;
    }

    List zzsp()
    {
        return zzr(zzaqi);
    }

    List zzsq()
    {
        return zzaqi;
    }

}
