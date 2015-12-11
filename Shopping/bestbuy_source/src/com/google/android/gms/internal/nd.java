// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import aep;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nd
    implements SafeParcelable
{

    public static final aep CREATOR = new aep();
    public final int a;
    public final String b;
    private final int c;

    public nd(int i, int j, String s)
    {
        c = i;
        a = j;
        b = s;
    }

    public int a()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof nd)
        {
            if (((nd) (obj = (nd)obj)).a == a && adv.a(((nd) (obj)).b, b))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return a;
    }

    public String toString()
    {
        return String.format("%d:%s", new Object[] {
            Integer.valueOf(a), b
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aep.a(this, parcel, i);
    }

}
