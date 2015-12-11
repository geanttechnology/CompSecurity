// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;


// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzb

class zzEh
    implements Runnable
{

    final zzb zzEh;

    public void run()
    {
label0:
        {
            synchronized (zzb.zza(zzEh))
            {
                if (zzEh.zzEg != null)
                {
                    break label0;
                }
            }
            return;
        }
        zzEh.onStop();
        zzb.zza(zzEh, 2, "Timed out waiting for ad response.");
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (zzb zzb1)
    {
        zzEh = zzb1;
        super();
    }
}
