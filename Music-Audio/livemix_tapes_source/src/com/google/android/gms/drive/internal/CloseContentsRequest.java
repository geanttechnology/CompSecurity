// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzh

public class CloseContentsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final Contents zzahR;
    final int zzahT;
    final Boolean zzahV;

    CloseContentsRequest(int i, Contents contents, Boolean boolean1, int j)
    {
        mVersionCode = i;
        zzahR = contents;
        zzahV = boolean1;
        zzahT = j;
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
        zzh.zza(this, parcel, i);
    }

}
