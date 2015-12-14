// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzja, zziz

class <init>
    implements zzdk
{

    final zzja zzKi;

    public void zza(zziz zziz, Map map)
    {
        if (map.keySet().contains("start"))
        {
            zzja.zza(zzKi);
        } else
        {
            if (map.keySet().contains("stop"))
            {
                zzja.zzb(zzKi);
                return;
            }
            if (map.keySet().contains("cancel"))
            {
                zzja.zzc(zzKi);
                return;
            }
        }
    }

    private (zzja zzja1)
    {
        zzKi = zzja1;
        super();
    }

    zzKi(zzja zzja1, zzKi zzki)
    {
        this(zzja1);
    }
}
