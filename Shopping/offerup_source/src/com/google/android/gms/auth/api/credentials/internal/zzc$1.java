// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzd, zzh, zzb, zzc

class nit> extends zzd
{

    final CredentialRequest zzSE;
    final zzc zzSF;

    protected void zza(Context context, zzh zzh1)
    {
        class _cls1 extends zza
        {

            final zzc._cls1 zzSG;

            public void zza(Status status, Credential credential)
            {
                zzSG.zzb(new zzb(status, credential));
            }

            public void zzg(Status status)
            {
                zzSG.zzb(com.google.android.gms.auth.api.credentials.internal.zzb.zzh(status));
            }

            _cls1()
            {
                zzSG = zzc._cls1.this;
                super();
            }
        }

        zzh1.zza(new _cls1(), zzSE);
    }

    protected Result zzb(Status status)
    {
        return zzi(status);
    }

    protected CredentialRequestResult zzi(Status status)
    {
        return com.google.android.gms.auth.api.credentials.internal.zzb.zzh(status);
    }

    st(zzc zzc, GoogleApiClient googleapiclient, CredentialRequest credentialrequest)
    {
        zzSF = zzc;
        zzSE = credentialrequest;
        super(googleapiclient);
    }
}
