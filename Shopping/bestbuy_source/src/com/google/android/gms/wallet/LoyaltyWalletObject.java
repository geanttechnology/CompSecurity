// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import aed;
import android.os.Parcel;
import atd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import java.util.ArrayList;

public final class LoyaltyWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new atd();
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public ArrayList l;
    public l m;
    public ArrayList n;
    public String o;
    public String p;
    public ArrayList q;
    public boolean r;
    public ArrayList s;
    public ArrayList t;
    public ArrayList u;
    public f v;
    private final int w;

    LoyaltyWalletObject()
    {
        w = 4;
        l = aed.a();
        n = aed.a();
        q = aed.a();
        s = aed.a();
        t = aed.a();
        u = aed.a();
    }

    public LoyaltyWalletObject(int i1, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, int j1, ArrayList arraylist, l l1, 
            ArrayList arraylist1, String s11, String s12, ArrayList arraylist2, boolean flag, ArrayList arraylist3, ArrayList arraylist4, 
            ArrayList arraylist5, f f1)
    {
        w = i1;
        a = s1;
        b = s2;
        c = s3;
        d = s4;
        e = s5;
        f = s6;
        g = s7;
        h = s8;
        i = s9;
        j = s10;
        k = j1;
        l = arraylist;
        m = l1;
        n = arraylist1;
        o = s11;
        p = s12;
        q = arraylist2;
        r = flag;
        s = arraylist3;
        t = arraylist4;
        u = arraylist5;
        v = f1;
    }

    public int a()
    {
        return w;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        atd.a(this, parcel, i1);
    }

}
