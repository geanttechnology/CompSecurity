// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            dw, ec, cd

public class by extends dw
{

    private final int hp;

    public by(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, int i)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, new String[0]);
        hp = i;
    }

    protected void a(ec ec1, dw.e e)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        ec1.g(e, hp, getContext().getPackageName(), bundle);
    }

    protected String am()
    {
        return "com.google.android.gms.ads.service.START";
    }

    protected String an()
    {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public cd ao()
    {
        return (cd)super.bQ();
    }

    protected cd o(IBinder ibinder)
    {
        return cd.a.q(ibinder);
    }

    protected IInterface p(IBinder ibinder)
    {
        return o(ibinder);
    }
}
