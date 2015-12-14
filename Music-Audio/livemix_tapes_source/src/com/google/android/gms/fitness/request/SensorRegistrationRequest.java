// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzs, SensorRequest

public class SensorRegistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzs();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;
    private final zznh zzapE;
    private zzj zzaqi;
    int zzaqj;
    int zzaqk;
    private final long zzaql;
    private final long zzaqm;
    private final List zzaqn;
    private final long zzaqo;
    private final List zzaqp;

    SensorRegistrationRequest(int i, DataSource datasource, DataType datatype, IBinder ibinder, int j, int k, long l, long l1, PendingIntent pendingintent, long l2, int i1, 
            List list, long l3, IBinder ibinder1, String s)
    {
        mVersionCode = i;
        zzanm = datasource;
        zzanl = datatype;
        long l4;
        if (ibinder == null)
        {
            datasource = null;
        } else
        {
            datasource = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        }
        zzaqi = datasource;
        l4 = l;
        if (l == 0L)
        {
            l4 = j;
        }
        zzaoE = l4;
        zzaqm = l2;
        l = l1;
        if (l1 == 0L)
        {
            l = k;
        }
        zzaql = l;
        zzaqn = list;
        mPendingIntent = pendingintent;
        zzaoF = i1;
        zzaqp = Collections.emptyList();
        zzaqo = l3;
        if (ibinder1 == null)
        {
            datasource = null;
        } else
        {
            datasource = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder1);
        }
        zzapE = datasource;
        zzOZ = s;
    }

    public SensorRegistrationRequest(DataSource datasource, DataType datatype, zzj zzj1, PendingIntent pendingintent, long l, long l1, long l2, int i, List list, List list1, long l3, zznh zznh1, String s)
    {
        mVersionCode = 5;
        zzanm = datasource;
        zzanl = datatype;
        zzaqi = zzj1;
        mPendingIntent = pendingintent;
        zzaoE = l;
        zzaqm = l1;
        zzaql = l2;
        zzaoF = i;
        zzaqn = list;
        zzaqp = list1;
        zzaqo = l3;
        zzapE = zznh1;
        zzOZ = s;
    }

    public SensorRegistrationRequest(SensorRequest sensorrequest, zzj zzj1, PendingIntent pendingintent, zznh zznh1, String s)
    {
        this(sensorrequest.getDataSource(), sensorrequest.getDataType(), zzj1, pendingintent, sensorrequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorrequest.getFastestRate(TimeUnit.MICROSECONDS), sensorrequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorrequest.getAccuracyMode(), null, Collections.emptyList(), sensorrequest.zzsu(), zznh1, s);
    }

    private boolean zzb(SensorRegistrationRequest sensorregistrationrequest)
    {
        return zzw.equal(zzanm, sensorregistrationrequest.zzanm) && zzw.equal(zzanl, sensorregistrationrequest.zzanl) && zzaoE == sensorregistrationrequest.zzaoE && zzaqm == sensorregistrationrequest.zzaqm && zzaql == sensorregistrationrequest.zzaql && zzaoF == sensorregistrationrequest.zzaoF && zzw.equal(zzaqn, sensorregistrationrequest.zzaqn);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest)obj);
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

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, zzanl, zzaqi, Long.valueOf(zzaoE), Long.valueOf(zzaqm), Long.valueOf(zzaql), Integer.valueOf(zzaoF), zzaqn
        });
    }

    public String toString()
    {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] {
            zzanl, zzanm, Long.valueOf(zzaoE), Long.valueOf(zzaqm), Long.valueOf(zzaql)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzs.zza(this, parcel, i);
    }

    public long zzrP()
    {
        return zzaoE;
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

    public PendingIntent zzso()
    {
        return mPendingIntent;
    }

    public long zzsp()
    {
        return zzaqm;
    }

    public long zzsq()
    {
        return zzaql;
    }

    public List zzsr()
    {
        return zzaqn;
    }

    public long zzss()
    {
        return zzaqo;
    }

    IBinder zzst()
    {
        if (zzaqi == null)
        {
            return null;
        } else
        {
            return zzaqi.asBinder();
        }
    }

}
