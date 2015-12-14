// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzh, zzg

class a extends a
{

    final Strategy zzaJX;
    final zzh zzaJY;
    final MessageListener zzaJZ;
    final MessageFilter zzaKa;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzg)b);
    }

    protected void zza(zzg zzg1)
        throws RemoteException
    {
        zzg1.zza(this, zzaJZ, zzaJX, zzaKa);
    }

    (zzh zzh1, GoogleApiClient googleapiclient, MessageListener messagelistener, Strategy strategy, MessageFilter messagefilter)
    {
        zzaJY = zzh1;
        zzaJZ = messagelistener;
        zzaJX = strategy;
        zzaKa = messagefilter;
        super(googleapiclient);
    }
}
