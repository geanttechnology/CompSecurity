// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.go;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class <init> extends <init>
{

    final RemoteMediaPlayer Ba;
    final GoogleApiClient Bb;
    final long Bc[];

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((gh));
    }

    protected void a(gh gh1)
    {
        gh1 = ((gh) (RemoteMediaPlayer.c(Ba)));
        gh1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.d(Ba).b(Bb);
        RemoteMediaPlayer.e(Ba).a(Bq, Bc);
        RemoteMediaPlayer.d(Ba).b(null);
_L1:
        gh1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        b(l(new Status(1)));
        RemoteMediaPlayer.d(Ba).b(null);
          goto _L1
        obj;
        gh1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.d(Ba).b(null);
        throw obj;
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, long al[])
    {
        Ba = remotemediaplayer;
        Bb = googleapiclient;
        Bc = al;
        super();
    }
}
