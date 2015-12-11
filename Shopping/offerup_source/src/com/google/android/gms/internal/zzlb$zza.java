// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.internal:
//            zzlc

public abstract class x.zzw extends zzlc
    implements x.zzw, x.zzw
{

    private final com.google.android.gms.common.api.b zzZM;
    private AtomicReference zzabg;

    private void zza(RemoteException remoteexception)
    {
        zzv(new Status(8, remoteexception.getLocalizedMessage(), null));
    }

    protected abstract void zza(com.google.android.gms.common.api.age age);

    public void zza( )
    {
        zzabg.set();
    }

    public final void zzb(com.google.android.gms.common.api..set set)
    {
        try
        {
            zza(set);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api..set set)
        {
            zza(set);
            throw set;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api..set set)
        {
            zza(set);
        }
    }

    public void zznJ()
    {
        setResultCallback(null);
    }

    public int zznK()
    {
        return 0;
    }

    protected void zznL()
    {
        allback allback = (allback)zzabg.getAndSet(null);
        if (allback != null)
        {
            allback.zzc(this);
        }
    }

    public final com.google.android.gms.common.api.c zznx()
    {
        return zzZM;
    }

    public void zzp(Object obj)
    {
        super.zzb((Result)obj);
    }

    public final void zzv(Status status)
    {
        boolean flag;
        if (!status.isSuccess())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Failed result must not be success");
        zzb(zzb(status));
    }

    protected piClient(com.google.android.gms.common.api.Client client, GoogleApiClient googleapiclient)
    {
        super(((GoogleApiClient)zzx.zzb(googleapiclient, "GoogleApiClient must not be null")).getLooper());
        zzabg = new AtomicReference();
        zzZM = (com.google.android.gms.common.api.ZM)zzx.zzw(client);
    }
}
