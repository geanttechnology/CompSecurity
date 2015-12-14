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
    private boolean zzanA;
    private final List zzanH;
    private final List zzanI;
    private final DataType zzanl;
    private final DataSource zzanm;

    DataSet(int i, DataSource datasource, DataType datatype, List list, List list1, boolean flag)
    {
        zzanA = false;
        mVersionCode = i;
        zzanm = datasource;
        zzanl = datasource.getDataType();
        zzanA = flag;
        zzanH = new ArrayList(list.size());
        if (i < 2)
        {
            list1 = Collections.singletonList(datasource);
        }
        zzanI = list1;
        for (datasource = list.iterator(); datasource.hasNext(); zzanH.add(new DataPoint(zzanI, datatype)))
        {
            datatype = (RawDataPoint)datasource.next();
        }

    }

    public DataSet(DataSource datasource)
    {
        zzanA = false;
        mVersionCode = 3;
        zzanm = (DataSource)zzx.zzv(datasource);
        zzanl = datasource.getDataType();
        zzanH = new ArrayList();
        zzanI = new ArrayList();
        zzanI.add(zzanm);
    }

    public DataSet(RawDataSet rawdataset, List list)
    {
        zzanA = false;
        mVersionCode = 3;
        zzanm = (DataSource)zzb(list, rawdataset.zzaow);
        zzanl = zzanm.getDataType();
        zzanI = list;
        zzanA = rawdataset.zzanA;
        rawdataset = rawdataset.zzaoz;
        zzanH = new ArrayList(rawdataset.size());
        for (rawdataset = rawdataset.iterator(); rawdataset.hasNext(); zzanH.add(new DataPoint(zzanI, list)))
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
        return zzw.equal(getDataType(), dataset.getDataType()) && zzw.equal(zzanm, dataset.zzanm) && zzw.equal(zzanH, dataset.zzanH) && zzanA == dataset.zzanA;
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
        zzx.zzb(datasource.getStreamIdentifier().equals(zzanm.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] {
            datasource, zzanm
        });
        datapoint.zzrB();
        zzb(datapoint);
    }

    public void addAll(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); add((DataPoint)iterable.next())) { }
    }

    public DataPoint createDataPoint()
    {
        return DataPoint.create(zzanm);
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
        return Collections.unmodifiableList(zzanH);
    }

    public DataSource getDataSource()
    {
        return zzanm;
    }

    public DataType getDataType()
    {
        return zzanm.getDataType();
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm
        });
    }

    public boolean isEmpty()
    {
        return zzanH.isEmpty();
    }

    public String toString()
    {
        Object obj = zzrD();
        String s = zzanm.toDebugString();
        if (zzanH.size() >= 10)
        {
            obj = String.format("%d data points, first 5: %s", new Object[] {
                Integer.valueOf(zzanH.size()), ((List) (obj)).subList(0, 5)
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
        zzanH.add(datapoint);
        datapoint = datapoint.getOriginalDataSource();
        if (datapoint != null && !zzanI.contains(datapoint))
        {
            zzanI.add(datapoint);
        }
    }

    public void zzb(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); zzb((DataPoint)iterable.next())) { }
    }

    List zzk(List list)
    {
        ArrayList arraylist = new ArrayList(zzanH.size());
        for (Iterator iterator = zzanH.iterator(); iterator.hasNext(); arraylist.add(new RawDataPoint((DataPoint)iterator.next(), list))) { }
        return arraylist;
    }

    List zzrD()
    {
        return zzk(zzanI);
    }

    List zzrE()
    {
        return zzanI;
    }

    public boolean zzrv()
    {
        return zzanA;
    }

}
