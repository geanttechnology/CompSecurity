// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import adv;
import android.os.Parcel;
import aup;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new aup();
    public final int a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final boolean f;
    private boolean g;
    private String h;

    public c(int i, String s, String s1, int j, int k, boolean flag, boolean flag1, 
            String s2)
    {
        a = i;
        b = s;
        c = s1;
        d = j;
        e = k;
        f = flag;
        g = flag1;
        h = s2;
    }

    public String a()
    {
        return b;
    }

    public String b()
    {
        return c;
    }

    public int c()
    {
        return d;
    }

    public int d()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return g;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof c)
        {
            if (adv.a(Integer.valueOf(a), Integer.valueOf(((c) (obj = (c)obj)).a)) && adv.a(b, ((c) (obj)).b) && adv.a(c, ((c) (obj)).c) && adv.a(Integer.valueOf(d), Integer.valueOf(((c) (obj)).d)) && adv.a(Integer.valueOf(e), Integer.valueOf(((c) (obj)).e)) && adv.a(Boolean.valueOf(f), Boolean.valueOf(((c) (obj)).f)))
            {
                return true;
            }
        }
        return false;
    }

    public String f()
    {
        return h;
    }

    public boolean g()
    {
        return f;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            Integer.valueOf(a), b, c, Integer.valueOf(d), Integer.valueOf(e), Boolean.valueOf(f)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringbuilder.append((new StringBuilder()).append("mName=").append(b).toString());
        stringbuilder.append((new StringBuilder()).append(", mAddress=").append(c).toString());
        stringbuilder.append((new StringBuilder()).append(", mType=").append(d).toString());
        stringbuilder.append((new StringBuilder()).append(", mRole=").append(e).toString());
        stringbuilder.append((new StringBuilder()).append(", mEnabled=").append(f).toString());
        stringbuilder.append((new StringBuilder()).append(", mIsConnected=").append(g).toString());
        stringbuilder.append((new StringBuilder()).append(", mEnabled=").append(h).toString());
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aup.a(this, parcel, i);
    }

}
