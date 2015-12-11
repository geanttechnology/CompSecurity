// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzg, DeleteRequest, SaveRequest

public interface zzh
    extends IInterface
{

    public abstract void zza(zzg zzg);

    public abstract void zza(zzg zzg, CredentialRequest credentialrequest);

    public abstract void zza(zzg zzg, DeleteRequest deleterequest);

    public abstract void zza(zzg zzg, SaveRequest saverequest);
}
