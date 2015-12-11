// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.v7.ns;
import android.support.v7.nt;
import android.support.v7.ul;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzj, zzc, zzp, zzi

public class zzl
    implements zzj
{

    public zzl()
    {
    }

    public zzi zza(Context context, ul ul1, int i, nt nt, ns ns)
    {
        return new zzc(context, new zzp(context, ul1.l(), ul1.getRequestId(), nt, ns));
    }
}
