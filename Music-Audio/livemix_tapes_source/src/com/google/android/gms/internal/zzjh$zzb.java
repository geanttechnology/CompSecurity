// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appdatasearch.zza;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzjh, zzjf, zzjc

private static abstract class  extends com.google.android.gms.common.api.Client
{

    protected volatile void zza(com.google.android.gms.common.api.Client client)
        throws RemoteException
    {
        zza((zzjf)client);
    }

    protected abstract void zza(zzjc zzjc)
        throws RemoteException;

    protected final void zza(zzjf zzjf1)
        throws RemoteException
    {
        zza(zzjf1.zzlg());
    }

    public piClient(GoogleApiClient googleapiclient)
    {
        super(zza.zzOO, googleapiclient);
    }
}
