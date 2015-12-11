// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzm

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    int status;
    final int zzCY;
    String zzaQm;
    String zzaRw;

    NotifyTransactionStatusRequest()
    {
        zzCY = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int j, String s1)
    {
        zzCY = i;
        zzaQm = s;
        status = j;
        zzaRw = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

}
