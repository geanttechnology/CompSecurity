// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            gp, fx

class init> extends init>
{

    final gp Iq;
    final int Iw;
    final int Ix[];

    protected volatile void a(com.google.android.gms.common.api.it> it>)
        throws RemoteException
    {
        a((fx)it>);
    }

    protected void a(fx fx1)
    {
        fx1.a(this, Iw, Ix);
    }

    a(gp gp1, int i, int ai[])
    {
        Iq = gp1;
        Iw = i;
        Ix = ai;
        super(null);
    }
}
