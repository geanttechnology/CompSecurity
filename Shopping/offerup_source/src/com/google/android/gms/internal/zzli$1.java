// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.zza;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzli

class zzacr
    implements e
{

    final zzli zzacr;

    public void zzc(f f)
    {
        zzacr.zzacm.remove(f);
        if (f.zznF() != null && com.google.android.gms.internal.zzli.zza(zzacr) != null)
        {
            com.google.android.gms.internal.zzli.zza(zzacr).remove(f.zznF().intValue());
        }
    }

    f(zzli zzli1)
    {
        zzacr = zzli1;
        super();
    }
}
