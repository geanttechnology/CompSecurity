// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzb
    implements CredentialRequestResult
{

    private final Status zzSC;
    private final Credential zzSD;

    public zzb(Status status, Credential credential)
    {
        zzSC = status;
        zzSD = credential;
    }

    public static zzb zzh(Status status)
    {
        return new zzb(status, null);
    }

    public final Credential getCredential()
    {
        return zzSD;
    }

    public final Status getStatus()
    {
        return zzSC;
    }
}
