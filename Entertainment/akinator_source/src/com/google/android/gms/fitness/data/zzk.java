// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.fitness.data:
//            DataPoint

public class zzk extends zzj.zza
{
    public static class zza
    {

        private static final zza zzaqQ = new zza();
        private final Map zzaqR = new HashMap();

        public static zza zzsx()
        {
            return zzaqQ;
        }

        public zzk zza(OnDataPointListener ondatapointlistener)
        {
            Map map = zzaqR;
            map;
            JVM INSTR monitorenter ;
            zzk zzk2 = (zzk)zzaqR.get(ondatapointlistener);
            zzk zzk1;
            zzk1 = zzk2;
            if (zzk2 != null)
            {
                break MISSING_BLOCK_LABEL_51;
            }
            zzk1 = new zzk(ondatapointlistener);
            zzaqR.put(ondatapointlistener, zzk1);
            map;
            JVM INSTR monitorexit ;
            return zzk1;
            ondatapointlistener;
            map;
            JVM INSTR monitorexit ;
            throw ondatapointlistener;
        }

        public zzk zzb(OnDataPointListener ondatapointlistener)
        {
            synchronized (zzaqR)
            {
                ondatapointlistener = (zzk)zzaqR.get(ondatapointlistener);
            }
            return ondatapointlistener;
            ondatapointlistener;
            map;
            JVM INSTR monitorexit ;
            throw ondatapointlistener;
        }

        public zzk zzc(OnDataPointListener ondatapointlistener)
        {
            Map map = zzaqR;
            map;
            JVM INSTR monitorenter ;
            zzk zzk1 = (zzk)zzaqR.remove(ondatapointlistener);
            if (zzk1 == null)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            map;
            JVM INSTR monitorexit ;
            return zzk1;
            ondatapointlistener = new zzk(ondatapointlistener);
            map;
            JVM INSTR monitorexit ;
            return ondatapointlistener;
            ondatapointlistener;
            map;
            JVM INSTR monitorexit ;
            throw ondatapointlistener;
        }


        private zza()
        {
        }
    }


    private final OnDataPointListener zzaqP;

    private zzk(OnDataPointListener ondatapointlistener)
    {
        zzaqP = (OnDataPointListener)zzx.zzw(ondatapointlistener);
    }


    public void zzc(DataPoint datapoint)
        throws RemoteException
    {
        zzaqP.onDataPoint(datapoint);
    }
}
