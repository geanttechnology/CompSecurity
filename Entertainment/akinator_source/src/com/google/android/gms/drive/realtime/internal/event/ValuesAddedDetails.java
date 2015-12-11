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
    final int zzaoF;
    final int zzaoG;
    final String zzape;
    final int zzapf;

    ValuesAddedDetails(int i, int j, int k, int l, String s, int i1)
    {
        mVersionCode = i;
        mIndex = j;
        zzaoF = k;
        zzaoG = l;
        zzape = s;
        zzapf = i1;
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
