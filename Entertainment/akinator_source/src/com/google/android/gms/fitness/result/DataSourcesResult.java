// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zze

public class DataSourcesResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final Status zzSC;
    private final List zzasd;

    DataSourcesResult(int i, List list, Status status)
    {
        mVersionCode = i;
        zzasd = Collections.unmodifiableList(list);
        zzSC = status;
    }

    public DataSourcesResult(List list, Status status)
    {
        mVersionCode = 3;
        zzasd = Collections.unmodifiableList(list);
        zzSC = status;
    }

    public static DataSourcesResult zzQ(Status status)
    {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult datasourcesresult)
    {
        return zzSC.equals(datasourcesresult.zzSC) && zzw.equal(zzasd, datasourcesresult.zzasd);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataSourcesResult) && zzb((DataSourcesResult)obj);
    }

    public List getDataSources()
    {
        return zzasd;
    }

    public List getDataSources(DataType datatype)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzasd.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DataSource datasource = (DataSource)iterator.next();
            if (datasource.getDataType().equals(datatype))
            {
                arraylist.add(datasource);
            }
        } while (true);
        return Collections.unmodifiableList(arraylist);
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
            zzSC, zzasd
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("dataSets", zzasd).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

}
