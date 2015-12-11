// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzck, zzci, zzcp

class zzaYG
    implements a
{

    final zzcp zzaYG;

    public void zza(com.google.android.gms.internal.e e, Set set, Set set1, zzck zzck1)
    {
        set.addAll(e.zzEj());
        set1.addAll(e.zzEk());
        zzck1.zzDd().zzc(e.zzEj(), e.zzEo());
        zzck1.zzDe().zzc(e.zzEk(), e.zzEp());
    }

    a(zzcp zzcp)
    {
        zzaYG = zzcp;
        super();
    }
}
