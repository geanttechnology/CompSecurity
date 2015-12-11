// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzk

public class CreateContentsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    final int zzaiz;

    public CreateContentsRequest(int i)
    {
        this(1, i);
    }

    CreateContentsRequest(int i, int j)
    {
        mVersionCode = i;
        boolean flag;
        if (j == 0x20000000 || j == 0x30000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot create a new read-only contents!");
        zzaiz = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
