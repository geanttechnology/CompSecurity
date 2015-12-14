// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zze

public class DataInsertRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final String zzOZ;
    private final DataSet zzaoD;
    private final zznh zzapE;
    private final boolean zzapK;

    DataInsertRequest(int i, DataSet dataset, IBinder ibinder, String s, boolean flag)
    {
        mVersionCode = i;
        zzaoD = dataset;
        if (ibinder == null)
        {
            dataset = null;
        } else
        {
            dataset = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = dataset;
        zzOZ = s;
        zzapK = flag;
    }

    public DataInsertRequest(DataSet dataset, zznh zznh1, String s, boolean flag)
    {
        mVersionCode = 3;
        zzaoD = dataset;
        zzapE = zznh1;
        zzOZ = s;
        zzapK = flag;
    }

    private boolean zzc(DataInsertRequest datainsertrequest)
    {
        return zzw.equal(zzaoD, datainsertrequest.zzaoD);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataInsertRequest) && zzc((DataInsertRequest)obj);
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
            zzaoD
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("dataSet", zzaoD).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    public DataSet zzrO()
    {
        return zzaoD;
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

    public boolean zzsg()
    {
        return zzapK;
    }

}
