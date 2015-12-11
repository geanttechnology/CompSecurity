// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.List;

// Referenced classes of package com.google.android.gms.common.api:
//            AbstractPendingResult, PendingResult, BatchResult, Status, 
//            Result

public final class Batch extends AbstractPendingResult
{

    private int zzPr;
    private boolean zzPs;
    private boolean zzPt;
    private final PendingResult zzPu[];
    private final Object zzoe;

    private Batch(List list, Looper looper)
    {
        super(new AbstractPendingResult.CallbackHandler(looper));
        zzoe = new Object();
        zzPr = list.size();
        zzPu = new PendingResult[zzPr];
        for (int i = 0; i < list.size(); i++)
        {
            looper = (PendingResult)list.get(i);
            zzPu[i] = looper;
            looper.addBatchCallback(new PendingResult.BatchCallback() {

                final Batch zzPv;

                public void zzl(Status status)
                {
label0:
                    {
                        synchronized (Batch.zza(zzPv))
                        {
                            if (!zzPv.isCanceled())
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    if (!status.isCanceled()) goto _L2; else goto _L1
_L1:
                    Batch.zza(zzPv, true);
_L8:
                    Batch.zzb(zzPv);
                    if (Batch.zzc(zzPv) != 0) goto _L4; else goto _L3
_L3:
                    if (!Batch.zzd(zzPv)) goto _L6; else goto _L5
_L5:
                    Batch.zze(zzPv);
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
                    Batch.zzb(zzPv, true);
                      goto _L8
_L6:
                    if (!Batch.zzf(zzPv))
                    {
                        break MISSING_BLOCK_LABEL_146;
                    }
                    status = new Status(13);
_L9:
                    zzPv.setResult(new BatchResult(status, Batch.zzg(zzPv)));
                      goto _L4
                    status = Status.zzQU;
                      goto _L9
                }

            
            {
                zzPv = Batch.this;
                super();
            }
            });
        }

    }


    static Object zza(Batch batch)
    {
        return batch.zzoe;
    }

    static boolean zza(Batch batch, boolean flag)
    {
        batch.zzPt = flag;
        return flag;
    }

    static int zzb(Batch batch)
    {
        int i = batch.zzPr;
        batch.zzPr = i - 1;
        return i;
    }

    static boolean zzb(Batch batch, boolean flag)
    {
        batch.zzPs = flag;
        return flag;
    }

    static int zzc(Batch batch)
    {
        return batch.zzPr;
    }

    static boolean zzd(Batch batch)
    {
        return batch.zzPt;
    }

    static void zze(Batch batch)
    {
        batch.AbstractPendingResult.cancel();
    }

    static boolean zzf(Batch batch)
    {
        return batch.zzPs;
    }

    static PendingResult[] zzg(Batch batch)
    {
        return batch.zzPu;
    }

    public void cancel()
    {
        super.cancel();
        PendingResult apendingresult[] = zzPu;
        int j = apendingresult.length;
        for (int i = 0; i < j; i++)
        {
            apendingresult[i].cancel();
        }

    }

    public BatchResult createFailedResult(Status status)
    {
        return new BatchResult(status, zzPu);
    }

    public volatile Result createFailedResult(Status status)
    {
        return createFailedResult(status);
    }
}
