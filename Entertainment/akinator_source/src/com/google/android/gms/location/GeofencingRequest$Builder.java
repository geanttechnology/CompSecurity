// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            GeofencingRequest, Geofence

public static final class zzaEu
{

    private final List zzaEt = new ArrayList();
    private int zzaEu;

    public static int zzgM(int i)
    {
        return i & 7;
    }

    public zzaEu addGeofence(Geofence geofence)
    {
        zzx.zzb(geofence, "geofence can't be null.");
        zzx.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
        zzaEt.add((ParcelableGeofence)geofence);
        return this;
    }

    public e addGeofences(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Geofence geofence = (Geofence)list.next();
                if (geofence != null)
                {
                    addGeofence(geofence);
                }
            }
        }
        return this;
    }

    public GeofencingRequest build()
    {
        boolean flag;
        if (!zzaEt.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "No geofence has been added to this request.");
        return new GeofencingRequest(zzaEt, zzaEu, null);
    }

    public zzaEu setInitialTrigger(int i)
    {
        zzaEu = zzgM(i);
        return this;
    }

    public e()
    {
        zzaEu = 5;
    }
}
