// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.SearchAuth;

// Referenced classes of package com.google.android.gms.internal:
//            zzqs, zzqr

class zzaUN extends zzaUN
{

    private final GoogleApiClient zzVs;
    private final String zzaUN;
    private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);

    static boolean zza(zzaUN zzaun)
    {
        return zzaun.zzaUQ;
    }

    protected volatile void zza(com.google.android.gms.common.api.aUQ auq)
    {
        zza((zzqs)auq);
    }

    protected void zza(zzqs zzqs1)
    {
        if (zzaUQ)
        {
            Log.d("SearchAuth", "ClearTokenImpl started");
        }
        String s = zzVs.getContext().getPackageName();
        class _cls1 extends zzqt.zza
        {

            final zzqt.zzb zzaUR;

            public void zzbb(Status status)
            {
                if (zzqt.zzb.zza(zzaUR))
                {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                zzaUR.zzb(status);
            }

            _cls1()
            {
                zzaUR = zzqt.zzb.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        ((zzqr)zzqs1.zzpc()).zzb(_lcls1, s, zzaUN);
    }

    protected Result zzb(Status status)
    {
        return zzd(status);
    }

    protected Status zzd(Status status)
    {
        if (zzaUQ)
        {
            Log.d("SearchAuth", (new StringBuilder("ClearTokenImpl received failure: ")).append(status.getStatusMessage()).toString());
        }
        return status;
    }

    protected piClient(GoogleApiClient googleapiclient, String s)
    {
        super(SearchAuth.zzRk, googleapiclient);
        zzVs = googleapiclient;
        zzaUN = s;
    }
}
