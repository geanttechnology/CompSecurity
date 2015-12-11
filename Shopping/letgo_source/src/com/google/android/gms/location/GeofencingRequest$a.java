// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            GeofencingRequest, f

public static final class b
{

    private final List a = new ArrayList();
    private int b;

    public static int b(int i)
    {
        return i & 7;
    }

    public b a(int i)
    {
        b = b(i);
        return this;
    }

    public b a(f f1)
    {
        x.a(f1, "geofence can't be null.");
        x.b(f1 instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
        a.add((ParcelableGeofence)f1);
        return this;
    }

    public eofence a(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                f f1 = (f)list.next();
                if (f1 != null)
                {
                    a(f1);
                }
            }
        }
        return this;
    }

    public GeofencingRequest a()
    {
        boolean flag;
        if (!a.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "No geofence has been added to this request.");
        return new GeofencingRequest(a, b, null);
    }

    public eofence()
    {
        b = 5;
    }
}
