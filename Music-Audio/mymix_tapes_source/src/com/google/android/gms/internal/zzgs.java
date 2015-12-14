// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.internal:
//            zzby, zzbu, zzgr

public final class zzgs
{

    private WeakHashMap zzFX;

    public zzgs()
    {
        zzFX = new WeakHashMap();
    }

    public zzgr zzD(Context context)
    {
    /* block-local class not found */
    class zza {}

        Object obj = (zza)zzFX.get(context);
        if (obj != null && !((zza) (obj)).hasExpired() && ((Boolean)zzby.zzuX.get()).booleanValue())
        {
            obj = (new zzgr.zza(context, ((zza) (obj)).zzFZ)).zzfN();
        } else
        {
            obj = (new zzgr.zza(context)).zzfN();
        }
        zzFX.put(context, new zza(((zzgr) (obj))));
        return ((zzgr) (obj));
    }
}
