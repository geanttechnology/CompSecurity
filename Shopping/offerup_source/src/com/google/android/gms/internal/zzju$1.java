// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzjp, zzju

class eApiClient extends c
{

    final String zzRc;
    final UsageInfo zzRd[];
    final zzju zzRe;

    protected void zza(zzjp zzjp1)
    {
        zzjp1.zza(new d(this), zzRc, zzRd);
    }

    eApiClient(zzju zzju, GoogleApiClient googleapiclient, String s, UsageInfo ausageinfo[])
    {
        zzRe = zzju;
        zzRc = s;
        zzRd = ausageinfo;
        super(googleapiclient);
    }
}
