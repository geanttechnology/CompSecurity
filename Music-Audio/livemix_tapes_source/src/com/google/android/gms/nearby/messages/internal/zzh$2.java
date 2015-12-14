// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzh, zzg, MessageWrapper

class a extends a
{

    final Message zzaJW;
    final Strategy zzaJX;
    final zzh zzaJY;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzg)b);
    }

    protected void zza(zzg zzg1)
        throws RemoteException
    {
        zzg1.zza(this, MessageWrapper.zza(zzaJW), zzaJX);
    }

    eWrapper(zzh zzh1, GoogleApiClient googleapiclient, Message message, Strategy strategy)
    {
        zzaJY = zzh1;
        zzaJW = message;
        zzaJX = strategy;
        super(googleapiclient);
    }
}
