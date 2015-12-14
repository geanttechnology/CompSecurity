// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            CredentialsClientImpl, ICredentialsService

abstract class zzd extends com.google.android.gms.common.api.zza.zza
{

    zzd(GoogleApiClient googleapiclient)
    {
        super(Auth.CLIENT_KEY_CREDENTIALS_API, googleapiclient);
    }

    protected abstract void zza(Context context, ICredentialsService icredentialsservice);

    protected final void zza(CredentialsClientImpl credentialsclientimpl)
    {
        zza(credentialsclientimpl.getContext(), (ICredentialsService)credentialsclientimpl.zznM());
    }

    protected volatile void zza(com.google.android.gms.common.api.Api.Client client)
    {
        zza((CredentialsClientImpl)client);
    }
}
