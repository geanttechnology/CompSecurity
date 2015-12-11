// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.ec;
import com.google.android.gms.internal.eg;

// Referenced classes of package com.google.android.gms.drive.internal:
//            o

public class j extends dw
{

    private final String jG;
    private DriveId rg;

    public j(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, as);
        jG = (String)eg.b(dt1.bF(), "Must call Api.ClientBuilder.setAccountName()");
    }

    protected o B(IBinder ibinder)
    {
        return o.a.C(ibinder);
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            rg = (DriveId)bundle.getParcelable("com.google.android.gms.drive.root_id");
        }
        super.a(i, ibinder, bundle);
    }

    protected void a(ec ec1, com.google.android.gms.internal.dw.e e)
        throws RemoteException
    {
        String s = getContext().getPackageName();
        eg.f(e);
        eg.f(s);
        eg.f(bO());
        ec1.a(e, 0x40ba50, s, bO(), jG, new Bundle());
    }

    protected String am()
    {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String an()
    {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public o cN()
    {
        return (o)bQ();
    }

    public DriveId cO()
    {
        return rg;
    }

    protected IInterface p(IBinder ibinder)
    {
        return B(ibinder);
    }
}
