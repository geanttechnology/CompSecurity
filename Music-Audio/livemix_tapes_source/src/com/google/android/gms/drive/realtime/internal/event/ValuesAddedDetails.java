// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            zzi

public class ValuesAddedDetails
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    final int mIndex;
    final int mVersionCode;
    final String zzamE;
    final int zzamF;
    final int zzamf;
    final int zzamg;

    ValuesAddedDetails(int i, int j, int k, int l, String s, int i1)
    {
        mVersionCode = i;
        mIndex = j;
        zzamf = k;
        zzamg = l;
        zzamE = s;
        zzamF = i1;
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
