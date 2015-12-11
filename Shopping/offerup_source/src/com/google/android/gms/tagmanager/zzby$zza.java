// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzaq, zzby, zzbg

class zzaXO
    implements zzaXO
{

    final zzby zzaXO;

    public void zza(zzaq zzaq1)
    {
        zzby.zza(zzaXO, zzaq1.zzCV());
    }

    public void zzb(zzaq zzaq1)
    {
        zzby.zza(zzaXO, zzaq1.zzCV());
        zzbg.v((new StringBuilder("Permanent failure dispatching hitId: ")).append(zzaq1.zzCV()).toString());
    }

    public void zzc(zzaq zzaq1)
    {
        long l = zzaq1.zzCW();
        if (l == 0L)
        {
            zzby.zza(zzaXO, zzaq1.zzCV(), zzby.zza(zzaXO).currentTimeMillis());
        } else
        if (l + 0xdbba00L < zzby.zza(zzaXO).currentTimeMillis())
        {
            zzby.zza(zzaXO, zzaq1.zzCV());
            zzbg.v((new StringBuilder("Giving up on failed hitId: ")).append(zzaq1.zzCV()).toString());
            return;
        }
    }

    (zzby zzby1)
    {
        zzaXO = zzby1;
        super();
    }
}
