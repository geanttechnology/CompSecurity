// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu, zzgy

public final class zzgz
{

    private WeakHashMap zzGO;

    public zzgz()
    {
        zzGO = new WeakHashMap();
    }

    public zzgy zzC(Context context)
    {
    /* block-local class not found */
    class zza {}

        Object obj = (zza)zzGO.get(context);
        if (obj != null && !((zza) (obj)).hasExpired() && ((Boolean)zzby.zzvm.get()).booleanValue())
        {
            obj = (new zzgy.zza(context, ((zza) (obj)).zzGQ)).zzfX();
        } else
        {
            obj = (new zzgy.zza(context)).zzfX();
        }
        zzGO.put(context, new zza(((zzgy) (obj))));
        return ((zzgy) (obj));
    }
}
