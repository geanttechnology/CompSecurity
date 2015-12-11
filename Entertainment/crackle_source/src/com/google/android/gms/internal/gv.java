// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            gw, gt, ee

public final class gv
    implements SafeParcelable
{

    public static final gw CREATOR = new gw();
    final int kg;
    private final LocationRequest yl;
    private final gt ym;

    public gv(int i, LocationRequest locationrequest, gt gt1)
    {
        kg = i;
        yl = locationrequest;
        ym = gt1;
    }

    public LocationRequest dS()
    {
        return yl;
    }

    public gt dT()
    {
        return ym;
    }

    public int describeContents()
    {
        gw gw1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof gv))
            {
                return false;
            }
            obj = (gv)obj;
            if (!yl.equals(((gv) (obj)).yl) || !ym.equals(((gv) (obj)).ym))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            yl, ym
        });
    }

    public String toString()
    {
        return ee.e(this).a("locationRequest", yl).a("filter", ym).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        gw gw1 = CREATOR;
        gw.a(this, parcel, i);
    }

}
