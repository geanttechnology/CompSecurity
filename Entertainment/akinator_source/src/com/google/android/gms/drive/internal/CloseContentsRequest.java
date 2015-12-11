// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzi

public class CloseContentsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    final int mVersionCode;
    final Contents zzake;
    final int zzakg;
    final Boolean zzaki;

    CloseContentsRequest(int i, Contents contents, Boolean boolean1, int j)
    {
        mVersionCode = i;
        zzake = contents;
        zzaki = boolean1;
        zzakg = j;
    }

    public CloseContentsRequest(int i, boolean flag)
    {
        this(1, null, Boolean.valueOf(flag), i);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

}
