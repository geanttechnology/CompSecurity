// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import a;
import android.os.Parcel;
import azf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class ig
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new azf();
    public final int a;
    public String b;

    public ig()
    {
        this(1, null);
    }

    public ig(int i, String s)
    {
        a = i;
        b = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ig))
        {
            return false;
        } else
        {
            obj = (ig)obj;
            return a.g(b, ((ig) (obj)).b);
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        azf.a(this, parcel);
    }

}
