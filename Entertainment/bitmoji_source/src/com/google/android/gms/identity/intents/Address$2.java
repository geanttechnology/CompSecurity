// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hc;

// Referenced classes of package com.google.android.gms.identity.intents:
//            Address, UserAddressRequest

static final class <init> extends <init>
{

    final UserAddressRequest Kw;
    final int Kx;

    protected volatile void a(com.google.android.gms.common.api.ess._cls2 _pcls2)
        throws RemoteException
    {
        a((hc)_pcls2);
    }

    protected void a(hc hc1)
        throws RemoteException
    {
        hc1.a(Kw, Kx);
        a(((com.google.android.gms.common.api.Result) (Status.zQ)));
    }

    sRequest(UserAddressRequest useraddressrequest, int i)
    {
        Kw = useraddressrequest;
        Kx = i;
        super();
    }
}
