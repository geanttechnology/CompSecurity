// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import adv;
import adw;
import ady;
import aks;
import android.os.Parcel;
import anu;
import anv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng

public final class LatLngBounds
    implements SafeParcelable
{

    public static final anu CREATOR = new anu();
    public final LatLng a;
    public final LatLng b;
    private final int c;

    public LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        ady.a(latlng, "null southwest");
        ady.a(latlng1, "null northeast");
        boolean flag;
        if (latlng1.a >= latlng.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.b(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.a), Double.valueOf(latlng1.a)
        });
        c = i;
        a = latlng;
        b = latlng1;
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
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!a.equals(((LatLngBounds) (obj)).a) || !b.equals(((LatLngBounds) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            a, b
        });
    }

    public String toString()
    {
        return adv.a(this).a("southwest", a).a("northeast", b).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (aks.a())
        {
            anv.a(this, parcel, i);
            return;
        } else
        {
            anu.a(this, parcel, i);
            return;
        }
    }

}
