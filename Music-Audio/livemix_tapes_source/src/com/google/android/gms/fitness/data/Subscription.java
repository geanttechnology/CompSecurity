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

        private DataType zzanl;
        private DataSource zzanm;
        private long zzaoE;
        private int zzaoF;

        static DataType zza(zza zza1)
        {
            return zza1.zzanl;
        }

        static DataSource zzb(zza zza1)
        {
            return zza1.zzanm;
        }

        static long zzc(zza zza1)
        {
            return zza1.zzaoE;
        }

        static int zzd(zza zza1)
        {
            return zza1.zzaoF;
        }

        public zza zzb(DataSource datasource)
        {
            zzanm = datasource;
            return this;
        }

        public zza zzb(DataType datatype)
        {
            zzanl = datatype;
            return this;
        }

        public Subscription zzrR()
        {
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (zzanm != null || zzanl != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                zzx.zza(flag, "Must call setDataSource() or setDataType()");
                if (zzanl != null && zzanm != null)
                {
                    flag = flag1;
                    if (!zzanl.equals(zzanm.getDataType()))
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
            zzaoE = -1L;
            zzaoF = 2;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;

    Subscription(int i, DataSource datasource, DataType datatype, long l, int j)
    {
        mVersionCode = i;
        zzanm = datasource;
        zzanl = datatype;
        zzaoE = l;
        zzaoF = j;
    }

    private Subscription(zza zza1)
    {
        mVersionCode = 1;
        zzanl = zza.zza(zza1);
        zzanm = zza.zzb(zza1);
        zzaoE = zza.zzc(zza1);
        zzaoF = zza.zzd(zza1);
    }


    private boolean zza(Subscription subscription)
    {
        return zzw.equal(zzanm, subscription.zzanm) && zzw.equal(zzanl, subscription.zzanl) && zzaoE == subscription.zzaoE && zzaoF == subscription.zzaoF;
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
        return zzaoF;
    }

    public DataSource getDataSource()
    {
        return zzanm;
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, zzanm, Long.valueOf(zzaoE), Integer.valueOf(zzaoF)
        });
    }

    public String toDebugString()
    {
        String s;
        if (zzanm == null)
        {
            s = zzanl.getName();
        } else
        {
            s = zzanm.toDebugString();
        }
        return String.format("Subscription{%s}", new Object[] {
            s
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("dataSource", zzanm).zzg("dataType", zzanl).zzg("samplingIntervalMicros", Long.valueOf(zzaoE)).zzg("accuracyMode", Integer.valueOf(zzaoF)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzr.zza(this, parcel, i);
    }

    public long zzrP()
    {
        return zzaoE;
    }

    public DataType zzrQ()
    {
        if (zzanl == null)
        {
            return zzanm.getDataType();
        } else
        {
            return zzanl;
        }
    }

}
