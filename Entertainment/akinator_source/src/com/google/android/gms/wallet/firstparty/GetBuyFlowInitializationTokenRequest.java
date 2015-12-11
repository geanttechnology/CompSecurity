// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet.firstparty:
//            zzb

public final class GetBuyFlowInitializationTokenRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    byte zzbdN[];
    byte zzbdO[];

    GetBuyFlowInitializationTokenRequest()
    {
        this(1, null, null);
    }

    GetBuyFlowInitializationTokenRequest(int i, byte abyte0[], byte abyte1[])
    {
        mVersionCode = i;
        zzbdN = abyte0;
        zzbdO = abyte1;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
