// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zzb

public final class CredentialRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    final int zzCY;
    private final boolean zzOY;
    private final String zzOZ[];

    CredentialRequest(int i, boolean flag, String as[])
    {
        zzCY = i;
        zzOY = flag;
        zzOZ = as;
    }

    public int describeContents()
    {
        return 0;
    }

    public String[] getAccountTypes()
    {
        return zzOZ;
    }

    public boolean getSupportsPasswordLogin()
    {
        return zzOY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
