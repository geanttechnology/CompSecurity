// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzay

public class OnDownloadProgressResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzay();
    private static final List zzalZ = new ArrayList();
    final int mVersionCode;
    final long zzama;
    final long zzamb;
    final List zzamc;
    final int zzys;

    OnDownloadProgressResponse(int i, long l, long l1, int j, List list)
    {
        mVersionCode = i;
        zzama = l;
        zzamb = l1;
        zzys = j;
        zzamc = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzay.zza(this, parcel, i);
    }

    public long zzry()
    {
        return zzama;
    }

    public long zzrz()
    {
        return zzamb;
    }

}
