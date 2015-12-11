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

    final long b;
    final PendingIntent c;
    final a d;

    protected volatile void a(com.google.android.gms.common.api.._cls1 _pcls1)
        throws RemoteException
    {
        a((j)_pcls1);
    }

    protected void a(j j1)
        throws RemoteException
    {
        j1.a(b, c);
        a(((com.google.android.gms.common.api.g) (Status.a)));
    }

    (a a1, c c1, long l, PendingIntent pendingintent)
    {
        d = a1;
        b = l;
        c = pendingintent;
        super(c1);
    }
}
