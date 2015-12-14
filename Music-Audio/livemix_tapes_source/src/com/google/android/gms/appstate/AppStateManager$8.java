// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzjn;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

static final class e extends e
{

    final int zzQt;
    final String zzQw;
    final byte zzQx[];

    protected volatile void zza(com.google.android.gms.common.api.<init> <init>1)
        throws RemoteException
    {
        zza((zzjn)<init>1);
    }

    protected void zza(zzjn zzjn1)
        throws RemoteException
    {
        zzjn1.zza(this, zzQt, zzQw, zzQx);
    }

    e(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        zzQt = i;
        zzQw = s;
        zzQx = abyte0;
        super(googleapiclient);
    }
}
