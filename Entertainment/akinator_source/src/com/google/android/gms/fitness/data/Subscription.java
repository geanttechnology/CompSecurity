// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzr, DataType, DataSource

public class Subscription
    implements SafeParcelable
{
    public static class zza
    {

        private DataType zzapL;
        private DataSource zzapM;
        private long zzarc;
        private int zzard;

        static DataType zza(zza zza1)
        {
            return zza1.zzapL;
        }

        static DataSource zzb(zza zza1)
        {
            return zza1.zzapM;
        }

        static long zzc(zza zza1)
        {
            return zza1.zzarc;
        }

        static int zzd(zza zza1)
        {
            return zza1.zzard;
        }

        public zza zzb(DataSource datasource)
        {
            zzapM = datasource;
            return this;
        }

        public zza zzb(DataType datatype)
        {
            zzapL = datatype;
            return this;
        }

        public Subscription zzsD()
        {
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (zzapM != null || zzapL != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Must call setDataSource() or setDataType()");
                if (zzapL != null && zzapM != null)
                {
                    flag = flag1;
                    if (!zzapL.equals(zzapM.getDataType()))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            zzx.zza(flag, "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }

        public zza()
        {
            zzarc = -1L;
            zzard = 2;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    private final DataType zzapL;
    private final DataSource zzapM;
    private final long zzarc;
    private final int zzard;

    Subscription(int i, DataSource datasource, DataType datatype, long l, int j)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzapL = datatype;
        zzarc = l;
        zzard = j;
    }

    private Subscription(zza zza1)
    {
        mVersionCode = 1;
        zzapL = zza.zza(zza1);
        zzapM = zza.zzb(zza1);
        zzarc = zza.zzc(zza1);
        zzard = zza.zzd(zza1);
    }


    private boolean zza(Subscription subscription)
    {
        return zzw.equal(zzapM, subscription.zzapM) && zzw.equal(zzapL, subscription.zzapL) && zzarc == subscription.zzarc && zzard == subscription.zzard;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof Subscription) && zza((Subscription)obj);
    }

    public int getAccuracyMode()
    {
        return zzard;
    }

    public DataSource getDataSource()
    {
        return zzapM;
    }

    public DataType getDataType()
    {
        return zzapL;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapM, zzapM, Long.valueOf(zzarc), Integer.valueOf(zzard)
        });
    }

    public String toDebugString()
    {
        String s;
        if (zzapM == null)
        {
            s = zzapL.getName();
        } else
        {
            s = zzapM.toDebugString();
        }
        return String.format("Subscription{%s}", new Object[] {
            s
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("dataSource", zzapM).zzg("dataType", zzapL).zzg("samplingIntervalMicros", Long.valueOf(zzarc)).zzg("accuracyMode", Integer.valueOf(zzard)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzr.zza(this, parcel, i);
    }

    public long zzsB()
    {
        return zzarc;
    }

    public DataType zzsC()
    {
        if (zzapL == null)
        {
            return zzapM.getDataType();
        } else
        {
            return zzapL;
        }
    }

}
