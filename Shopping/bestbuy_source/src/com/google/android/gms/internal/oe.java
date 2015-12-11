// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import ady;
import aft;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe
    implements SafeParcelable
{

    public static final aft CREATOR = new aft();
    public static final oe a;
    public static final oe b;
    public static final Set c;
    public final int d;
    public final String e;
    public final int f;

    public oe(int i, String s, int j)
    {
        ady.a(s);
        d = i;
        e = s;
        f = j;
    }

    private static oe a(String s, int i)
    {
        return new oe(0, s, i);
    }

    public int describeContents()
    {
        aft aft1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof oe))
            {
                return false;
            }
            obj = (oe)obj;
            if (!e.equals(((oe) (obj)).e) || f != ((oe) (obj)).f)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return e.hashCode();
    }

    public String toString()
    {
        return e;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aft aft1 = CREATOR;
        aft.a(this, parcel, i);
    }

    static 
    {
        a = a("test_type", 1);
        b = a("labeled_place", 6);
        c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new oe[] {
            a, b
        })));
    }
}
