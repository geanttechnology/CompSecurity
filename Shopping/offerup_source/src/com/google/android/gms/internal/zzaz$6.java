// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzaz, zziz

class zzrw
    implements zzdk
{

    final zzaz zzrw;

    public void zza(zziz zziz1, Map map)
    {
        if (!zzrw.zzb(map))
        {
            return;
        } else
        {
            zzrw.zza(zziz1.getView(), map);
            return;
        }
    }

    (zzaz zzaz1)
    {
        zzrw = zzaz1;
        super();
    }
}
