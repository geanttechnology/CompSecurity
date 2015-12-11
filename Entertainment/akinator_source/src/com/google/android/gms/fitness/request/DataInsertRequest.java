// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zze

public class DataInsertRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final DataSet zzarb;
    private final zzoj zzasb;
    private final boolean zzash;

    DataInsertRequest(int i, DataSet dataset, IBinder ibinder, boolean flag)
    {
        mVersionCode = i;
        zzarb = dataset;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
        zzash = flag;
    }

    public DataInsertRequest(DataSet dataset, zzoj zzoj1, boolean flag)
    {
        mVersionCode = 4;
        zzarb = dataset;
        zzasb = zzoj1;
        zzash = flag;
    }

    private boolean zzc(DataInsertRequest datainsertrequest)
    {
        return zzw.equal(zzarb, datainsertrequest.zzarb);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataInsertRequest) && zzc((DataInsertRequest)obj);
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzarb
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("dataSet", zzarb).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public DataSet zzsA()
    {
        return zzarb;
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

    public boolean zzsS()
    {
        return zzash;
    }

}
