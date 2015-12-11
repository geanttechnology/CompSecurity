// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            j

public class LocationRequestInternal
    implements SafeParcelable
{

    public static final j CREATOR = new j();
    static final List a = Collections.emptyList();
    final int b;
    LocationRequest c;
    boolean d;
    boolean e;
    boolean f;
    List g;
    final String h;
    boolean i;

    LocationRequestInternal(int k, LocationRequest locationrequest, boolean flag, boolean flag1, boolean flag2, List list, String s, 
            boolean flag3)
    {
        b = k;
        c = locationrequest;
        d = flag;
        e = flag1;
        f = flag2;
        g = list;
        h = s;
        i = flag3;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof LocationRequestInternal)
        {
            if (v.a(c, ((LocationRequestInternal) (obj = (LocationRequestInternal)obj)).c) && d == ((LocationRequestInternal) (obj)).d && e == ((LocationRequestInternal) (obj)).e && f == ((LocationRequestInternal) (obj)).f && i == ((LocationRequestInternal) (obj)).i && v.a(g, ((LocationRequestInternal) (obj)).g))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return c.hashCode();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(c.toString());
        stringbuilder.append(" requestNlpDebugInfo=");
        stringbuilder.append(d);
        stringbuilder.append(" restorePendingIntentListeners=");
        stringbuilder.append(e);
        stringbuilder.append(" triggerUpdate=");
        stringbuilder.append(f);
        stringbuilder.append(" hideFromAppOps=");
        stringbuilder.append(i);
        stringbuilder.append(" clients=");
        stringbuilder.append(g);
        if (h != null)
        {
            stringbuilder.append(" tag=");
            stringbuilder.append(h);
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        j.a(this, parcel, k);
    }

}
