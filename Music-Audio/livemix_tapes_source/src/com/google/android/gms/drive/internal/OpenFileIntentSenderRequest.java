// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbk

public class OpenFileIntentSenderRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbk();
    final int mVersionCode;
    final String zzagU;
    final String zzagV[];
    final DriveId zzagX;
    final FilterHolder zzajX;

    OpenFileIntentSenderRequest(int i, String s, String as[], DriveId driveid, FilterHolder filterholder)
    {
        mVersionCode = i;
        zzagU = s;
        zzagV = as;
        zzagX = driveid;
        zzajX = filterholder;
    }

    public OpenFileIntentSenderRequest(String s, String as[], DriveId driveid, FilterHolder filterholder)
    {
        this(1, s, as, driveid, filterholder);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbk.zza(this, parcel, i);
    }

}
