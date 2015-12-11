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
import com.google.android.gms.internal.zzoj;
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
    private DataType zzapL;
    private DataSource zzapM;
    private final long zzarc;
    private final int zzard;
    private zzj zzasF;
    int zzasG;
    int zzasH;
    private final long zzasI;
    private final long zzasJ;
    private final List zzasK;
    private final long zzasL;
    private final List zzasM;
    private final zzoj zzasb;

    SensorRegistrationRequest(int i, DataSource datasource, DataType datatype, IBinder ibinder, int j, int k, long l, long l1, PendingIntent pendingintent, long l2, int i1, 
            List list, long l3, IBinder ibinder1)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzapL = datatype;
        long l4;
        if (ibinder == null)
        {
            datasource = null;
        } else
        {
            datasource = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        }
        zzasF = datasource;
        l4 = l;
        if (l == 0L)
        {
            l4 = j;
        }
        zzarc = l4;
        zzasJ = l2;
        l = l1;
        if (l1 == 0L)
        {
            l = k;
        }
        zzasI = l;
        zzasK = list;
        mPendingIntent = pendingintent;
        zzard = i1;
        zzasM = Collections.emptyList();
        zzasL = l3;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder1);
    }

    public SensorRegistrationRequest(DataSource datasource, DataType datatype, zzj zzj1, PendingIntent pendingintent, long l, long l1, long l2, int i, List list, List list1, long l3, zzoj zzoj1)
    {
        mVersionCode = 6;
        zzapM = datasource;
        zzapL = datatype;
        zzasF = zzj1;
        mPendingIntent = pendingintent;
        zzarc = l;
        zzasJ = l1;
        zzasI = l2;
        zzard = i;
        zzasK = list;
        zzasM = list1;
        zzasL = l3;
        zzasb = zzoj1;
    }

    public SensorRegistrationRequest(SensorRequest sensorrequest, zzj zzj1, PendingIntent pendingintent, zzoj zzoj1)
    {
        this(sensorrequest.getDataSource(), sensorrequest.getDataType(), zzj1, pendingintent, sensorrequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorrequest.getFastestRate(TimeUnit.MICROSECONDS), sensorrequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorrequest.getAccuracyMode(), null, Collections.emptyList(), sensorrequest.zztg(), zzoj1);
    }

    private boolean zzb(SensorRegistrationRequest sensorregistrationrequest)
    {
        return zzw.equal(zzapM, sensorregistrationrequest.zzapM) && zzw.equal(zzapL, sensorregistrationrequest.zzapL) && zzarc == sensorregistrationrequest.zzarc && zzasJ == sensorregistrationrequest.zzasJ && zzasI == sensorregistrationrequest.zzasI && zzard == sensorregistrationrequest.zzard && zzw.equal(zzasK, sensorregistrationrequest.zzasK);
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
            zzapM, zzapL, zzasF, Long.valueOf(zzarc), Long.valueOf(zzasJ), Long.valueOf(zzasI), Integer.valueOf(zzard), zzasK
        });
    }

    public String toString()
    {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] {
            zzapL, zzapM, Long.valueOf(zzarc), Long.valueOf(zzasJ), Long.valueOf(zzasI)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzs.zza(this, parcel, i);
    }

    public long zzsB()
    {
        return zzarc;
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

    public PendingIntent zzta()
    {
        return mPendingIntent;
    }

    public long zztb()
    {
        return zzasJ;
    }

    public long zztc()
    {
        return zzasI;
    }

    public List zztd()
    {
        return zzasK;
    }

    public long zzte()
    {
        return zzasL;
    }

    IBinder zztf()
    {
        if (zzasF == null)
        {
            return null;
        } else
        {
            return zzasF.asBinder();
        }
    }

}
