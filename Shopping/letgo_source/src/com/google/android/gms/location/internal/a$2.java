// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;

// Referenced classes of package com.google.android.gms.location.internal:
//            a, j

class <init> extends <init>
{

    final PendingIntent b;
    final a c;

    protected volatile void a(com.google.android.gms.common.api.._cls2 _pcls2)
        throws RemoteException
    {
        a((j)_pcls2);
    }

    protected void a(j j1)
        throws RemoteException
    {
        j1.a(b);
        a(((com.google.android.gms.common.api.g) (Status.a)));
    }

    (a a1, c c1, PendingIntent pendingintent)
    {
        c = a1;
        b = pendingintent;
        super(c1);
    }
}
