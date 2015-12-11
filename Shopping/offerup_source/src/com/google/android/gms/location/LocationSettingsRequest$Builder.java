// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.location:
//            LocationSettingsRequest, LocationRequest

public final class zzaEN
{

    private boolean zzaEL;
    private boolean zzaEM;
    private boolean zzaEN;
    private final ArrayList zzaEO = new ArrayList();

    public final zzaEN addAllLocationRequests(Collection collection)
    {
        zzaEO.addAll(collection);
        return this;
    }

    public final zzaEO addLocationRequest(LocationRequest locationrequest)
    {
        zzaEO.add(locationrequest);
        return this;
    }

    public final LocationSettingsRequest build()
    {
        return new LocationSettingsRequest(zzaEO, zzaEL, zzaEM, zzaEN, null);
    }

    public final zzaEN setAlwaysShow(boolean flag)
    {
        zzaEL = flag;
        return this;
    }

    public final zzaEL setNeedBle(boolean flag)
    {
        zzaEM = flag;
        return this;
    }

    public ()
    {
        zzaEL = false;
        zzaEM = false;
        zzaEN = false;
    }
}
