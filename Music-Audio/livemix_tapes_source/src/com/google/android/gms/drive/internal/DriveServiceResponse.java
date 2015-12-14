// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzac

public class DriveServiceResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzac();
    final int mVersionCode;
    final IBinder zzaje;

    DriveServiceResponse(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzaje = ibinder;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzac.zza(this, parcel, i);
    }

    public zzq zzqJ()
    {
        return com.google.android.gms.common.internal.zzq.zza.zzaI(zzaje);
    }

}
