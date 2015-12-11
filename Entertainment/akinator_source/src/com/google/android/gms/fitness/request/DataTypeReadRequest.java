// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznw;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzj

public class DataTypeReadRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    private final String mName;
    private final int mVersionCode;
    private final zznw zzasy;

    DataTypeReadRequest(int i, String s, IBinder ibinder)
    {
        mVersionCode = i;
        mName = s;
        zzasy = com.google.android.gms.internal.zznw.zza.zzbw(ibinder);
    }

    public DataTypeReadRequest(String s, zznw zznw1)
    {
        mVersionCode = 3;
        mName = s;
        zzasy = zznw1;
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
        return zzw.zzv(this).zzg("name", mName).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasy.asBinder();
    }

}
