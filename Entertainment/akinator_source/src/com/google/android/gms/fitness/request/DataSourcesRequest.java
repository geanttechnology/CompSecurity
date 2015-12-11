// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zznv;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzh

public class DataSourcesRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private boolean zzasu;
        private DataType zzasw[];
        private int zzasx[] = {
            0, 1
        };

        static DataType[] zza(Builder builder)
        {
            return builder.zzasw;
        }

        static int[] zzb(Builder builder)
        {
            return builder.zzasx;
        }

        static boolean zzc(Builder builder)
        {
            return builder.zzasu;
        }

        public DataSourcesRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (zzasw.length > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must add at least one data type");
            if (zzasx.length > 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public transient Builder setDataSourceTypes(int ai[])
        {
            zzasx = ai;
            return this;
        }

        public transient Builder setDataTypes(DataType adatatype[])
        {
            zzasw = adatatype;
            return this;
        }

        public Builder()
        {
            zzasw = new DataType[0];
            zzasu = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final List zzapW;
    private final List zzast;
    private final boolean zzasu;
    private final zznv zzasv;

    DataSourcesRequest(int i, List list, List list1, boolean flag, IBinder ibinder)
    {
        mVersionCode = i;
        zzapW = list;
        zzast = list1;
        zzasu = flag;
        zzasv = com.google.android.gms.internal.zznv.zza.zzbv(ibinder);
    }

    private DataSourcesRequest(Builder builder)
    {
        this(((List) (zzmj.zzb(Builder.zza(builder)))), Arrays.asList(zzmj.zza(Builder.zzb(builder))), Builder.zzc(builder), null);
    }


    public DataSourcesRequest(DataSourcesRequest datasourcesrequest, zznv zznv1)
    {
        this(datasourcesrequest.zzapW, datasourcesrequest.zzast, datasourcesrequest.zzasu, zznv1);
    }

    public DataSourcesRequest(List list, List list1, boolean flag, zznv zznv1)
    {
        mVersionCode = 4;
        zzapW = list;
        zzast = list1;
        zzasu = flag;
        zzasv = zznv1;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return zzapW;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza = zzw.zzv(this).zzg("dataTypes", zzapW).zzg("sourceTypes", zzast);
        if (zzasu)
        {
            zza.zzg("includeDbOnlySources", "true");
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasv == null)
        {
            return null;
        } else
        {
            return zzasv.asBinder();
        }
    }

    public List zzsX()
    {
        return zzast;
    }

    public boolean zzsY()
    {
        return zzasu;
    }

}
