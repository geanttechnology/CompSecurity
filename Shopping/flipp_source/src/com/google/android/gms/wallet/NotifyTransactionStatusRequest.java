// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            j

public final class NotifyTransactionStatusRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new j();
    final int a;
    String b;
    int c;
    String d;

    NotifyTransactionStatusRequest()
    {
        a = 1;
    }

    NotifyTransactionStatusRequest(int i, String s, int k, String s1)
    {
        a = i;
        b = s;
        c = k;
        d = s1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        j.a(this, parcel);
    }

}
