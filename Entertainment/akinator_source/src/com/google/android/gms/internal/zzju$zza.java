// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzju, zzjt

private static final class zzRh
    implements com.google.android.gms.appindexing.pi.ActionResult
{

    private zzju zzRf;
    private PendingResult zzRg;
    private Action zzRh;

    public PendingResult end(GoogleApiClient googleapiclient)
    {
        Object obj = googleapiclient.getContext().getPackageName();
        long l = System.currentTimeMillis();
        obj = zzjt.zza(zzRh, l, ((String) (obj)), 2);
        return zzRf.zza(googleapiclient, new UsageInfo[] {
            obj
        });
    }

    public PendingResult getPendingResult()
    {
        return zzRg;
    }

    (zzju zzju1, PendingResult pendingresult, Action action)
    {
        zzRf = zzju1;
        zzRg = pendingresult;
        zzRh = action;
    }
}
