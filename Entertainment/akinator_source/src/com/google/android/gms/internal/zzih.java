// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzac, zzl, zziq

public class zzih
{

    private static zzl zzIZ;
    public static final zza zzJa = new _cls1();
    private static final Object zzpy = new Object();

    public zzih(Context context)
    {
        zzIZ = zzP(context);
    }

    private static zzl zzP(Context context)
    {
        synchronized (zzpy)
        {
            if (zzIZ == null)
            {
                zzIZ = zzac.zza(context.getApplicationContext());
            }
            context = zzIZ;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public zziq zza(String s, zza zza1)
    {
    /* block-local class not found */
    class zzc {}

        zzc zzc1 = new zzc(null);
    /* block-local class not found */
    class zzb {}

        zzIZ.zze(new zzb(s, zza1, zzc1));
        return zzc1;
    }

    public zziq zza(String s, Map map)
    {
        zzc zzc1 = new zzc(null);
        s = new _cls3(s, zzc1, new _cls2(s, zzc1), map);
        zzIZ.zze(s);
        return zzc1;
    }


    // Unreferenced inner class com/google/android/gms/internal/zzih$zza
    /* block-local class not found */
    class zza {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
