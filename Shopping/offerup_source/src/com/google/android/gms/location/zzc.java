// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.IInterface;

// Referenced classes of package com.google.android.gms.location:
//            LocationAvailability, LocationResult

public interface zzc
    extends IInterface
{

    public abstract void onLocationAvailability(LocationAvailability locationavailability);

    public abstract void onLocationResult(LocationResult locationresult);
}
