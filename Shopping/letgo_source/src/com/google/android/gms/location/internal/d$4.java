// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.location.j;

// Referenced classes of package com.google.android.gms.location.internal:
//            d, j

class <init> extends <init>
{

    final j b;
    final d c;

    protected volatile void a(com.google.android.gms.common.api.._cls4 _pcls4)
        throws RemoteException
    {
        a((com.google.android.gms.location.internal.j)_pcls4);
    }

    protected void a(com.google.android.gms.location.internal.j j1)
        throws RemoteException
    {
        j1.a(b);
        a(((com.google.android.gms.common.api.g) (Status.a)));
    }

    (d d1, c c1, j j1)
    {
        c = d1;
        b = j1;
        super(c1);
    }
}
