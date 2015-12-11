// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.common.api:
//            GoogleApiClient

class nq
    implements nnectionCallbacks
{

    final GoogleApiClient nq;

    public void onConnected(Bundle bundle)
    {
        Object obj = GoogleApiClient.c(nq);
        obj;
        JVM INSTR monitorenter ;
        if (GoogleApiClient.d(nq) != 1)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        GoogleApiClient.e(nq).putAll(bundle);
        GoogleApiClient.f(nq);
        obj;
        JVM INSTR monitorexit ;
        return;
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    public void onConnectionSuspended(int i)
    {
        Object obj = GoogleApiClient.c(nq);
        obj;
        JVM INSTR monitorenter ;
        GoogleApiClient.a(nq, i);
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        nq.connect();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    nnectionCallbacks(GoogleApiClient googleapiclient)
    {
        nq = googleapiclient;
        super();
    }
}
