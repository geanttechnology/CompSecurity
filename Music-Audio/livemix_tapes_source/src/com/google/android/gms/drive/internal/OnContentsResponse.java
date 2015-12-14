// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzav

public class OnContentsResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzav();
    final int mVersionCode;
    final Contents zzaiD;
    final boolean zzajI;

    OnContentsResponse(int i, Contents contents, boolean flag)
    {
        mVersionCode = i;
        zzaiD = contents;
        zzajI = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzav.zza(this, parcel, i);
    }

    public Contents zzqN()
    {
        return zzaiD;
    }

    public boolean zzqO()
    {
        return zzajI;
    }

}
