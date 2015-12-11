// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            jb, gt, gw, gy

public final class gv
    implements SafeParcelable
{

    public static final jb CREATOR = new jb();
    final int a;
    final LocationRequest b;
    final gt c;

    public gv(int i, LocationRequest locationrequest, gt gt1)
    {
        a = i;
        b = locationrequest;
        c = gt1;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof gv))
            {
                return false;
            }
            obj = (gv)obj;
            if (!b.equals(((gv) (obj)).b) || !c.equals(((gv) (obj)).c))
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
        return gw.a(this).a("locationRequest", b).a("filter", c).toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        jb.a(this, parcel, i);
    }

}
