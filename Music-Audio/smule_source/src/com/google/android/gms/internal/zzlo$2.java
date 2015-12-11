// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzlo

class eApiClient extends a
{

    final int zzakf;
    final zzlo zzazp;
    final String zzazq;
    final Uri zzazr;
    final String zzazs;
    final String zzazt;

    protected volatile void zza(com.google.android.gms.common.api. )
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzakf, zzazq, zzazr, zzazs, zzazt);
    }

    eApiClient(zzlo zzlo1, GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        zzazp = zzlo1;
        zzakf = i;
        zzazq = s;
        zzazr = uri;
        zzazs = s1;
        zzazt = s2;
        super(googleapiclient, null);
    }
}
