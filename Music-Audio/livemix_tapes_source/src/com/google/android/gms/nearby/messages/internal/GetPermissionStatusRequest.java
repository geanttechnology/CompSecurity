// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zza, zzc

public class GetPermissionStatusRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;

    GetPermissionStatusRequest(int i, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzaJR = zzc.zza.zzdi(ibinder);
        zzaCr = s;
    }

    GetPermissionStatusRequest(IBinder ibinder, String s)
    {
        this(1, ibinder, s);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaJR.asBinder();
    }

}
