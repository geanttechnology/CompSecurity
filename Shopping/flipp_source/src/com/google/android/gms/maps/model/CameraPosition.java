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
//            b, LatLng

public final class CameraPosition
    implements SafeParcelable
{

    public static final com.google.android.gms.maps.model.b CREATOR = new com.google.android.gms.maps.model.b();
    final int a;
    public final LatLng b;
    public final float c;
    public final float d;
    public final float e;

    CameraPosition(int i, LatLng latlng, float f, float f1, float f2)
    {
        ha.a(latlng, "null camera target");
        boolean flag;
        if (0.0F <= f1 && f1 <= 90F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ha.a(flag, "Tilt needs to be between 0 and 90 inclusive");
        a = i;
        b = latlng;
        c = f;
        d = f1 + 0.0F;
        f = f2;
        if ((double)f2 <= 0.0D)
        {
            f = f2 % 360F + 360F;
        }
        e = f % 360F;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof CameraPosition))
            {
                return false;
            }
            obj = (CameraPosition)obj;
            if (!b.equals(((CameraPosition) (obj)).b) || Float.floatToIntBits(c) != Float.floatToIntBits(((CameraPosition) (obj)).c) || Float.floatToIntBits(d) != Float.floatToIntBits(((CameraPosition) (obj)).d) || Float.floatToIntBits(e) != Float.floatToIntBits(((CameraPosition) (obj)).e))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, Float.valueOf(c), Float.valueOf(d), Float.valueOf(e)
        });
    }

    public final String toString()
    {
        return gw.a(this).a("target", b).a("zoom", Float.valueOf(c)).a("tilt", Float.valueOf(d)).a("bearing", Float.valueOf(e)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        if (com.google.android.gms.maps.a.b.a())
        {
            int j = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, a);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, b, i, false);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, c);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, d);
            com.google.android.gms.common.internal.safeparcel.c.a(parcel, 5, e);
            com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
            return;
        } else
        {
            com.google.android.gms.maps.model.b.a(this, parcel, i);
            return;
        }
    }

}
