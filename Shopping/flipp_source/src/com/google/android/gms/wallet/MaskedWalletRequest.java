// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            i, Cart, CountrySpecification

public final class MaskedWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new i();
    final int a;
    String b;
    boolean c;
    boolean d;
    boolean e;
    String f;
    String g;
    String h;
    Cart i;
    boolean j;
    boolean k;
    CountrySpecification l[];
    boolean m;
    boolean n;

    MaskedWalletRequest()
    {
        a = 3;
        m = true;
        n = true;
    }

    MaskedWalletRequest(int i1, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6)
    {
        a = i1;
        b = s;
        c = flag;
        d = flag1;
        e = flag2;
        f = s1;
        g = s2;
        h = s3;
        i = cart;
        j = flag3;
        k = flag4;
        l = acountryspecification;
        m = flag5;
        n = flag6;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.wallet.i.a(this, parcel, i1);
    }

}
