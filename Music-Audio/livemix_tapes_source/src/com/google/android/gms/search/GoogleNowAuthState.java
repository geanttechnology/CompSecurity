// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.search;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.search:
//            zza

public class GoogleNowAuthState
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    String zzaNM;
    String zzaNN;
    long zzaNO;

    GoogleNowAuthState(int i, String s, String s1, long l)
    {
        mVersionCode = i;
        zzaNM = s;
        zzaNN = s1;
        zzaNO = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccessToken()
    {
        return zzaNN;
    }

    public String getAuthCode()
    {
        return zzaNM;
    }

    public long getNextAllowedTimeMillis()
    {
        return zzaNO;
    }

    public String toString()
    {
        return (new StringBuilder()).append("mAuthCode = ").append(zzaNM).append("\nmAccessToken = ").append(zzaNN).append("\nmNextAllowedTimeMillis = ").append(zzaNO).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
