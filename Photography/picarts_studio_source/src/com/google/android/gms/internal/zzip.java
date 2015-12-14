// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zziq

public class zzip
{

    public static zziq zza(zziq zziq1, zza zza1)
    {
        zzin zzin1 = new zzin();
        zziq1.zzc(new Runnable(zzin1, zza1, zziq1) {

            final zzin zzJB;
            final zza zzJC;
            final zziq zzJD;

            public final void run()
            {
                try
                {
                    zzJB.zzf(zzJC.zze(zzJD.get()));
                    return;
                }
                catch (CancellationException cancellationexception) { }
                catch (InterruptedException interruptedexception) { }
                catch (ExecutionException executionexception) { }
                zzJB.cancel(true);
            }

            
            {
                zzJB = zzin1;
                zzJC = zza1;
                zzJD = zziq1;
                super();
            }

            private class zza
            {

                public abstract Object zze(Object obj);
            }

        });
        return zzin1;
    }

    public static zziq zzh(List list)
    {
        zzin zzin1 = new zzin();
        int i = list.size();
        AtomicInteger atomicinteger = new AtomicInteger(0);
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((zziq)iterator.next()).zzc(new Runnable(atomicinteger, i, zzin1, list) {

        final AtomicInteger zzJE;
        final int zzJF;
        final zzin zzJG;
        final List zzJH;

        public final void run()
        {
            if (zzJE.incrementAndGet() < zzJF)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            zzJG.zzf(zzip.zzj(zzJH));
            return;
            Object obj;
            obj;
_L2:
            zzb.zzd("Unable to convert list of futures to a future of list", ((Throwable) (obj)));
            return;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                zzJE = atomicinteger;
                zzJF = i;
                zzJG = zzin1;
                zzJH = list;
                super();
            }
    })) { }
        return zzin1;
    }

    private static List zzi(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = ((zziq)list.next()).get();
            if (obj != null)
            {
                arraylist.add(obj);
            }
        } while (true);
        return arraylist;
    }

    static List zzj(List list)
    {
        return zzi(list);
    }
}
