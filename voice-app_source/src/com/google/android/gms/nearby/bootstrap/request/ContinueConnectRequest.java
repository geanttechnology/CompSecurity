// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            zzb

public class ContinueConnectRequest
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzol zzaFk;
    private final String zzaFl;

    ContinueConnectRequest(int i, String s, IBinder ibinder)
    {
        versionCode = i;
        zzaFl = (String)zzu.zzu(s);
        zzaFk = com.google.android.gms.internal.zzol.zza.zzcX(ibinder);
    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public String getToken()
    {
        return zzaFl;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb zzb1 = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public IBinder zzqU()
    {
        if (zzaFk == null)
        {
            return null;
        } else
        {
            return zzaFk.asBinder();
        }
    }

}
