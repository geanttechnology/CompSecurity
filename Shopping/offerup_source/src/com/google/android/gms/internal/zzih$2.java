// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzr, zzih

class zzJb
    implements 
{

    final c zzJb;
    final zzih zzJc;
    final String zzyc;

    public void zze(zzr zzr1)
    {
        zzb.zzaH((new StringBuilder("Failed to load URL: ")).append(zzyc).append("\n").append(zzr1.toString()).toString());
        zzJb.zzb(null);
    }

    c(zzih zzih, String s, c c)
    {
        zzJc = zzih;
        zzyc = s;
        zzJb = c;
        super();
    }
}
