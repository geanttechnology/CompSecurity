// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.nn;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ahw
{

    private final List a = new ArrayList();
    private int b;

    public ahw()
    {
        b = 5;
    }

    public static int b(int i)
    {
        return i & 7;
    }

    public ahw a(int i)
    {
        b = b(i);
        return this;
    }

    public ahw a(ahs ahs1)
    {
        ady.a(ahs1, "geofence can't be null.");
        ady.b(ahs1 instanceof nn, "Geofence must be created using Geofence.Builder.");
        a.add((nn)ahs1);
        return this;
    }

    public ahw a(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                ahs ahs1 = (ahs)list.next();
                if (ahs1 != null)
                {
                    a(ahs1);
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
        ady.b(flag, "No geofence has been added to this request.");
        return new GeofencingRequest(a, b, null);
    }
}
