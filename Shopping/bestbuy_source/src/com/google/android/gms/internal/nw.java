// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import adw;
import afn;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nw
    implements SafeParcelable
{

    public static final afn CREATOR = new afn();
    public final int a;
    private final String b;
    private final String c;
    private final String d;

    public nw(int i, String s, String s1, String s2)
    {
        a = i;
        b = s;
        c = s1;
        d = s2;
    }

    public String a()
    {
        return b;
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public int describeContents()
    {
        afn afn1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof nw)
        {
            if (adv.a(b, ((nw) (obj = (nw)obj)).b) && adv.a(c, ((nw) (obj)).c) && adv.a(d, ((nw) (obj)).d))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            b, c, d
        });
    }

    public String toString()
    {
        return adv.a(this).a("mPlaceId", b).a("mTag", c).a("mSource", d).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afn afn1 = CREATOR;
        afn.a(this, parcel, i);
    }

}
