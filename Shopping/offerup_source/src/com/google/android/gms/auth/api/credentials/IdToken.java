// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zzd

public final class IdToken
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    private final String zzSk;
    private final String zzSs;

    IdToken(int i, String s, String s1)
    {
        mVersionCode = i;
        zzSk = s;
        zzSs = s1;
    }

    public IdToken(String s, String s1)
    {
        this(1, s, s1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getAccountType()
    {
        return zzSk;
    }

    public final String getIdToken()
    {
        return zzSs;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
