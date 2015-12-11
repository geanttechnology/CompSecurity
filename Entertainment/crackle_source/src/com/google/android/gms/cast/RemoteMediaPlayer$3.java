// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dl;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class <init> extends <init>
{

    final RemoteMediaPlayer lh;
    final GoogleApiClient li;
    final JSONObject lm;
    final long ln;
    final int lo;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((dg));
    }

    protected void a(dg dg1)
    {
        dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
        dg1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.d(lh).b(li);
        RemoteMediaPlayer.e(lh).a(lv, ln, lo, lm);
        RemoteMediaPlayer.d(lh).b(null);
_L1:
        dg1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        a(((com.google.android.gms.common.api.Result) (k(new Status(1)))));
        RemoteMediaPlayer.d(lh).b(null);
          goto _L1
        obj;
        dg1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.d(lh).b(null);
        throw obj;
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
    {
        lh = remotemediaplayer;
        li = googleapiclient;
        ln = l;
        lo = i;
        lm = jsonobject;
        super();
    }
}
