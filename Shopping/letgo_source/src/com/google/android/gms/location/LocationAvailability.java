// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.location:
//            i

public final class LocationAvailability
    implements SafeParcelable
{

    public static final i CREATOR = new i();
    int a;
    int b;
    long c;
    int d;
    private final int e;

    LocationAvailability(int j, int k, int l, int i1, long l1)
    {
        e = j;
        d = k;
        a = l;
        b = i1;
        c = l1;
    }

    public boolean a()
    {
        return d < 1000;
    }

    int b()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LocationAvailability)
        {
            if (d == ((LocationAvailability) (obj = (LocationAvailability)obj)).d && a == ((LocationAvailability) (obj)).a && b == ((LocationAvailability) (obj)).b && c == ((LocationAvailability) (obj)).c)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            Integer.valueOf(d), Integer.valueOf(a), Integer.valueOf(b), Long.valueOf(c)
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("LocationAvailability[isLocationAvailable: ").append(a()).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        i.a(this, parcel, j);
    }

}
