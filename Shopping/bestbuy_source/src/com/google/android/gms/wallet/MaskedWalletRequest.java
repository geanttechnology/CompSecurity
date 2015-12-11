// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import atf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet:
//            Cart, CountrySpecification

public final class MaskedWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atf();
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public Cart h;
    public boolean i;
    public boolean j;
    public CountrySpecification k[];
    public boolean l;
    public boolean m;
    public ArrayList n;
    private final int o;

    MaskedWalletRequest()
    {
        o = 3;
        l = true;
        m = true;
    }

    public MaskedWalletRequest(int i1, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6, 
            ArrayList arraylist)
    {
        o = i1;
        a = s;
        b = flag;
        c = flag1;
        d = flag2;
        e = s1;
        f = s2;
        g = s3;
        h = cart;
        i = flag3;
        j = flag4;
        k = acountryspecification;
        l = flag5;
        m = flag6;
        n = arraylist;
    }

    public int a()
    {
        return o;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        atf.a(this, parcel, i1);
    }

}
