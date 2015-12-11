// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dv;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class <init> extends <init>
{

    final RemoteMediaPlayer xk;
    final GoogleApiClient xl;
    final JSONObject xp;

    protected volatile void a(com.google.android.gms.common.api. )
        throws RemoteException
    {
        a((dq));
    }

    protected void a(dq dq1)
    {
        dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
        dq1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.d(xk).b(xl);
        RemoteMediaPlayer.e(xk).b(xy, xp);
        RemoteMediaPlayer.d(xk).b(null);
_L1:
        dq1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a(((com.google.android.gms.common.api.Result) (j(new Status(1)))));
        RemoteMediaPlayer.d(xk).b(null);
          goto _L1
        obj;
        dq1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.d(xk).b(null);
        throw obj;
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        xk = remotemediaplayer;
        xl = googleapiclient;
        xp = jsonobject;
        super();
    }
}
