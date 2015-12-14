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
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzmt;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzh

public class DataSourcesRequest
    implements SafeParcelable
{
    public static class Builder
    {

        private boolean zzapX;
        private DataType zzapZ[];
        private int zzaqa[] = {
            0, 1
        };

        static DataType[] zza(Builder builder)
        {
            return builder.zzapZ;
        }

        static int[] zzb(Builder builder)
        {
            return builder.zzaqa;
        }

        static boolean zzc(Builder builder)
        {
            return builder.zzapX;
        }

        public DataSourcesRequest build()
        {
            boolean flag1 = true;
            boolean flag;
            if (zzapZ.length > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must add at least one data type");
            if (zzaqa.length > 0)
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
            zzaqa = ai;
            return this;
        }

        public transient Builder setDataTypes(DataType adatatype[])
        {
            zzapZ = adatatype;
            return this;
        }

        public Builder()
        {
            zzapZ = new DataType[0];
            zzapX = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final String zzOZ;
    private final List zzanw;
    private final List zzapW;
    private final boolean zzapX;
    private final zzmt zzapY;

    DataSourcesRequest(int i, List list, List list1, boolean flag, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzanw = list;
        zzapW = list1;
        zzapX = flag;
        if (ibinder == null)
        {
            list = null;
        } else
        {
            list = com.google.android.gms.internal.zzmt.zza.zzbv(ibinder);
        }
        zzapY = list;
        zzOZ = s;
    }

    private DataSourcesRequest(Builder builder)
    {
        this(((List) (zzli.zzb(Builder.zza(builder)))), Arrays.asList(zzli.zza(Builder.zzb(builder))), Builder.zzc(builder), null, null);
    }


    public DataSourcesRequest(DataSourcesRequest datasourcesrequest, zzmt zzmt1, String s)
    {
        this(datasourcesrequest.zzanw, datasourcesrequest.zzapW, datasourcesrequest.zzapX, zzmt1, s);
    }

    public DataSourcesRequest(List list, List list1, boolean flag, zzmt zzmt1, String s)
    {
        mVersionCode = 3;
        zzanw = list;
        zzapW = list1;
        zzapX = flag;
        zzapY = zzmt1;
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return Collections.unmodifiableList(zzanw);
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza = zzw.zzu(this).zzg("dataTypes", zzanw).zzg("sourceTypes", zzapW);
        if (zzapX)
        {
            zza.zzg("includeDbOnlySources", "true");
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzapY == null)
        {
            return null;
        } else
        {
            return zzapY.asBinder();
        }
    }

    public List zzsl()
    {
        return zzapW;
    }

    public boolean zzsm()
    {
        return zzapX;
    }

}
