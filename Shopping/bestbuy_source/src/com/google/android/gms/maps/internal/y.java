// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import ang;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class y
    implements SafeParcelable
{

    public static final ang CREATOR = new ang();
    private final int a;
    private final Point b;

    public y(int i, Point point)
    {
        a = i;
        b = point;
    }

    public int a()
    {
        return a;
    }

    public Point b()
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
        if (!(obj instanceof y))
        {
            return false;
        } else
        {
            obj = (y)obj;
            return b.equals(((y) (obj)).b);
        }
    }

    public int hashCode()
    {
        return b.hashCode();
    }

    public String toString()
    {
        return b.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ang.a(this, parcel, i);
    }

}
