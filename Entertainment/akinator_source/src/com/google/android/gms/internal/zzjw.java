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
//            zzjy, zzjx

public class zzjw extends zzj
{

    private final String zzRq;

    public zzjw(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf1)
    {
        super(context, looper, 77, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzRq = zzf1.zzoN();
    }

    private Bundle zzlz()
    {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", zzRq);
        return bundle;
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzaj(ibinder);
    }

    public void zza(zzjx zzjx, String s)
    {
        try
        {
            ((zzjy)zzpc()).zza(zzjx, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzjx zzjx)
        {
            return;
        }
    }

    protected zzjy zzaj(IBinder ibinder)
    {
        return zzjy.zza.zzal(ibinder);
    }

    public void zzb(zzjx zzjx, String s)
    {
        try
        {
            ((zzjy)zzpc()).zzb(zzjx, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzjx zzjx)
        {
            return;
        }
    }

    protected String zzfK()
    {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected Bundle zzly()
    {
        return zzlz();
    }
}
