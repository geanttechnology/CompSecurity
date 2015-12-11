// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import pj;
import ud;

public final class bj
    implements SafeParcelable
{

    public static final ud CREATOR = new ud();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final String o;

    public bj(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, int i3, String s, int j3, String s1, int k3, int l3, 
            String s2)
    {
        a = i1;
        b = j1;
        c = k1;
        d = l1;
        e = i2;
        f = j2;
        g = k2;
        h = l2;
        i = i3;
        j = s;
        k = j3;
        l = s1;
        m = k3;
        n = l3;
        o = s2;
    }

    public bj(pj pj1)
    {
        a = 1;
        b = pj1.a();
        c = pj1.b();
        d = pj1.c();
        e = pj1.d();
        f = pj1.e();
        g = pj1.f();
        h = pj1.g();
        i = pj1.h();
        j = pj1.i();
        k = pj1.j();
        l = pj1.k();
        m = pj1.l();
        n = pj1.m();
        o = pj1.n();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        ud.a(this, parcel, i1);
    }

}
