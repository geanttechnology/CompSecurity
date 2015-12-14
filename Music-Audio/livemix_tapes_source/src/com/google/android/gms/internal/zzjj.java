// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.internal:
//            zzjl, zzjk

public class zzjj extends zzj
{

    private final String zzQl;

    public zzjj(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf1)
    {
        super(context, looper, 77, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzQl = zzf1.zzol();
    }

    private Bundle zzlj()
    {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", zzQl);
        return bundle;
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzai(ibinder);
    }

    public void zza(zzjk zzjk, String s)
    {
        try
        {
            ((zzjl)zzoA()).zza(zzjk, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzjk zzjk)
        {
            return;
        }
    }

    protected zzjl zzai(IBinder ibinder)
    {
        return zzjl.zza.zzak(ibinder);
    }

    public void zzb(zzjk zzjk, String s)
    {
        try
        {
            ((zzjl)zzoA()).zzb(zzjk, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzjk zzjk)
        {
            return;
        }
    }

    protected String zzfA()
    {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected Bundle zzli()
    {
        return zzlj();
    }
}
