// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.server.response:
//            zzb

public class zzahi
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    final String key;
    final int versionCode;
    final zzahi zzahi;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }


    (int i, String s,  )
    {
        versionCode = i;
        key = s;
        zzahi = ;
    }

    zzahi(String s, zzahi zzahi1)
    {
        versionCode = 1;
        key = s;
        zzahi = zzahi1;
    }
}
