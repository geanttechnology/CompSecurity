// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.server:
//            zza

public class FavaDiagnosticsEntity
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    final int mVersionCode;
    public final String zzagM;
    public final int zzagN;

    public FavaDiagnosticsEntity(int i, String s, int j)
    {
        mVersionCode = i;
        zzagM = s;
        zzagN = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
