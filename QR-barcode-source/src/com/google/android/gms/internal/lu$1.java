// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            lu, lz

class <init> extends <init>
{

    final LocationRequest aeE;
    final LocationListener aeF;
    final lu aeG;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((lz));
    }

    protected void a(lz lz1)
        throws RemoteException
    {
        lz1.requestLocationUpdates(aeE, aeF, null);
        b(Status.Jv);
    }

    ionListener(lu lu1, LocationRequest locationrequest, LocationListener locationlistener)
    {
        aeG = lu1;
        aeE = locationrequest;
        aeF = locationlistener;
        super(null);
    }
}
