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
    String zzbdF;
    String zzbdG;
    int zzbdH;
    int zzbdI;

    ProxyCard(int i, String s, String s1, int j, int k)
    {
        mVersionCode = i;
        zzbdF = s;
        zzbdG = s1;
        zzbdH = j;
        zzbdI = k;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getCvn()
    {
        return zzbdG;
    }

    public final int getExpirationMonth()
    {
        return zzbdH;
    }

    public final int getExpirationYear()
    {
        return zzbdI;
    }

    public final String getPan()
    {
        return zzbdF;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzq.zza(this, parcel, i);
    }

}
