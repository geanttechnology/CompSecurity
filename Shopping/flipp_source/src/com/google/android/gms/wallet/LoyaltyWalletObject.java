// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            g

public final class LoyaltyWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new g();
    final int a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;

    LoyaltyWalletObject()
    {
        a = 3;
    }

    LoyaltyWalletObject(int j, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7)
    {
        a = j;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = s4;
        g = s5;
        h = s6;
        i = s7;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        com.google.android.gms.wallet.g.a(this, parcel);
    }

}
