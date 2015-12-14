// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzq

public final class ProxyCard
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzq();
    private final int mVersionCode;
    int zzaXA;
    int zzaXB;
    String zzaXy;
    String zzaXz;

    ProxyCard(int i, String s, String s1, int j, int k)
    {
        mVersionCode = i;
        zzaXy = s;
        zzaXz = s1;
        zzaXA = j;
        zzaXB = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCvn()
    {
        return zzaXz;
    }

    public int getExpirationMonth()
    {
        return zzaXA;
    }

    public int getExpirationYear()
    {
        return zzaXB;
    }

    public String getPan()
    {
        return zzaXy;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

}
