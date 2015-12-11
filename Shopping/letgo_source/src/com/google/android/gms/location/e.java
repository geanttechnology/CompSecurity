// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.c;

// Referenced classes of package com.google.android.gms.location:
//            LocationRequest, j, k, LocationAvailability

public interface e
{

    public abstract Location a(c c);

    public abstract com.google.android.gms.common.api.e a(c c, LocationRequest locationrequest, j j, Looper looper);

    public abstract com.google.android.gms.common.api.e a(c c, LocationRequest locationrequest, k k);

    public abstract com.google.android.gms.common.api.e a(c c, j j);

    public abstract com.google.android.gms.common.api.e a(c c, k k);

    public abstract LocationAvailability b(c c);
}
