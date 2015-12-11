// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcp, zzck, zzci

class zzaFc
    implements a
{

    final zzcp zzaFc;

    public void zza(com.google.android.gms.internal.e e, Set set, Set set1, zzck zzck1)
    {
        set.addAll(e.zzyC());
        set1.addAll(e.zzyD());
        zzck1.zzxc().zzc(e.zzyC(), e.zzyH());
        zzck1.zzxd().zzc(e.zzyD(), e.zzyI());
    }

    a(zzcp zzcp1)
    {
        zzaFc = zzcp1;
        super();
    }
}
