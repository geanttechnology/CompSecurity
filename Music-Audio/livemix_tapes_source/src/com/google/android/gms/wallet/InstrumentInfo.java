// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzh

public final class InstrumentInfo
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private String zzaWC;
    private String zzaWD;

    InstrumentInfo(int i, String s, String s1)
    {
        mVersionCode = i;
        zzaWC = s;
        zzaWD = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getInstrumentDetails()
    {
        return zzaWD;
    }

    public String getInstrumentType()
    {
        return zzaWC;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}
