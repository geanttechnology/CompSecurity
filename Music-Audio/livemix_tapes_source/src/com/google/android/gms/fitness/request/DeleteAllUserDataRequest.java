// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzk

public class DeleteAllUserDataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;

    DeleteAllUserDataRequest(int i, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzapE = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
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
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzapE.asBinder();
    }

}
