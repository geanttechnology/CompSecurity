// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.j;

// Referenced classes of package com.google.android.gms.location.internal:
//            d, j, LocationRequestInternal

class <init> extends <init>
{

    final LocationRequest b;
    final j c;
    final Looper d;
    final d e;

    protected volatile void a(com.google.android.gms.common.api.._cls2 _pcls2)
        throws RemoteException
    {
        a((com.google.android.gms.location.internal.j)_pcls2);
    }

    protected void a(com.google.android.gms.location.internal.j j1)
        throws RemoteException
    {
        j1.a(LocationRequestInternal.a(b), c, d);
        a(((com.google.android.gms.common.api.g) (Status.a)));
    }

    st(d d1, c c1, LocationRequest locationrequest, j j1, Looper looper)
    {
        e = d1;
        b = locationrequest;
        c = j1;
        d = looper;
        super(c1);
    }
}
