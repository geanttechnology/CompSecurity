// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzae

public class UnsubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzae();
    private final int mVersionCode;
    private final DataType zzapL;
    private final DataSource zzapM;
    private final zzoj zzasb;

    UnsubscribeRequest(int i, DataType datatype, DataSource datasource, IBinder ibinder)
    {
        mVersionCode = i;
        zzapL = datatype;
        zzapM = datasource;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public UnsubscribeRequest(DataType datatype, DataSource datasource, zzoj zzoj1)
    {
        mVersionCode = 3;
        zzapL = datatype;
        zzapM = datasource;
        zzasb = zzoj1;
    }

    private boolean zzb(UnsubscribeRequest unsubscriberequest)
    {
        return zzw.equal(zzapM, unsubscriberequest.zzapM) && zzw.equal(zzapL, unsubscriberequest.zzapL);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest)obj);
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
            zzapM, zzapL
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzae.zza(this, parcel, i);
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

}
