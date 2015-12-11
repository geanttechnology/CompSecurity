// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, BatchResult, GoogleApiClient, Status, 
//            Result

public final class Batch extends zzlc
{

    private boolean zzaaA;
    private final PendingResult zzaaB[];
    private int zzaay;
    private boolean zzaaz;
    private final Object zzpd;

    private Batch(List list, GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzpd = new Object();
        zzaay = list.size();
        zzaaB = new PendingResult[zzaay];
        for (int i = 0; i < list.size(); i++)
        {
            googleapiclient = (PendingResult)list.get(i);
            zzaaB[i] = googleapiclient;
            googleapiclient.zza(new _cls1());
        }

    }

    Batch(List list, GoogleApiClient googleapiclient, _cls1 _pcls1)
    {
        this(list, googleapiclient);
    }

    static Object zza(Batch batch)
    {
        return batch.zzpd;
    }

    static boolean zza(Batch batch, boolean flag)
    {
        batch.zzaaA = flag;
        return flag;
    }

    static int zzb(Batch batch)
    {
        int i = batch.zzaay;
        batch.zzaay = i - 1;
        return i;
    }

    static boolean zzb(Batch batch, boolean flag)
    {
        batch.zzaaz = flag;
        return flag;
    }

    static int zzc(Batch batch)
    {
        return batch.zzaay;
    }

    static boolean zzd(Batch batch)
    {
        return batch.zzaaA;
    }

    static void zze(Batch batch)
    {
        batch.zzlc.cancel();
    }

    static boolean zzf(Batch batch)
    {
        return batch.zzaaz;
    }

    static PendingResult[] zzg(Batch batch)
    {
        return batch.zzaaB;
    }

    public final void cancel()
    {
        super.cancel();
        PendingResult apendingresult[] = zzaaB;
        int j = apendingresult.length;
        for (int i = 0; i < j; i++)
        {
            apendingresult[i].cancel();
        }

    }

    public final BatchResult createFailedResult(Status status)
    {
        return new BatchResult(status, zzaaB);
    }

    public final Result zzb(Status status)
    {
        return createFailedResult(status);
    }

    private class _cls1
        implements PendingResult.zza
    {

        final Batch zzaaC;

        public void zzt(Status status)
        {
label0:
            {
                synchronized (Batch.zza(zzaaC))
                {
                    if (!zzaaC.isCanceled())
                    {
                        break label0;
                    }
                }
                return;
            }
            if (!status.isCanceled()) goto _L2; else goto _L1
_L1:
            Batch.zza(zzaaC, true);
_L8:
            Batch.zzb(zzaaC);
            if (Batch.zzc(zzaaC) != 0) goto _L4; else goto _L3
_L3:
            if (!Batch.zzd(zzaaC)) goto _L6; else goto _L5
_L5:
            Batch.zze(zzaaC);
_L4:
            obj;
            JVM INSTR monitorexit ;
            return;
            status;
            obj;
            JVM INSTR monitorexit ;
            throw status;
_L2:
            if (status.isSuccess()) goto _L8; else goto _L7
_L7:
            Batch.zzb(zzaaC, true);
              goto _L8
_L6:
            if (!Batch.zzf(zzaaC))
            {
                break MISSING_BLOCK_LABEL_146;
            }
            status = new Status(13);
_L9:
            zzaaC.zzb(new BatchResult(status, Batch.zzg(zzaaC)));
              goto _L4
            status = Status.zzabb;
              goto _L9
        }

        _cls1()
        {
            zzaaC = Batch.this;
            super();
        }
    }

}
