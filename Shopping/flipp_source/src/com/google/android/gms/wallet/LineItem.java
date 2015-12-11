// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            f

public final class LineItem
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new f();
    final int a;
    String b;
    String c;
    String d;
    String e;
    int f;
    String g;

    LineItem()
    {
        a = 1;
        f = 0;
    }

    LineItem(int i, String s, String s1, String s2, String s3, int j, String s4)
    {
        a = i;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = j;
        g = s4;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.wallet.f.a(this, parcel);
    }

}
