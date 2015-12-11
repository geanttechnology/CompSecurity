// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.people.Person;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal:
//            PlusSession, zzd

public class zze extends zzi
{

    private Person zzaHl;
    private final PlusSession zzaHm;

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zze zze1, PlusSession plussession, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 2, connectioncallbacks, onconnectionfailedlistener, zze1);
        zzaHm = plussession;
    }

    public static boolean zze(Set set)
    {
        while (set == null || set.isEmpty() || set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) 
        {
            return false;
        }
        return true;
    }

    private Bundle zzkS()
    {
        Bundle bundle = zzaHm.zzxE();
        bundle.putStringArray("request_visible_actions", zzaHm.zzxy());
        bundle.putString("auth_package", zzaHm.zzxA());
        return bundle;
    }

    protected String getServiceDescriptor()
    {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected String getStartServiceAction()
    {
        return "com.google.android.gms.plus.service.START";
    }

    public boolean requiresSignIn()
    {
        return zze(zznK().zzb(Plus.API));
    }

    protected IInterface zzT(IBinder ibinder)
    {
        return zzdu(ibinder);
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person"))
        {
            zzaHl = PersonEntity.zzp(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, ibinder, bundle, j);
    }

    protected zzd zzdu(IBinder ibinder)
    {
        return zzd.zza.zzdt(ibinder);
    }

    protected Bundle zzkR()
    {
        return zzkS();
    }

    protected Bundle zznN()
    {
        return zzkS();
    }

    public void zzxr()
    {
        zznL();
        try
        {
            zzaHl = null;
            ((zzd)zznM()).zzxr();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }
}
