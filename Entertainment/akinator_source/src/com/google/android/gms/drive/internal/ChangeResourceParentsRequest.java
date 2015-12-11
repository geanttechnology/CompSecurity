// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzf

public class ChangeResourceParentsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    final int mVersionCode;
    final DriveId zzajY;
    final List zzajZ;
    final List zzaka;

    ChangeResourceParentsRequest(int i, DriveId driveid, List list, List list1)
    {
        mVersionCode = i;
        zzajY = driveid;
        zzajZ = list;
        zzaka = list1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

}
