// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import ady;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import rc;

public final class Scope
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new rc();
    public final int a;
    private final String b;

    public Scope(int i, String s)
    {
        ady.a(s, "scopeUri must not be null or empty");
        a = i;
        b = s;
    }

    public String a()
    {
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Scope))
        {
            return false;
        } else
        {
            return b.equals(((Scope)obj).b);
        }
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public String toString()
    {
        return b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        rc.a(this, parcel, i);
    }

}
