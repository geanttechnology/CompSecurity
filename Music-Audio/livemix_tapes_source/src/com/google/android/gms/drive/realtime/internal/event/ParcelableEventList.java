// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            zzd

public class ParcelableEventList
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzamv;
    final boolean zzamw;
    final List zzamx;
    final ParcelableChangeInfo zzamy;
    final List zzoP;

    ParcelableEventList(int i, List list, DataHolder dataholder, boolean flag, List list1, ParcelableChangeInfo parcelablechangeinfo)
    {
        mVersionCode = i;
        zzoP = list;
        zzamv = dataholder;
        zzamw = flag;
        zzamx = list1;
        zzamy = parcelablechangeinfo;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}
