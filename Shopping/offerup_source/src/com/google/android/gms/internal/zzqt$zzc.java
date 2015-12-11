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

class zzaUS extends zzaUS
{

    private final GoogleApiClient zzVs;
    private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);
    private final String zzaUS;

    static boolean zza(zzaUS zzaus)
    {
        return zzaus.zzaUQ;
    }

    protected volatile void zza(com.google.android.gms.common.api.aUQ auq)
    {
        zza((zzqs)auq);
    }

    protected void zza(zzqs zzqs1)
    {
        if (zzaUQ)
        {
            Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
        }
        String s = zzVs.getContext().getPackageName();
        class _cls1 extends zzqt.zza
        {

            final zzqt.zzc zzaUT;

            public void zza(Status status, GoogleNowAuthState googlenowauthstate)
            {
                if (zzqt.zzc.zza(zzaUT))
                {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                zzaUT.zzb(new zzqt.zzd(status, googlenowauthstate));
            }

            _cls1()
            {
                zzaUT = zzqt.zzc.this;
                super();
            }
        }

        _cls1 _lcls1 = new _cls1();
        ((zzqr)zzqs1.zzpc()).zza(_lcls1, s, zzaUS);
    }

    protected Result zzb(Status status)
    {
        return zzbc(status);
    }

    protected com.google.android.gms.search.hApi.GoogleNowAuthResult zzbc(Status status)
    {
        if (zzaUQ)
        {
            Log.d("SearchAuth", (new StringBuilder("GetGoogleNowAuthImpl received failure: ")).append(status.getStatusMessage()).toString());
        }
        return new <init>(status, null);
    }

    protected piClient(GoogleApiClient googleapiclient, String s)
    {
        super(SearchAuth.zzRk, googleapiclient);
        zzVs = googleapiclient;
        zzaUS = s;
    }
}
