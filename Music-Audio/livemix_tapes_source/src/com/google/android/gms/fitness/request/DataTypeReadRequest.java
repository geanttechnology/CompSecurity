// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzj

public class DataTypeReadRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final zzmu zzaqb;

    DataTypeReadRequest(int i, String s, IBinder ibinder, String s1)
    {
        mVersionCode = i;
        mName = s;
        if (ibinder == null)
        {
            s = null;
        } else
        {
            s = com.google.android.gms.internal.zzmu.zza.zzbw(ibinder);
        }
        zzaqb = s;
        zzOZ = s1;
    }

    public DataTypeReadRequest(String s, zzmu zzmu1, String s1)
    {
        mVersionCode = 2;
        mName = s;
        zzaqb = zzmu1;
        zzOZ = s1;
    }

    private boolean zzb(DataTypeReadRequest datatypereadrequest)
    {
        return zzw.equal(mName, datatypereadrequest.mName);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest)obj);
    }

    public String getName()
    {
        return mName;
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
            mName
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("name", mName).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzaqb.asBinder();
    }

}
