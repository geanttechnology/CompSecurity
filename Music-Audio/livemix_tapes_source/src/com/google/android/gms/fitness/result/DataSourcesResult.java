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
    private final Status zzQA;
    private final List zzapG;

    DataSourcesResult(int i, List list, Status status)
    {
        mVersionCode = i;
        zzapG = Collections.unmodifiableList(list);
        zzQA = status;
    }

    public DataSourcesResult(List list, Status status)
    {
        mVersionCode = 3;
        zzapG = Collections.unmodifiableList(list);
        zzQA = status;
    }

    public static DataSourcesResult zzR(Status status)
    {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult datasourcesresult)
    {
        return zzQA.equals(datasourcesresult.zzQA) && zzw.equal(zzapG, datasourcesresult.zzapG);
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
        return zzapG;
    }

    public List getDataSources(DataType datatype)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = zzapG.iterator();
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
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, zzapG
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("dataSets", zzapG).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

}
