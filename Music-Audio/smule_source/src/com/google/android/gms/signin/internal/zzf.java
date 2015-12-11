// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzr;

// Referenced classes of package com.google.android.gms.signin.internal:
//            zze, CheckServerAuthResult

public interface zzf
    extends IInterface
{

    public abstract void zza(int i, Account account, zze zze);

    public abstract void zza(AuthAccountRequest authaccountrequest, zze zze);

    public abstract void zza(ResolveAccountRequest resolveaccountrequest, zzr zzr);

    public abstract void zza(zzo zzo, int i, boolean flag);

    public abstract void zza(CheckServerAuthResult checkserverauthresult);

    public abstract void zzag(boolean flag);

    public abstract void zzhB(int i);
}
