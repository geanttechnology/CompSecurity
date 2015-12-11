// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbi

public class OnStartStreamSession
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbi();
    final int mVersionCode;
    final ParcelFileDescriptor zzamm;
    final IBinder zzamn;
    final String zzrW;

    OnStartStreamSession(int i, ParcelFileDescriptor parcelfiledescriptor, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzamm = parcelfiledescriptor;
        zzamn = ibinder;
        zzrW = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbi.zza(this, parcel, i | 1);
    }

}
