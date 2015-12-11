// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.server.converter:
//            zzc

public final class zzagT
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    final int versionCode;
    final String zzagS;
    final int zzagT;

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }


    (int i, String s, int j)
    {
        versionCode = i;
        zzagS = s;
        zzagT = j;
    }

    zzagT(String s, int i)
    {
        versionCode = 1;
        zzagS = s;
        zzagT = i;
    }
}
