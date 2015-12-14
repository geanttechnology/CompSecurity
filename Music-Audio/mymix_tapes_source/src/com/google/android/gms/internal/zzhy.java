// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zzih

public class zzhy
{

    private static zzl zzIf;
    public static final zza zzIg = new _cls1();
    private static final Object zzpm = new Object();

    public zzhy(Context context)
    {
        zzIf = zzP(context);
    }

    private static zzl zzP(Context context)
    {
        synchronized (zzpm)
        {
            if (zzIf == null)
            {
                zzIf = zzac.zza(context.getApplicationContext());
            }
            context = zzIf;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public zzih zza(String s, zza zza1)
    {
    /* block-local class not found */
    class zzc {}

        zzc zzc1 = new zzc(null);
    /* block-local class not found */
    class zzb {}

        zzIf.zze(new zzb(s, zza1, zzc1));
        return zzc1;
    }

    public zzih zzb(String s, Map map)
    {
        zzc zzc1 = new zzc(null);
        s = new _cls3(s, zzc1, new _cls2(s, zzc1), map);
        zzIf.zze(s);
        return zzc1;
    }


    // Unreferenced inner class com/google/android/gms/internal/zzhy$zza
    /* block-local class not found */
    class zza {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
