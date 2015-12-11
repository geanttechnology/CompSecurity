// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.ha;
import com.google.android.gms.maps.a.b;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.maps.model:
//            e, LatLng

public final class LatLngBounds
    implements SafeParcelable
{

    public static final e CREATOR = new e();
    final int a;
    public final LatLng b;
    public final LatLng c;

    LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        ha.a(latlng, "null southwest");
        ha.a(latlng1, "null northeast");
        double d;
        double d1;
        boolean flag;
        if (latlng1.b >= latlng.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = latlng.b;
        d1 = latlng1.b;
        if (!flag)
        {
            throw new IllegalArgumentException(String.format("southern latitude exceeds northern latitude (%s > %s)", new Object[] {
                Double.valueOf(d), Double.valueOf(d1)
            }));
        } else
        {
            a = i;
            b = latlng;
            c = latlng1;
            return;
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!b.equals(((LatLngBounds) (obj)).b) || !c.equals(((LatLngBounds) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c
        });
    }

    public final String toString()
    {
        return gw.a(this).a("southwest", b).a("northeast", c).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            int j = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, b, i, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, c, i, false);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
            return;
        } else
        {
            e.a(this, parcel, i);
            return;
        }
    }

}
