// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;

// Referenced classes of package com.google.android.gms.internal:
//            zzpt, zzpw, zzpu, zzps

static abstract class singData extends zzpt
{

    protected zzpu zzaNI;

    protected Result zzb(Status status)
    {
        return zzbb(status);
    }

    protected com.google.android.gms.safetynet.Api.SafeBrowsingResult zzbb(Status status)
    {
        return new <init>(status, null);
    }

    public piClient(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
        zzaNI = new zzps() {

            final zzpw.zzc zzaNK;

            public void zza(Status status, SafeBrowsingData safebrowsingdata)
            {
                zzaNK.zza(new zzpw.zzd(status, safebrowsingdata));
            }

            
            {
                zzaNK = zzpw.zzc.this;
                super();
            }
        };
    }
}
