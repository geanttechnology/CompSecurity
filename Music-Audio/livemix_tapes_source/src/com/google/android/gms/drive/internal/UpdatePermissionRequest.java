// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbw

public class UpdatePermissionRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbw();
    final int mVersionCode;
    final String zzagM;
    final String zzagY;
    final DriveId zzags;
    final boolean zzahM;
    final int zzakb;

    UpdatePermissionRequest(int i, DriveId driveid, String s, int j, boolean flag, String s1)
    {
        mVersionCode = i;
        zzags = driveid;
        zzagY = s;
        zzakb = j;
        zzahM = flag;
        zzagM = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbw.zza(this, parcel, i);
    }

}
