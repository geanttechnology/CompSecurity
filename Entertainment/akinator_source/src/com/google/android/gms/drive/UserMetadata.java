// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive:
//            zzk

public class UserMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    final String zzTa;
    final String zzajr;
    final String zzajs;
    final boolean zzajt;
    final String zzaju;

    UserMetadata(int i, String s, String s1, String s2, boolean flag, String s3)
    {
        mVersionCode = i;
        zzajr = s;
        zzTa = s1;
        zzajs = s2;
        zzajt = flag;
        zzaju = s3;
    }

    public UserMetadata(String s, String s1, String s2, boolean flag, String s3)
    {
        this(1, s, s1, s2, flag, s3);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[] {
            zzajr, zzTa, zzajs, Boolean.valueOf(zzajt), zzaju
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
