// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import aue;
import avo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class al
    implements aue, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new avo();
    public final int a;
    private final String b;
    private final String c;

    public al(int i, String s, String s1)
    {
        a = i;
        b = s;
        c = s1;
    }

    public String a()
    {
        return b;
    }

    public String b()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof al)
        {
            if (((al) (obj = (al)obj)).b.equals(b) && ((al) (obj)).c.equals(c))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (b.hashCode() + 629) * 37 + c.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("NodeParcelable{").append(b).append(",").append(c).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        avo.a(this, parcel, i);
    }

}
