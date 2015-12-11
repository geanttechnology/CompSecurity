// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzg

public class zzQC
    implements Result, SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    public Status zzQA;
    public List zzQB;
    public String zzQC[];

    public int describeContents()
    {
        return 0;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }


    public ()
    {
        mVersionCode = 1;
    }

    mVersionCode(int i, Status status, List list, String as[])
    {
        mVersionCode = i;
        zzQA = status;
        zzQB = list;
        zzQC = as;
    }
}
