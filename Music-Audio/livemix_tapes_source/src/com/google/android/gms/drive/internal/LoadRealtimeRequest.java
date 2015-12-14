// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaq

public class LoadRealtimeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzaq();
    final int mVersionCode;
    final DriveId zzags;
    final boolean zzajt;
    final List zzaju;
    final boolean zzajv;
    final DataHolder zzajw;
    final String zzajx;

    LoadRealtimeRequest(int i, DriveId driveid, boolean flag, List list, boolean flag1, DataHolder dataholder, String s)
    {
        mVersionCode = i;
        zzags = driveid;
        zzajt = flag;
        zzaju = list;
        zzajv = flag1;
        zzajw = dataholder;
        zzajx = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzaq.zza(this, parcel, i);
    }

}
